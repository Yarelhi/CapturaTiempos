/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans;

import Dao.ActivitiesDao;
import Dao.ReporteDao;
import Imp.ActivitiesImp;
import Imp.ReporteImp;
import Model.ItgActivitiesAll;
import Model.ItgPersonalInfoAll;
import Model.ItgProjectsAll;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author ÁNGEL
 */
@ManagedBean(name = "ReporteBean", eager = true)
@SessionScoped
public class ReporteBean {
    
    private List<ItgActivitiesAll> listarActividades;
    private List<ItgActivitiesAll> listarNombre;
    private List<ItgActivitiesAll> listarNombreList;
    //Tabla
    private List<ItgActivitiesAll> listaTable;
    //Listar Empleado
    private List<SelectItem> listEmpleado;
    private ItgPersonalInfoAll actividades;
    private List<SelectItem> listActividades;
    private List<SelectItem> listActividad;
    private int consultor;
    public String mes = "";
    public int Año;
    private int project;
    private boolean desactivar;
    private boolean desactivarProject;
    
    //Reporte clienesFísica
    private List<ItgPersonalInfoAll> listarClienteF;
    //Reporte ClientesMoral
    private List<ItgPersonalInfoAll> listarClienteM;
    
    
    public ReporteBean() {
        actividades = new ItgPersonalInfoAll();
        
    }

    public boolean isDesactivarProject() {
        if(project == 0){
            return true;
        }else{
        return false;
    }
    }
    
    public boolean isDesactivar() {
        if(mes == ""){
            return true;
        }else{
        return false;
    }
    }
 
    
    public int getProject() {
        return project;
    }

    public void setProject(int project) {
        this.project = project;
    }

    public String getMes() {
        return mes;
    }
    
    public void setMes(String mes) {
        this.mes = mes;
    }

    public int getAño() {
        return Año;
    }

    public void setAño(int Año) {
        this.Año = Año;
    }

    public int getConsultor() {
        return consultor;
    }

    public void setConsultor(int consultor) {
        this.consultor = consultor;
    }

    public ItgPersonalInfoAll getActividades() {
        return actividades;
    }

    public void setActividades(ItgPersonalInfoAll actividades) {
        this.actividades = actividades;
    }
    
    
    public List<ItgActivitiesAll> getListarNombre(){
        ReporteDao NDao = new ReporteImp();
        listarNombre = NDao.Nombre();
        return listarNombre;
    }
    
    public List<ItgActivitiesAll> getListarActividades() {
         ReporteDao RDao = new ReporteImp();
        listarActividades = RDao.Actividades();
        return listarActividades;
    }

    public List<ItgActivitiesAll> getListarNombreList() {
        ReporteDao LDao = new ReporteImp();
        listarNombreList = LDao.NombreList();
        return listarNombreList;
    }

    public List<ItgActivitiesAll> getListaTable() {
        ReporteDao CDao = new ReporteImp();
        listaTable = CDao.listarTable();
        return listaTable;
    }
    
    public List<SelectItem> getListEmpleado() {
     this.listEmpleado = new ArrayList<SelectItem>();
    ActivitiesDao ADao = new ActivitiesImp();
      List<ItgPersonalInfoAll> c = ADao.listarEmpleados();
       listEmpleado.clear();

      for (ItgPersonalInfoAll empleado : c) {
         SelectItem projectItem = new SelectItem(empleado.getPersonalDataId(),empleado.getName()+ " " + empleado.getPaternSurname()+" "+empleado.getMaternSurname());
          this.listEmpleado .add(projectItem);

       }
   // ActivitiesDao ADao = new ActivitiesImp();
    //    listEmpleado = ADao.listarEmpleados();
        return listEmpleado;
    }
    public List<SelectItem> getListActividades() {
        this.listActividades = new ArrayList<SelectItem>();
        ReporteDao CFDao = new ReporteImp();
        List<ItgActivitiesAll> e = CFDao.listarActividades(this.actividades);
        listActividades.clear();
        
        for (ItgActivitiesAll activity : e) {
            SelectItem estadoItem = new SelectItem(activity.getActivityId(),activity.getItgProjectsAll().getProjectName());
            this.listActividades.add(estadoItem);
            
        }
        return listActividades;
    }
    public List<SelectItem> getListAct() {
        this.listActividad = new ArrayList<SelectItem>();
        ActivitiesDao ADao = new ActivitiesImp();
        List<ItgProjectsAll> c = ADao.listarProyecto(this.consultor);
        listActividad.clear();

        for (ItgProjectsAll empleado : c) {
            SelectItem projectItem = new SelectItem(empleado.getProjectId(), empleado.getProjectName());
            this.listActividad.add(projectItem);
            //actividades = empleado;
        }
        return listActividad;
       
    }
    public List<SelectItem> getListActividad() {
        this.listActividad = new ArrayList<SelectItem>();
        ActivitiesDao ADao = new ActivitiesImp();
        List<ItgActivitiesAll> c = ADao.listarActividades(this.project, this.mes, this.consultor);
        listActividad.clear();

        for (ItgActivitiesAll empleado : c) {
            SelectItem projectItem = new SelectItem(empleado.getActivityId(),empleado.getNumberWeek()+ " ( Del " + empleado.getStartDay()+ " al " + empleado.getEndDay()+ " de " + empleado.getMonth()+ " del año " + empleado.getYear() + " )");
            this.listActividad.add(projectItem);
        }
        return listActividad;
       
    }
     public List<ItgPersonalInfoAll> getListarClienteF(){
        ReporteDao CFDao = new ReporteImp();
        listarClienteF = CFDao.CustomerF();
        return listarClienteF;
    }  
   
    public List<ItgPersonalInfoAll> getListarClienteM(){
        ReporteDao CMDao = new ReporteImp();
        listarClienteM = CMDao.CustomerM();
        return listarClienteM;
    } 
    
}
