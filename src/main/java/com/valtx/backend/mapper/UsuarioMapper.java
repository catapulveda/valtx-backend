package com.valtx.backend.mapper;

import com.valtx.backend.entities.UsuarioEntity;
import com.valtx.backend.models.Usuario;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    UsuarioEntity toUsuarioEntity(Usuario usuario);

    Usuario toUsuario(UsuarioEntity usuario);

    List<Usuario> toUsuarioList(List<UsuarioEntity> entities);

}
