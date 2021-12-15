/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans;

import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

/**
 *
 * @author Briseydy
 */
@ManagedBean(name = "ReportIndCustomerMBean", eager = true)
@ViewScoped
public class ReportIndCustomerMBean {
    
    private String CustomerM;

   public String getCustomerM() {
        return CustomerM;
    }

    public void setCustomerM(String CustomerF) {
        this.CustomerM = CustomerF;
    }
    
     public ReportIndCustomerMBean() {
    }

    public String getClienteM() {
        return CustomerM;
    }

    public void setClienteM(String ClienteM) {
        this.CustomerM = ClienteM;
    }  
     
    //Metodo para invocar el reporte y enviarle los parametros si es que necesita
    public void verReporte() throws  ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        
        //Instancia hacia la clase reporteClientes        
        ReporteCustomerMBean rClientesM = new ReporteCustomerMBean();
        
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ServletContext servletContext = (ServletContext) facesContext.getExternalContext().getContext();
        String ruta = servletContext.getRealPath("/Reportes/ReportM.jasper");
        String path = servletContext.getRealPath("/Reportes/Img/logo.png");
        String pie = servletContext.getRealPath("/Reportes/Img/tel2.png");
        String oracle = servletContext.getRealPath("/Reportes/Img/oracle.png");
       
        rClientesM.getReporteIndividual(ruta, this.CustomerM,path, pie, oracle);        
        FacesContext.getCurrentInstance().responseComplete();               
    }
    
    
    
}
