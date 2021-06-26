package com.valtx.backend.controller;

import com.valtx.backend.models.Sucursal;
import com.valtx.backend.models.Usuario;
import com.valtx.backend.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RequestMapping(value = "/usuarios")
@RestController
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody
    Usuario insert(@Valid @RequestBody Usuario request) {
        return usuarioService.insert(request);
    }

    @PutMapping(value = "/{usuarioId}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    Usuario update(
            @NotNull @PathVariable(name = "usuarioId") String usuarioId,
            @Valid @RequestBody Usuario request
    ) {
        return usuarioService.update(usuarioId, request);
    }

    @DeleteMapping(value = "/{usuarioId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public @ResponseBody
    Boolean delete(@NotNull @PathVariable(name = "usuarioId") String usuarioId) {
        return usuarioService.delete(usuarioId);
    }

    @GetMapping(value = "/{usuarioId}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    Usuario findById(@NotNull @PathVariable(name = "usuarioId") String usuarioId) {
        return usuarioService.findById(usuarioId);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<Usuario> findAll() {
        return usuarioService.findAll();
    }


}
