package com.example.practices.domain.repository;

import com.example.practices.persistence.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface IProductRepository {
    List<Producto> getAll();

    List<Producto> getByCategoria(int idCategoria);

    Optional<List<Producto>> getEscasos(int cantidadStock);

    Optional<Producto> getProducto(int idProducto);

    Producto save(Producto producto);

    void delete(int idProducto);
}
