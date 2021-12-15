/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import Model.ItgActivitiesAll;
import Model.ItgActivitiesDetail;
import Model.ItgCompany;
import Model.ItgPersonalInfoAll;
import Model.ItgProjectsAll;
import Model.ItgListValuesDet;
import java.util.List;

/**
 *
 * @author DLVC
 */
public interface ActivitiesDao {
    //Registrar Activities - Actividades
    public List<ItgActivitiesAll> mostrarActividades();
    public void nuevaActividad(ItgActivitiesAll itgActivitiesAll);
    //Registrar Employees - Empleados
    public List<ItgPersonalInfoAll> mostrarEmp();
    public void nuevoEmp(ItgPersonalInfoAll itgPersonalInfoAll);
    //Lista Empleados
    public List<ItgPersonalInfoAll> listarEmpleados();
    //Lista Clientes
    public List<ItgPersonalInfoAll> listarClient();
    //Lista Proyectos
    public List<ItgProjectsAll> listarProy(int cliente);
    
    
    public void nuevoReporte(ItgActivitiesDetail itgActivitiesDetail);
         
    public List<ItgActivitiesAll> listarEmpleadoss();
    public List<ItgProjectsAll> listarProyecto(int realizo);
    public List<ItgActivitiesAll> listarActividades(int project, String mes, int realizo);
    public List<ItgActivitiesAll> listarConsultor();
    //Listar tabla reporte de horas
    public List<ItgActivitiesDetail> listarTable(ItgActivitiesAll actividades);
    public List<ItgActivitiesAll> listarTableActivities(ItgActivitiesAll asignacion);
    //Modificar horas
    public void modificarHoras(ItgActivitiesDetail itgActivitiesDetail);
    public void modificarActividades(ItgActivitiesAll itgActivitiesAll);
    public void eliminarHoras(ItgActivitiesDetail itgActivitiesDetail);
    
    public List<ItgProjectsAll>getProyec();
    
}
