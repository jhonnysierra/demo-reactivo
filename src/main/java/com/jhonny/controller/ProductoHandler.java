package com.jhonny.controller;

import com.jhonny.model.Producto;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@Component
public class ProductoHandler {

    public Mono<ServerResponse> buscarProductos(ServerRequest request){

        List<Producto> productos = Arrays.asList(new Producto(1, "PC"), new Producto(2, "TV"), new Producto(3, "Netflix"));
        Producto producto = new Producto(1, "PC");
        /**
         * ok() -> devuelve un 200
         * contentType -> Tipo de respuesta, para esta caso un JSON
         */
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(producto, Producto.class);
    }
}
