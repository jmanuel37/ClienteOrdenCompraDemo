/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.orden.compra.Dao;

import com.google.gson.Gson;
import com.orden.compras.Dto.Clientes;
import com.orden.compras.Dto.OrdenCompraDto;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

/**
 *
 * @author DELL
 */
public class OrdenCompraDao {
    
      ClientConfig clientConfig = new DefaultClientConfig();

    // Create Client based on Config
    com.sun.jersey.api.client.Client client = com.sun.jersey.api.client.Client.create(clientConfig);
    
    public String addOrdeCompra(OrdenCompraDto orden) throws Exception {
        try {
            String respuestaWS = " Sin Resultados";
            String jsonRsp = new Gson().toJson(orden);  // comentar
            Client client = Client.create();
            WebResource webResource = client.resource("http://localhost:8003/apiordencompra/crearOrdenCompra");
            ClientResponse response = webResource.type("application/json")
                    .accept("application/json")
                    .post(ClientResponse.class, jsonRsp);
            if (response.getStatus() != 200) {
                System.out.println("Error HTTP \n" + response.getStatus());
                respuestaWS = "Error HTTP \n" + response.getStatus();
                System.out.println("Output from Server .... \n");
                return respuestaWS;
            }
            respuestaWS = response.getEntity(String.class);
            // display response
            System.out.println("Output from Server .... \n");
            System.out.println(respuestaWS + "\n");
            return respuestaWS;
            // return jsonRsp;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error al pasar Datos al  WS de Clientes " + e.getMessage());
        }

    }
    
}
