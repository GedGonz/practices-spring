package com.example.practices.persistence.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "compras_productos")
public class ComprasProducto {

    @EmbeddedId // HACE REFERENCIA A QUE LA LLAVE ES COMPUESTA
    private ComprasProductoPK id; // SE HACE REFERENCIA A LA CLASE PARA HACER REFERENCIA A LA LLAVE PRIMARIA COMPPUESTA
    private Integer cantidad;
    private Double total;
    private Boolean estado;


}
