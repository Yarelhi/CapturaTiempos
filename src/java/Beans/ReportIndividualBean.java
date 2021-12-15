/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans;

import Model.ItgActivitiesAll;
import Model.ItgActivitiesDetail;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;


/**
 *
 * @author ÁNGEL
 */
@ManagedBean(name = "ReportIndividualBean", eager = true)
@ViewScoped
public class ReportIndividualBean {
    
    private Integer Actividad;
    private String Mes;
    private Integer Consultor;
    private Integer proyecto = null;
    private Integer A_Anio;
    private String Status;
        
    private ItgActivitiesAll actividades;   

    public Integer getActividad() {
        return Actividad;
    }

    public void setActividad(Integer Actividad) {
        this.Actividad = Actividad;
    }

    public String getMes() {
        return Mes;
    }

    public void setMes(String Mes) {
        this.Mes = Mes;
    }

    public Integer getConsultor() {
        return Consultor;
    }

    public void setConsultor(Integer Consultor) {
        this.Consultor = Consultor;
    }

    public Integer getProyecto() {
        return proyecto;
    }

    public void setProyecto(Integer proyecto) {
        this.proyecto = proyecto;
    }

    public Integer getA_Anio() {
        return A_Anio;
    }

    public void setA_Anio(Integer A_Anio) {
        this.A_Anio = A_Anio;
    }

    /**
     * @return the Status
     */
    public String getStatus() {
        return Status;
    }

    /**
     * @param Status the Status to set
     */
    public void setStatus(String Status) {
        this.Status = Status;
    }
    
    public void setActividades(ItgActivitiesAll actividades) {
        this.actividades = actividades;
    }     

    

    //Metodo para invocar el reporte y enviarle los parametros si es que necesita
    public void verReporte() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
 
            //Instancia hacia la clase reporteClientes
            ReporteIndividualBean rActivities = new ReporteIndividualBean();         
            //if(a.equals("Activo")){
            FacesContext facesContext = FacesContext.getCurrentInstance();
            ServletContext servletContext = (ServletContext) facesContext.getExternalContext().getContext();
            String ruta = servletContext.getRealPath("/Reportes/ReporteIndividual.jasper");
            String path = servletContext.getRealPath("/Reportes/Img/logo.png");
            String pie = servletContext.getRealPath("/Reportes/Img/tel2.png");
            String oracle = servletContext.getRealPath("/Reportes/Img/oracle.png");
            
            rActivities.getReporteIndividual(ruta, this.Actividad, this.Mes, this.Consultor, this.proyecto, this.A_Anio, path, pie, oracle);
            FacesContext.getCurrentInstance().responseComplete();
            //}                                                 
    }    
    
   /* //Metodo para invocar el reporte y enviarle los parametros si es que necesita
    public void verReporteMes() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        
        //Instancia hacia la clase reporteClientes        
        ReporteIndividualBean rActivities = new ReporteIndividualBean();
        
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ServletContext servletContext = (ServletContext) facesContext.getExternalContext().getContext();
        String ruta = servletContext.getRealPath("/Reportes/ReporteMes.jasper");
       
        rActivities.getReporteMes(ruta, this.M_Mes, this.M_Consultor, this.M_proyecto);        
        FacesContext.getCurrentInstance().responseComplete();               
    }
    
    
    //Metodo para invocar el reporte y enviarle los parametros si es que necesita
    public void verReporteAnio() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        
        //Instancia hacia la clase reporteClientes        
        ReporteIndividualBean rActivities = new ReporteIndividualBean();
        
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ServletContext servletContext = (ServletContext) facesContext.getExternalContext().getContext();
        String ruta = servletContext.getRealPath("/Reportes/ReporteYear.jasper");
       
        rActivities.getReporteAnio(ruta, this.A_Anio, this.A_Consultor, this.A_proyecto);        
        FacesContext.getCurrentInstance().responseComplete();               
    }*/
    
}
