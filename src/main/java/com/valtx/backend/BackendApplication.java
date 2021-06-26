package com.valtx.backend;

import com.valtx.backend.models.Producto;
import com.valtx.backend.models.Sucursal;
import com.valtx.backend.models.Usuario;
import com.valtx.backend.repository.SucursalRepository;
import com.valtx.backend.service.ProductoService;
import com.valtx.backend.service.SucursalService;
import com.valtx.backend.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    private final SucursalService sucursalService;
    private UsuarioService usuarioService;
    private ProductoService productoService;

    public BackendApplication(SucursalService sucursalService, UsuarioService usuarioService, ProductoService productoService) {
        this.sucursalService = sucursalService;
        this.usuarioService = usuarioService;
        this.productoService = productoService;
    }

    @Override
    public void run(String... args) throws Exception {
        sucursalService.insert(new Sucursal("01", "SUCURSAL UNO"));
        sucursalService.insert(new Sucursal("02", "SUCURSAL DOS"));
        sucursalService.insert(new Sucursal("03", "SUCURSAL TRES"));

        productoService.insert(new Producto("01", "Producto UNO", 1000d));
        productoService.insert(new Producto("02", "Producto DOS", 2000d));
        productoService.insert(new Producto("03", "Producto TRES", 3000d));

        usuarioService.insert(new Usuario("01", "NELSON CASTIBLANCO", "catapulveda", "password", new Sucursal("01", null)));
        usuarioService.insert(new Usuario("02", "JHON ALCANTARA", "alcantara", "alcantara", new Sucursal("02", null)));
        usuarioService.insert(new Usuario("03", "PEDRO PEREZ", "pedro", "password", new Sucursal("03", null)));
    }
}
