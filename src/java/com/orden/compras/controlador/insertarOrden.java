/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.orden.compras.controlador;

import com.google.gson.Gson;
import com.orden.compra.Dao.OrdenCompraDao;
import com.orden.compra.Dao.listaDetalle;
import com.orden.compras.Dto.OdenCompraDetaDto;
import com.orden.compras.Dto.OrdenCompraDto;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.AjaxBehaviorEvent;
import java.util.LinkedList;

/**
 *
 * @author jmanuel Abarca
 */
@ManagedBean
@SessionScoped
public class insertarOrden implements Serializable {

    private Long idOrden;
    private Long idCliente;
    private Date fecha;
    private BigDecimal totalord;
    private String fechaAux;

    /**
     * **************
     */
    //Detalle
    private long ordenPedidoId;
    private long orderDetaId;
    private String nombreProd;
    private String descProd = "";
    private Long idProducto;
    private int cantProducto;
    private BigDecimal precioProducto;

    private int idDeta;
    listaDetalle list = new listaDetalle();
    ordenCompras dt = new ordenCompras();

    private List<OrdenCompraDto> OrdeCompraList;
    private OrdenCompraDto ordeCompra = new OrdenCompraDto();
      OrdenCompraDao ordenDao =new OrdenCompraDao();

    //private List <OdenCompraDetaDto> OrdeDetaCompraList ;
    private ArrayList<OdenCompraDetaDto> OrdeDetaCompraList = new ArrayList<OdenCompraDetaDto>();
    private OdenCompraDetaDto det = new OdenCompraDetaDto();

    // public List<OdenCompraDetaDto> getLlenardetalle() {
    public String llenarDetalle() {

        try {
            det.setOrderDetaId((int) orderDetaId);
            if (idOrden != null) {
                det.setOrdenPedidoId(idOrden);
            }

            det.setIdProducto(idProducto);
            det.setNombreProd(nombreProd);
            det.setPrecioProducto(precioProducto);
            det.setCantProducto(cantProducto);
            det.setDescProd(descProd);

            OrdeDetaCompraList.add(det);
            //dt.getDetaCompraList().add(det);
            // list.getOrdeDetaCompraList().add(det);
        } catch (Exception ex) {
            System.out.println("ERROR " + ex);
        }

        //return OrdeDetaCompraList;
        return "crearOrdenes";
    }

    public void crearOrden() throws Exception {
        ordeCompra.setIdOrdCompra(idOrden);
        ordeCompra.setIdCliente(idCliente);
        ordeCompra.setFecha(fecha);
        ordeCompra.setPrecioTotal(totalord);

        for (OdenCompraDetaDto dett : OrdeDetaCompraList) {
            OdenCompraDetaDto dt = new OdenCompraDetaDto();
            dt.setOrderDetaId(dett.getOrderDetaId());
            dt.setOrdenPedidoId(dett.getOrdenPedidoId());
            dt.setIdProducto(dett.getIdProducto());
            dt.setCantProducto(dett.getCantProducto());
            dt.setPrecioProducto(dett.getPrecioProducto());
            dt.setNombreProd(dett.getNombreProd());
            dt.setDescProd(dett.getDescProd());

            ordeCompra.getDetalle().add(dt);
        }
         String jsonRsp = new Gson().toJson(ordeCompra);  // comentar
         System.out.println("jsonRsp"+jsonRsp);
        //String msj=ordenDao.addOrdeCompra(ordeCompra);  

        //return "Orden Guardad";
    }

    private LinkedList<OdenCompraDetaDto> datos = new LinkedList<OdenCompraDetaDto>();
    OdenCompraDetaDto dato = new OdenCompraDetaDto();

    public void addValor(OdenCompraDetaDto valor) {
        datos.add(valor);
    }

    public void removeValor(OdenCompraDetaDto valor) {
        datos.remove(valor);

    }

    public LinkedList<OdenCompraDetaDto> getDatos() {
        return datos;
    }

    public void setDatos(LinkedList<OdenCompraDetaDto> datos) {
        this.datos = datos;
    }

    public OdenCompraDetaDto getDato() {
        return dato;
    }

    public void setDato(OdenCompraDetaDto dato) {
        this.dato = dato;
    }

    public ordenCompras getDt() {
        return dt;
    }

    public void setDt(ordenCompras dt) {
        this.dt = dt;
    }

    public Long getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Long idOrden) {
        this.idOrden = idOrden;
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

    public BigDecimal getTotalord() {
        return totalord;
    }

    public void setTotalord(BigDecimal totalord) {
        this.totalord = totalord;
    }

    public String getFechaAux() {
        return fechaAux;
    }

    public void setFechaAux(String fechaAux) {
        this.fechaAux = fechaAux;
    }

    public long getOrdenPedidoId() {
        return ordenPedidoId;
    }

    public void setOrdenPedidoId(long ordenPedidoId) {
        this.ordenPedidoId = ordenPedidoId;
    }

    public long getOrderDetaId() {
        return orderDetaId;
    }

    public void setOrderDetaId(long orderDetaId) {
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

    public List<OrdenCompraDto> getOrdeCompraList() {
        return OrdeCompraList;
    }

    public void setOrdeCompraList(List<OrdenCompraDto> OrdeCompraList) {
        this.OrdeCompraList = OrdeCompraList;
    }

    public int getIdDeta() {
        return idDeta;
    }

    public void setIdDeta(int idDeta) {
        this.idDeta = idDeta;
    }

    public ArrayList<OdenCompraDetaDto> getOrdeDetaCompraList() {
        return OrdeDetaCompraList;
    }

    public void setOrdeDetaCompraList(ArrayList<OdenCompraDetaDto> OrdeDetaCompraList) {
        this.OrdeDetaCompraList = OrdeDetaCompraList;
    }

}
