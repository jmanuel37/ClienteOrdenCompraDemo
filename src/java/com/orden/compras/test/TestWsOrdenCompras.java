/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.orden.compras.test;
import com.orden.compras.Dto.OdenCompraDetaDto;
import com.orden.compras.Dto.OrdenCompraDto;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.MediaType;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

/**
 *
 * @author DELL
 */
public class TestWsOrdenCompras {
    public static void main(String[] args) {
 
       ClientConfig clientConfig = new DefaultClientConfig();
 
      // Create Client based on Config
      Client client = Client.create(clientConfig);
 
      //WebResource webResource = client.resource("http://localhost:8088/WebServiceRest/webresources/service/todasPessoas");
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
          return;
      }

      String output = response.getEntity(String.class);
       System.out.println("Output from Server .... \n" +output);
      try{
          System.out.println("Output from Server .... \n");

          List <OrdenCompraDto> list=new ArrayList<OrdenCompraDto>();
           ObjectMapper mapper = new ObjectMapper();
           list = mapper.readValue(output, new TypeReference<List<OrdenCompraDto>>(){});

      for (OrdenCompraDto ord : list) {
          System.out.println(" --- ");
          System.out.println("ID Orden .... " + ord.getIdOrdCompra());
          System.out.println("ID Cliente .... " + ord.getIdCliente());
          System.out.println("Fecha Orden .... " +  ord.getFecha());
          System.out.println("Precio  .... " +  ord.getPrecioTotal());
             for (OdenCompraDetaDto dett : ord.getDetalle()) {
                 System.out.println("\t ID OrdenDetalle .... " + dett.getOrderDetaId());
                 System.out.println("\t ID Pedido .... " + dett.getOrdenPedidoId());
                 System.out.println("\t Nombre Producto .... " + dett.getNombreProd());
                 System.out.println("\t Cantidad .... " + dett.getCantProducto());
                 System.out.println("\t Precio .... " + dett.getPrecioProducto());              
                 System.out.println("\t Descripccion .... " + dett.getDescProd());
             }        
      }
      } catch (IOException ex) {
            System.out.println("ERROR WS "+ex);
      }
   }
    
}
