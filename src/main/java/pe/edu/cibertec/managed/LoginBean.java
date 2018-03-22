/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.managed;

import java.util.Locale;
import java.util.ResourceBundle;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.CloseEvent;
import org.primefaces.event.ToggleEvent;

/**
 *
 * @author Java-LM
 */
@ManagedBean(name = "login")
@SessionScoped
public class LoginBean {

    private String username;
    private String password;

    public String autenticar() {
        ResourceBundle rb = ResourceBundle.getBundle("pe.edu.cibertec.recursos.mensajes",
                FacesContext.getCurrentInstance().getViewRoot().getLocale());
        if ("Christian".equals(username) && "123456".equals(password)) {
            return "principal";
        }

        password = null;
        FacesMessage fm = new FacesMessage(
                FacesMessage.SEVERITY_ERROR,
                rb.getString("validacion_login_incorrecto"),
                rb.getString("validacion_login_incorrecto_detail"));
        FacesContext.getCurrentInstance().addMessage(null, fm);
        return null;
    }

    public void onClose(CloseEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Panel Closed", "Closed panel id:'" + event.getComponent().getId() + "'");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void onToggle(ToggleEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, event.getComponent().getId() + " toggled", "Status:" + event.getVisibility().name());
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
