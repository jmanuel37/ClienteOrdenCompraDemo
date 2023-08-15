/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.orden.compras.controlador;
import com.orden.compra.Dao.ClienteDao;
import com.orden.compras.Dto.Clientes;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.naming.NamingException;

/**
 *
 * @author Jmanuel Abarca
 */
@ManagedBean
@SessionScoped
public class mantenimientoCliente {
      Clientes clientForm;
      
    public mantenimientoCliente() {
        clientForm=new Clientes();
    }
       ClienteDao prodDao =new ClienteDao();
       
       
       
    /**********************************+   funcion Muestra la lista de Clientes ************************************/
    public List<Clientes> getListaClientes() {
        List<Clientes> lista = prodDao.listaClientes();
        return lista;
    }

    public Clientes getClientForm() {
        return clientForm;
    }

    public void setClientForm(Clientes clientForm) {
        this.clientForm = clientForm;
    }
    
    //ParseException_Exception
    public String  create() throws Exception{
        clientForm.setIdCliente(0l);
        String msj=prodDao.addCliente(clientForm);  
        FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_INFO,msj,"..."); 
       // Agregar el mensaje en el ambito de contexto en JSF
       //FacesContext.getCurrentInstance().addMessage(null,msg);
         limpiar();
        return msj; 
    }
    public void  update() {
        String msj=prodDao.updateCliente(clientForm);  
        FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_INFO,msj,"..."); 
       // Agregar el mensaje en el ambito de contexto en JSF
       //FacesContext.getCurrentInstance().addMessage(null,msg);
       // return "Vistas/Producto/ListProducto"; 
       limpiar();
    }
     public void  delete() {
        String msj=prodDao.deleteCliente(clientForm);  
        FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_INFO,msj,"..."); 
       // Agregar el mensaje en el ambito de contexto en JSF
        limpiar();
       //FacesContext.getCurrentInstance().addMessage(null,msg);
       // return "Vistas/Producto/ListProducto"; 
    }
     public void limpiar(){
     clientForm.setIdCliente(0l);
     clientForm.setNombreCliente("");
     clientForm.setDescripcionCliente(""); 
     }
}
