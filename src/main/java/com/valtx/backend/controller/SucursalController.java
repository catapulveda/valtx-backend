package com.valtx.backend.controller;

import com.valtx.backend.models.Sucursal;
import com.valtx.backend.service.SucursalService;
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

@RequestMapping(value = "/sucursal")
@RestController
public class SucursalController {

    private SucursalService sucursalService;

    public SucursalController(SucursalService sucursalService) {
        this.sucursalService = sucursalService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody
    Sucursal insert(@Valid @RequestBody Sucursal request) {
        return sucursalService.insert(request);
    }

    @PutMapping(value = "/{sucursalId}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    Sucursal update(
            @NotNull @PathVariable(name = "sucursalId") String sucursalId,
            @Valid @RequestBody Sucursal request
    ) {
        return sucursalService.update(sucursalId, request);
    }

    @DeleteMapping(value = "/{sucursalId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public @ResponseBody
    Boolean delete(@NotNull @PathVariable(name = "sucursalId") String sucursalId) {
        return sucursalService.delete(sucursalId);
    }

    @GetMapping(value = "/{sucursalId}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    Sucursal findById(@NotNull @PathVariable(name = "sucursalId") String sucursalId) {
        return sucursalService.findById(sucursalId);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<Sucursal> findAll() {
        return sucursalService.findAll();
    }

}
