package com.valtx.backend.mapper;

import com.valtx.backend.entities.ProductoEntity;
import com.valtx.backend.models.Producto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductoMapper {

    Producto toProducto(ProductoEntity entity);

    ProductoEntity toProductoEntity(Producto producto);

    List<Producto> toProductoList(List<ProductoEntity> entities);
}
