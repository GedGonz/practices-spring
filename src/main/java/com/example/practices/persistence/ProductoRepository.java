package com.example.practices.persistence;

import com.example.practices.persistence.crud.IProductoCrudRepository;
import com.example.practices.persistence.entity.Producto;

import java.util.List;
import java.util.Optional;

public class ProductoRepository {
    private IProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll(){
        return (List<Producto>) productoCrudRepository.findAll();
    }

    public List<Producto> getByCategoria(int idCategoria){
        return productoCrudRepository.findByIdCategoriaOrderyByNombreAsc(idCategoria);
    }
    public Optional<List<Producto>> getEscasos(int cantidadStock){
        return productoCrudRepository.findByCantidadStocklessThanAndEstado(cantidadStock, true);
    }

}
