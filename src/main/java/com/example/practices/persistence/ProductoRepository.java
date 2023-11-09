package com.example.practices.persistence;

import com.example.practices.domain.Product;
import com.example.practices.domain.repository.IProductRepository;
import com.example.practices.persistence.crud.IProductoCrudRepository;
import com.example.practices.persistence.entity.Producto;
import com.example.practices.persistence.mapper.IProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements IProductRepository {
    @Autowired
    private IProductoCrudRepository productoCrudRepository;
    @Autowired
    private IProductMapper productMapper;
    public List<Product> getAll(){
        List<Producto> productos=(List<Producto>) productoCrudRepository.findAll();
        return productMapper.toProducts(productos);
    }

    public Optional<List<Product>> getByCategoria(int idCategoria){
        List<Producto> productos=productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
        return Optional.of(productMapper.toProducts(productos));
    }
    public Optional<List<Product>> getEscasos(int cantidadStock){
        Optional<List<Producto>> productos=productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidadStock, true);
        return productos.map(prods -> productMapper.toProducts(prods));
    }

    public Optional<Product> getProducto(int idProducto){
        Optional<Producto> producto = productoCrudRepository.findById(idProducto);
        return producto.map(prod-> productMapper.toProduct(prod));
    }

    public Product save(Product product){
        Producto producto = productMapper.toProducto(product);
        return productMapper.toProduct(productoCrudRepository.save(producto));
    }

    public void delete(int idProducto){
        productoCrudRepository.deleteById(idProducto);
    }
}
