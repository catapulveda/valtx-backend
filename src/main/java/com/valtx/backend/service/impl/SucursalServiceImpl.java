package com.valtx.backend.service.impl;

import com.valtx.backend.entities.SucursalEntity;
import com.valtx.backend.exception.ResourceNotFoundException;
import com.valtx.backend.mapper.SucursalMapper;
import com.valtx.backend.models.Sucursal;
import com.valtx.backend.repository.SucursalRepository;
import com.valtx.backend.service.SucursalService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SucursalServiceImpl implements SucursalService {

    private SucursalRepository repository;
    private SucursalMapper sucursalMapper;

    public SucursalServiceImpl(SucursalRepository repository, SucursalMapper sucursalMapper) {
        this.repository = repository;
        this.sucursalMapper = sucursalMapper;
    }

    @Override
    public Sucursal insert(Sucursal request) {
        SucursalEntity sucursalEntity = sucursalMapper.toSucursalEntity(request);
        repository.save(sucursalEntity);
        return sucursalMapper.toSucursalRequest(sucursalEntity);
    }

    @Override
    public Sucursal update(String id, Sucursal sucursal) {
        SucursalEntity sucursalEntity = repository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("LA SUCURSAL NO EXISTE"));

        sucursalEntity.setNombre(sucursal.getNombre());
        repository.save(sucursalEntity);
        return sucursalMapper.toSucursalRequest(sucursalEntity);
    }

    @Override
    public Sucursal findById(String id) {
        SucursalEntity sucursalEntity = repository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("LA SUCURSAL NO EXISTE"));

        return sucursalMapper.toSucursalRequest(sucursalEntity);
    }

    @Override
    public List<Sucursal> findAll() {
        List<SucursalEntity> entities = repository.findAll();
        return sucursalMapper.toSucursalList(entities);
    }

    @Override
    public Boolean delete(String id) {
        SucursalEntity sucursalEntity = repository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("LA SUCURSAL NO EXISTE"));
        repository.delete(sucursalEntity);
        return Boolean.TRUE;
    }
}
