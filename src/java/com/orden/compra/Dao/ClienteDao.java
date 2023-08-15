/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.orden.compra.Dao;

import com.google.gson.Gson;
import com.orden.compras.Dto.Clientes;
import com.orden.compras.Dto.OrdenCompraDto;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.MediaType;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.sun.jersey.api.client.Client;

/**
 *
 * @author Jmanuel Abarca
 */
public class ClienteDao {

    ClientConfig clientConfig = new DefaultClientConfig();

    // Create Client based on Config
    com.sun.jersey.api.client.Client client = com.sun.jersey.api.client.Client.create(clientConfig);

    public ArrayList<Clientes> listaClientes() {
        ArrayList<Clientes> listaClientes = new ArrayList<Clientes>();

        WebResource webResource = client.resource("http://localhost:8003/apiCliente/clientelist");
        ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }
        // Status 200 is successful.
        if (response.getStatus() != 200) {
            System.out.println("Failed with HTTP Error code: " + response.getStatus());
            String error = response.getEntity(String.class);
            System.out.println("Error: " + error);
        }
        String output = response.getEntity(String.class);
        //  System.out.println("Output from Server .... \n" +output);
        try {
            System.out.println("Output from Server .... \n");

            //OrdeCompraList=new ArrayList<OrdenCompraDto>();
            ObjectMapper mapper = new ObjectMapper();
            listaClientes = mapper.readValue(output, new TypeReference<List<Clientes>>() {
            });

            return listaClientes;
        } catch (IOException ex) {
            System.out.println("ERROR WS " + ex);
        }

        return listaClientes;
    }

    public String addCliente(Clientes cliente) throws Exception {
        try {
            String respuestaWS = " Sin Resultados";
            String jsonRsp = new Gson().toJson(cliente);  // comentar
            Client client = Client.create();
            WebResource webResource = client.resource("http://localhost:8003/apiCliente/crearCliente");
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

    public String updateCliente(Clientes cli) {
       String Resultado = "Sin Resultados";
        Client client = Client.create();
        String jsonRsp = new Gson().toJson(cli);  // comentar
        WebResource webResource = client.resource("http://localhost:8003/apiCliente/actualizarCliente/"+cli.getIdCliente());
        // Send XML and receive XML
        ClientResponse response = webResource.type("application/json")//
                .accept("application/json") //
                .put(ClientResponse.class, jsonRsp);

        if (response.getStatus() != 200) {
            System.out.println("Failed : HTTP error code : " + response.getStatus());

            String error = response.getEntity(String.class);
            System.out.println("Error: " + error);
            Resultado = error;
        }

        System.out.println("Output from Server .... \n");

        String output = response.getEntity(String.class);

        System.out.println(output);

        return Resultado;

    }

    public String deleteCliente(Clientes cli) {
        String Resultado = "Sin Resultados";
        Client client = Client.create();
        WebResource webResource = client.resource("http://localhost:8003/apiCliente/borrarCliente/"+cli.getIdCliente());
        ClientResponse response = webResource.type("application/json")//
                .accept("application/json") //
                .delete(ClientResponse.class);
        if (response.getStatus() != 200 && response.getStatus() != 204 ) {
            System.out.println("Failed : HTTP error code : " + response.getStatus());
            String error = response.getEntity(String.class);
            System.out.println("Error: " + error);
            Resultado = error;
        }
 
        System.out.println("Output from Server .... \n");
 
        //String output = response.getEntity(String.class);
         Resultado = "Registro Eliminado";
        //System.out.println(output);
        return Resultado;

    }

}
