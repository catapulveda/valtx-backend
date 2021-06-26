package com.valtx.backend.service.impl;

import com.valtx.backend.entities.ProductoEntity;
import com.valtx.backend.exception.ResourceNotFoundException;
import com.valtx.backend.mapper.ProductoMapper;
import com.valtx.backend.models.Producto;
import com.valtx.backend.repository.ProductoRepository;
import com.valtx.backend.service.ProductoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {
    
    private ProductoRepository repository;
    private ProductoMapper productoMapper;

    public ProductoServiceImpl(ProductoRepository repository, ProductoMapper productoMapper) {
        this.repository = repository;
        this.productoMapper = productoMapper;
    }

    @Override
    public Producto insert(Producto request) {
        ProductoEntity ProductoEntity = productoMapper.toProductoEntity(request);
        repository.save(ProductoEntity);
        return productoMapper.toProducto(ProductoEntity);
    }

    @Override
    public Producto update(String id, Producto producto) {
        ProductoEntity productoEntity = repository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("EL PRODUCTO NO EXISTE"));
        productoEntity = productoMapper.toProductoEntity(producto);
        productoEntity.setCodigoProducto(id);
        repository.save(productoEntity);
        return productoMapper.toProducto(productoEntity);
    }

    @Override
    public Producto findById(String id) {
        ProductoEntity ProductoEntity = repository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("EL PRODUCTO NO EXISTE"));

        return productoMapper.toProducto(ProductoEntity);
    }

    @Override
    public List<Producto> findAll() {
        List<ProductoEntity> entities = repository.findAll();
        return productoMapper.toProductoList(entities);
    }

    @Override
    public Boolean delete(String id) {
        ProductoEntity ProductoEntity = repository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("EL PRODUCTO NO EXISTE"));
        repository.delete(ProductoEntity);
        return Boolean.TRUE;
    }
}
