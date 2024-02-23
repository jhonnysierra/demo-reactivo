package com.jhonny.controller;

import com.jhonny.model.Producto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    int idProduct = 0;
    private static final Logger logger = LoggerFactory.getLogger(ProductoController.class);
    @GetMapping()
    public Flux<Producto> buscarTodos() {

        List<Producto> productos = Arrays.asList(new Producto(1, "PC ASUS"),
                new Producto(2, "TV"),
                new Producto(3, "Netflix"),
                new Producto(4, "Redmi Note 11"));

        /**
         * Operador reactivo de creacion, permite crear un flujo reactivo a partir de elementos existentes
         * Un Flux es una secuencia infinita o finita de datos
         */
        Flux<Producto> productosFlux = Flux.fromIterable(productos);

        logger.info("Datos de la lista: ");
        productosFlux.subscribe(System.out::println);
        Mono<Producto> productoMono = productosFlux.filter(producto -> producto.getId()==2).next();
        logger.info("Datos encontrados con id {}: ", 2);
        productoMono.subscribe(System.out::println);

/*        productoMono.subscribe(temp->{
            idProducto(temp.getId());
        } );

*/

        logger.info("ID Local Variable: {}", idProducto2(productoMono));
        //System.out.println("ID Local Variable: " + idProducto2(productoMono));
        //System.out.println(String.format("%s %s", "jhonny", "sierra"));

        if (productoMono.map(temp->temp.getId()).toString().equals("1")){
            System.out.println("In to IF sentence");

        }

        return productosFlux;
    }

    public int idProducto(Mono<Producto> productoMono){
        Producto producto = new Producto();
        productoMono.subscribe(temp->{
            producto.setId(temp.getId());
        } );
        return producto.getId();
    }

    public int idProducto2(Mono<Producto> productoMono){
        AtomicInteger producto = new AtomicInteger();
        productoMono.subscribe(temp->{
            producto.set(temp.getId());
        } );
        return producto.get();
    }
}
