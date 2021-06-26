package com.valtx.backend.service.impl;

import com.valtx.backend.entities.SucursalEntity;
import com.valtx.backend.entities.UsuarioEntity;
import com.valtx.backend.exception.ResourceNotFoundException;
import com.valtx.backend.mapper.SucursalMapper;
import com.valtx.backend.mapper.UsuarioMapper;
import com.valtx.backend.models.Usuario;
import com.valtx.backend.repository.SucursalRepository;
import com.valtx.backend.repository.UsuarioRepository;
import com.valtx.backend.service.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private SucursalRepository sucursalRepository;
    private UsuarioRepository repository;
    private UsuarioMapper usuarioMapper;
    private SucursalMapper sucursalMapper;

    public UsuarioServiceImpl(SucursalRepository sucursalRepository, UsuarioRepository repository, UsuarioMapper usuarioMapper, SucursalMapper sucursalMapper) {
        this.sucursalRepository = sucursalRepository;
        this.repository = repository;
        this.usuarioMapper = usuarioMapper;
        this.sucursalMapper = sucursalMapper;
    }

    @Override
    public Usuario insert(Usuario usuario) {
        SucursalEntity sucursalEntity = sucursalRepository
                .findById(usuario.getSucursal().getCodigoSucursal())
                .orElseThrow(() -> new ResourceNotFoundException("LA SUCURSAL NO EXISTE"));

        UsuarioEntity usuarioEntity = usuarioMapper.toUsuarioEntity(usuario);
        usuarioEntity.setSucursal(sucursalEntity);

        repository.save(usuarioEntity);

        Usuario usuarioResponse = usuarioMapper.toUsuario(usuarioEntity);
        usuarioResponse.setSucursal(sucursalMapper.toSucursalRequest(sucursalEntity));

        return usuarioResponse;
    }

    @Override
    public Usuario update(String id, Usuario usuario) {
        UsuarioEntity usuarioEntity = repository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("EL USUARIO NO EXISTE"));

        SucursalEntity sucursalEntity = sucursalRepository
                .findById(usuario.getSucursal().getCodigoSucursal())
                .orElseThrow(() -> new ResourceNotFoundException("LA SUCURSAL NO EXISTE"));

        usuarioEntity = usuarioMapper.toUsuarioEntity(usuario);
        usuarioEntity.setCodigoUsuario(id);
        usuarioEntity.setSucursal(sucursalEntity);

        return usuarioMapper.toUsuario(repository.save(usuarioEntity));
    }

    @Override
    public Usuario findById(String id) {
        UsuarioEntity usuarioEntity = repository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("EL USUARIO NO EXISTE"));
        return usuarioMapper.toUsuario(usuarioEntity);
    }

    @Override
    public List<Usuario> findAll() {
        List<UsuarioEntity> entities = repository.findAll();
        entities.forEach(usuarioEntity -> usuarioEntity.setPassword(null));
        return usuarioMapper.toUsuarioList(entities);
    }

    @Override
    public Boolean delete(String id) {
        UsuarioEntity usuarioEntity = repository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("EL USUARIO NO EXISTE"));
        repository.delete(usuarioEntity);
        return Boolean.TRUE;
    }
}
