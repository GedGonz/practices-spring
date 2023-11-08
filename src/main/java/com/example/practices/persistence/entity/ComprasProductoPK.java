package com.example.practices.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable // HACE REFERENCIA A QUE LA CLASE CONTENDRA LLAVES COMPUESTA
public class ComprasProductoPK implements Serializable { // SE CREA LA CLASE PARA CREAR UNA LLAVE COMPUESTA
    @Column(name = "id_compra")
    private Integer idCompra;
    @Column(name = "id_producto")
    private Integer idProducto;

    public Integer getIdCompra() {
        return idCompra;
    }
    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }
    public Integer getIdProducto() {
        return idProducto;
    }
    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

}
