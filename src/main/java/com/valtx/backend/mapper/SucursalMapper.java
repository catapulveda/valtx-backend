package com.valtx.backend.mapper;

import com.valtx.backend.entities.SucursalEntity;
import com.valtx.backend.models.Sucursal;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SucursalMapper {

    SucursalEntity toSucursalEntity(Sucursal request);

    Sucursal toSucursalRequest(SucursalEntity request);

    List<Sucursal> toSucursalList(List<SucursalEntity> entities);
}
