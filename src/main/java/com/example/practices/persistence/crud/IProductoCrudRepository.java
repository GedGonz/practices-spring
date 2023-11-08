package com.example.practices.persistence.crud;

import com.example.practices.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IProductoCrudRepository extends CrudRepository<Producto,Integer> {

    List<Producto> findByIdCategoriaOrderyByNombreAsc(int idCategoria);
    Optional<List<Producto>> findByCantidadStocklessThanAndEstado(int cantidadStock, boolean estado);

}
