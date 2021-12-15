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
@ManagedBean(name = "ReportIndCustomerFBean", eager = true)
@ViewScoped
public class ReportIndCustomerFBean {
    
    private String CustomerF;

    public String getCustomerF() {
        return CustomerF;
    }

    public void setCustomerF(String CustomerF) {
        this.CustomerF = CustomerF;
    }
    
     public ReportIndCustomerFBean() {
    }

    public String getClienteF() {
        return CustomerF;
    }

    public void setClienteF(String ClienteF) {
        this.CustomerF = ClienteF;
    }    

 
    //Metodo para invocar el reporte y enviarle los parametros si es que necesita
    public void verReporte() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        
        //Instancia hacia la clase reporteClientes        
        ReporteCustomerFBean rClientesF = new ReporteCustomerFBean();
        
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ServletContext servletContext = (ServletContext) facesContext.getExternalContext().getContext();
        String ruta = servletContext.getRealPath("/Reportes/ReportF.jasper");
        String path = servletContext.getRealPath("/Reportes/Img/logo.png");
        String pie = servletContext.getRealPath("/Reportes/Img/tel2.png");
        String oracle = servletContext.getRealPath("/Reportes/Img/oracle.png");

       
        rClientesF.getReporteIndividual(ruta, this.CustomerF,path, pie, oracle);        
        FacesContext.getCurrentInstance().responseComplete();               
    }

    }