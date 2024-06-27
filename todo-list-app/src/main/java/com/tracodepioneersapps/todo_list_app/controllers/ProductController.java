package com.tracodepioneersapps.todo_list_app.controllers;

import com.tracodepioneersapps.todo_list_app.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RequestMapping(path = "/api/v1/products")
public class ProductController {

    public CopyOnWriteArrayList<Product> products = new CopyOnWriteArrayList<>();

    @GetMapping
    public List<Product> getAllProducts() {
        return products;
    }

    @PostMapping
    public Product createProduct(@RequestBody Product incomingProduct) {
        products.add(incomingProduct);
        return incomingProduct;
    }

    @PutMapping(path = "/{productId}")
    public Product updateProduct(@PathVariable Integer productId, @RequestBody Product incomingProduct) {
        Optional<Product> optionalFoundProduct = products.stream().filter((currProduct) -> {
            return currProduct.id.equals(productId);
        }).findFirst();

        if (optionalFoundProduct.isPresent()) {
            Product foundProduct = optionalFoundProduct.get();
            foundProduct.name = incomingProduct.name;
            foundProduct.price = incomingProduct.price;
            foundProduct.quantity = incomingProduct.quantity;
            return foundProduct;
        } else {
            return new Product();
        }
    }

    @DeleteMapping(path = "/{productId}")
    public Product deleteProduct(@PathVariable Integer productId) {
        Optional<Product> optionalFoundProduct = products.stream().filter((currProduct) -> {
            return currProduct.id.equals(productId);
        }).findFirst();

        if (optionalFoundProduct.isPresent()) {
            Product foundProduct = optionalFoundProduct.get();
            products.remove(foundProduct);
            return foundProduct;
        } else {
            return new Product();
        }
    }
}
