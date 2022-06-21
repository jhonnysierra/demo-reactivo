package com.jhonny;

import com.jhonny.controller.ProductoHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * Clase que permite administrar las rutas de la aplicacion
 */
@Configuration
public class RouterConfig {
    /**
     * Funcion que permite asignar la ruta a una funcion del controlador
     * request -> productoHandler.buscarProductos(request) = productoHandler::buscarProductos
     *
     * @param productoHandler
     * @return
     */
    @Bean
    public RouterFunction<ServerResponse> routes(ProductoHandler productoHandler){
        return route(GET("/v2/productos"), productoHandler::buscarProductos);
    }
}
