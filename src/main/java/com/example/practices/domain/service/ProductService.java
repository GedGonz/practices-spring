package com.example.practices.domain.service;

import com.example.practices.domain.dto.ProductDto;
import com.example.practices.domain.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private IProductRepository productRepository;


    public List<ProductDto> getAll(){
        return productRepository.getAll();
    }

    public Optional<ProductDto> getProduct(int productId){
        return productRepository.getProducto(productId);
    }
    public Optional<List<ProductDto> >getByCategoria(int idCategoria){
        return productRepository.getByCategoria(idCategoria);
    }
    public Optional<List<ProductDto>> getEscasos(int cantidadStock){
        return productRepository.getEscasos(cantidadStock);
    }

    public ProductDto save(ProductDto producto){
        return productRepository.save(producto);
    }

    public boolean delete(int productId){

        return getProduct(productId).map(product -> {
            productRepository.delete(productId);
            return true;
        }).orElse(false);


    }

}
