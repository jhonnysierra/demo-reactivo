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
        // Pruebas de lo que viene en el request desde que se hace el llamado al endpoint
        System.out.println("Server Request: " + request.path());
        System.out.println("Server Request: " + request.methodName());
        System.out.println("Server Request: " + request.headers().firstHeader("User-Agent"));
        List<Producto> productos = Arrays.asList(new Producto(1, "PC"), new Producto(2, "TV"), new Producto(3, "Netflix"));
        /**
         * ok() -> devuelve un 200
         * contentType -> Tipo de respuesta, para esta caso un JSON
         */
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(productos);
    }
}
