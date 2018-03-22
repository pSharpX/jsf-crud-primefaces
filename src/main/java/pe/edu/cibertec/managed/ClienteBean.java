/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.managed;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import org.primefaces.event.CloseEvent;
import org.primefaces.event.ToggleEvent;
import pe.edu.cibertec.model.Cliente;

/**
 *
 * @author Java-LM
 */
@ManagedBean(name = "clienteBean")
public class ClienteBean {
    
    private Cliente cliente = new Cliente();
    private String mensaje;
    
    public String registrar(){
        return "resultado";
    }
    
    public void mensajeProfesion(ValueChangeEvent e){
        String valor = (String)e.getNewValue();
        if(valor.equals("001")){
            setMensaje("Tenemos los mejores cursos de arquitectura");
        }
        if(valor.equals("002")){
            setMensaje("Grandes eventos esperan por ti");
        }
    }
    
    public void onClose(CloseEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Panel Closed", "Closed panel id:'" + event.getComponent().getId() + "'");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void onToggle(ToggleEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, event.getComponent().getId() + " toggled", "Status:" + event.getVisibility().name());
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
}
