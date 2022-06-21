package com.jhonny.controller;

import com.jhonny.model.Producto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @GetMapping()
    public Flux<Producto> buscarTodos() {

        List<Producto> productos = Arrays.asList(new Producto(1, "PC"), new Producto(2, "TV"), new Producto(3, "Netflix"));

        /**
         * Operador reactivo de creacion, permite crear un flujo reactivo a partir de elementos existentes
         * Un Flux es una secuencia infinita o finita de datos
         */
        Flux<Producto> productosFlux = Flux.fromIterable(productos);

        return productosFlux;
    }
}
