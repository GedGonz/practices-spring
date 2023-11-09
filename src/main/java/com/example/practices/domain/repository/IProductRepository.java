package com.example.practices.domain.repository;

import com.example.practices.domain.dto.ProductDto;

import java.util.List;
import java.util.Optional;

public interface IProductRepository {
    List<ProductDto> getAll();

    Optional<List<ProductDto> >getByCategoria(int idCategoria);

    Optional<List<ProductDto>> getEscasos(int cantidadStock);

    Optional<ProductDto> getProducto(int idProducto);

    ProductDto save(ProductDto producto);

    void delete(int productId);
}
