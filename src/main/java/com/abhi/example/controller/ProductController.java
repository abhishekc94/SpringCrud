package com.abhi.example.controller;

import com.abhi.example.entity.Product;
import com.abhi.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/product")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        Product saveProduct = productService.saveProduct(product);
        return new ResponseEntity<>(saveProduct, HttpStatus.OK);
    }

    @PostMapping("/products")
    public ResponseEntity<List<Product>> saveProducts(@RequestBody List<Product> products) {
        List<Product> saveProducts = productService.saveProducts(products);
        return new ResponseEntity<>(saveProducts, HttpStatus.OK);
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> products = productService.getProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        Product product = productService.getProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("/product")
    public ResponseEntity<Product> getProductByName(@RequestParam String name) {
        Product product = productService.getProductByName(name);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PutMapping("/product")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        Product saveProduct = productService.updateProduct(product);
        return new ResponseEntity<>(saveProduct, HttpStatus.OK);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        String result = productService.deleteProduct(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
