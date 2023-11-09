package com.example.practices.web.controller;

import com.example.practices.domain.dto.ProductDto;
import com.example.practices.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("")
    public List<ProductDto> getAll(){
        return productService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<ProductDto> getProduct(@PathVariable("id") int productId){
        return productService.getProduct(productId);
    }
    @GetMapping("/category/{id}")
    public Optional<List<ProductDto> >getByCategoria(@PathVariable("id") int idCategoria){
        return productService.getByCategoria(idCategoria);
    }
    @GetMapping("/escasos/{count}")
    public Optional<List<ProductDto>> getEscasos(@PathVariable("count") int cantidadStock){
        return productService.getEscasos(cantidadStock);
    }
    @PostMapping("/save")
    public ProductDto save(@RequestBody ProductDto producto){
        return productService.save(producto);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") int productId){
        return productService.delete(productId);
    }
}
