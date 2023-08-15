/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.orden.compra.Dao;

import com.orden.compras.Dto.OdenCompraDetaDto;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class listaDetalle {
    
    private long ordenPedidoId;
    private int orderDetaId;
    private String nombreProd;
    private String descProd;
    private Long idProducto;
    private int cantProducto;
    private BigDecimal precioProducto;
    
    private ArrayList<OdenCompraDetaDto> OrdeDetaCompraList = new ArrayList<>();

    public ArrayList<OdenCompraDetaDto> getOrdeDetaCompraList() {
        return OrdeDetaCompraList;
    }

    public void setOrdeDetaCompraList(ArrayList<OdenCompraDetaDto> OrdeDetaCompraList) {
        this.OrdeDetaCompraList = OrdeDetaCompraList;
    }

    public long getOrdenPedidoId() {
        return ordenPedidoId;
    }

    public void setOrdenPedidoId(long ordenPedidoId) {
        this.ordenPedidoId = ordenPedidoId;
    }

    public int getOrderDetaId() {
        return orderDetaId;
    }

    public void setOrderDetaId(int orderDetaId) {
        this.orderDetaId = orderDetaId;
    }

    public String getNombreProd() {
        return nombreProd;
    }

    public void setNombreProd(String nombreProd) {
        this.nombreProd = nombreProd;
    }

    public String getDescProd() {
        return descProd;
    }

    public void setDescProd(String descProd) {
        this.descProd = descProd;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantProducto() {
        return cantProducto;
    }

    public void setCantProducto(int cantProducto) {
        this.cantProducto = cantProducto;
    }

    public BigDecimal getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(BigDecimal precioProducto) {
        this.precioProducto = precioProducto;
    }
    
    
}
