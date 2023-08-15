/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.orden.compras.Dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class OrdenCompraDto {
    private long idOrdCompra;
    private Long idCliente;
    private Date fecha;
    private BigDecimal precioTotal;

    private List<OdenCompraDetaDto> detalle;

    public long getIdOrdCompra() {
        return idOrdCompra;
    }

    public void setIdOrdCompra(long idOrdCompra) {
        this.idOrdCompra = idOrdCompra;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(BigDecimal precioTotal) {
        this.precioTotal = precioTotal;
    }

    public List<OdenCompraDetaDto> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<OdenCompraDetaDto> detalle) {
        this.detalle = detalle;
    }
    
    
}
