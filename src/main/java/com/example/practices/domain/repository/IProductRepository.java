package com.example.practices.domain.repository;

import com.example.practices.domain.Product;
import com.example.practices.persistence.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface IProductRepository {
    List<Product> getAll();

    Optional<List<Product> >getByCategoria(int idCategoria);

    Optional<List<Product>> getEscasos(int cantidadStock);

    Optional<Product> getProducto(int idProducto);

    Product save(Product producto);

    void delete(int productId);
}
