package com.example.practices.web.controller;

import com.example.practices.domain.dto.ProductDto;
import com.example.practices.domain.service.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("")
    @ApiOperation("Get all supermarket products")
    @ApiResponse(code = 200, message = "Ok")
    public ResponseEntity<List<ProductDto>> getAll(){

        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK) ;
    }
    @GetMapping("/{id}")
    @ApiOperation("Search products with an ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 404, message = "Product not found")
    })
    public ResponseEntity<ProductDto> getProduct(@ApiParam(value = "the id of the product", required = true, example = "7") @PathVariable("id") int productId){
        return  productService.getProduct(productId).
                map(resp -> new ResponseEntity<>(resp, HttpStatus.OK)).
                orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/category/{id}")
    public ResponseEntity<List<ProductDto> >getByCategoria(@PathVariable("id") int idCategoria){
        return productService.getByCategoria(idCategoria).
                map(resp  -> new ResponseEntity<>(resp, HttpStatus.OK)).
                orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/escasos/{count}")
    public ResponseEntity<List<ProductDto>> getEscasos(@PathVariable("count") int cantidadStock){
        return productService.getEscasos(cantidadStock).
                map(resp-> new ResponseEntity<>(resp, HttpStatus.OK)).
                orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping("/save")
    public ResponseEntity<ProductDto> save(@RequestBody ProductDto producto){
        return new ResponseEntity<>(productService.save(producto), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int productId){
        if(productService.delete(productId)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
