package com.valtx.backend.controller;

import com.valtx.backend.models.Producto;
import com.valtx.backend.service.ProductoService;
import com.valtx.backend.service.ProductoService;
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

@RequestMapping(value = "/productos")
@RestController
public class ProductoController {

    private ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody
    Producto insert(@Valid @RequestBody Producto request) {
        return productoService.insert(request);
    }

    @PutMapping(value = "/{productoId}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    Producto update(
            @NotNull @PathVariable(name = "productoId") String productoId,
            @Valid @RequestBody Producto request
    ) {
        return productoService.update(productoId, request);
    }

    @DeleteMapping(value = "/{productoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public @ResponseBody
    Boolean delete(@NotNull @PathVariable(name = "productoId") String productoId) {
        return productoService.delete(productoId);
    }

    @GetMapping(value = "/{productoId}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    Producto findById(@NotNull @PathVariable(name = "productoId") String productoId) {
        return productoService.findById(productoId);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<Producto> findAll() {
        return productoService.findAll();
    }

}
