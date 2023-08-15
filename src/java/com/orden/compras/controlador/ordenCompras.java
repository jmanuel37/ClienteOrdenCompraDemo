/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.orden.compras.controlador;

/**
 *
 * @author jmanuel Abarca
 */


import javax.faces.bean.ManagedBean;  
import javax.faces.bean.RequestScoped;  
import javax.faces.context.FacesContext;  

import com.orden.compras.Dto.OdenCompraDetaDto;
import com.orden.compras.Dto.OrdenCompraDto;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
 
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
 

@ManagedBean  
@RequestScoped 
public class ordenCompras {
    
    ClientConfig clientConfig = new DefaultClientConfig();
 
      // Create Client based on Config
      com.sun.jersey.api.client.Client client = com.sun.jersey.api.client.Client.create(clientConfig);
     private List<OrdenCompraDto> OrdeCompraList;
     private List <OdenCompraDetaDto> OrdeDetaCompraList;
     
     private Long idOrden;
     private Long idCliente;
     private Date fecha;
     private BigDecimal totalord;
     private String fechaAux;
     
     /*********************************/
     // Detalle de la orden
     
     
     
     
     /***********************************************/
     public List<OrdenCompraDto> getOrdCompras() {        
     WebResource webResource = client.resource("http://localhost:8003/apiordencompra/apiordencompralist");     
      ClientResponse  response = webResource.type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		if (response.getStatus() != 200) {
		   throw new RuntimeException("Failed : HTTP error code : "
			+ response.getStatus());
		}
      // Status 200 is successful.
      if (response.getStatus() != 200) {
          System.out.println("Failed with HTTP Error code: " + response.getStatus());
         String error= response.getEntity(String.class);
         System.out.println("Error: "+error);
      }
      String output = response.getEntity(String.class);
     //  System.out.println("Output from Server .... \n" +output);
      try{
          System.out.println("Output from Server .... \n");

           OrdeCompraList=new ArrayList<OrdenCompraDto>();
           ObjectMapper mapper = new ObjectMapper();
           OrdeCompraList = mapper.readValue(output, new TypeReference<List<OrdenCompraDto>>(){});
      } catch (IOException ex) {
            System.out.println("ERROR WS "+ex);
      }
         
        return OrdeCompraList;
    }
     
     
     public String detCompras(int id){  
         String myDatePattern1 = "yyyy-MM-dd HH:mm:ss";
               
                SimpleDateFormat df = new SimpleDateFormat( myDatePattern1 );
          
             
             //fechasalida=df.format(OrdeCompraList.get(id).getFecha());
             
    System.out.println("llego al metodo detCompras");
          try{
             idOrden= OrdeCompraList.get(id).getIdOrdCompra();
             idCliente=OrdeCompraList.get(id).getIdCliente();
             fechaAux= df.format(OrdeCompraList.get(id).getFecha());
             totalord=OrdeCompraList.get(id).getPrecioTotal();
             
             //OrdeDetaCompraList=new ArrayList<OdenCompraDetaDto>();
   
             for (OdenCompraDetaDto dett : OrdeCompraList.get(id).getDetalle()) {
                 
                 OdenCompraDetaDto dt =new OdenCompraDetaDto();
                 dt.setOrderDetaId(dett.getOrderDetaId());
                 dt.setOrdenPedidoId(dett.getOrdenPedidoId());
                 dt.setIdProducto(dett.getIdProducto());
                 dt.setCantProducto(dett.getCantProducto());
                 dt.setPrecioProducto(dett.getPrecioProducto());
                 dt.setNombreProd(dett.getNombreProd());
                 dt.setDescProd(dett.getDescProd());
                 
                 OrdeDetaCompraList.add(dt);
             }        
      
      } catch (Exception ex) {
            System.out.println("ERROR WS "+ex);
      }         
         //return "/detalleOrden.xhtml?faces-redirect=true";
         //return "welcomePrimefaces";
         return "detalleOrden";
         //return detalleOrden;

     }
    public List<OdenCompraDetaDto> getDetaCompras() {  
         OdenCompraDetaDto dt =new OdenCompraDetaDto();
       //OrdeDetaCompraList.add(dt); 
       
     return OrdeDetaCompraList;
 }
    
    
    
    private ArrayList<OdenCompraDetaDto> DetaCompraList = new ArrayList<OdenCompraDetaDto>();

  
    
   //////////get y set

    public Long getIdOrden() {
        return idOrden;
    }

    public ArrayList<OdenCompraDetaDto> getDetaCompraList() {
        return DetaCompraList;
    }

    public void setDetaCompraList(ArrayList<OdenCompraDetaDto> DetaCompraList) {
        this.DetaCompraList = DetaCompraList;
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
    
     
     
   
}
