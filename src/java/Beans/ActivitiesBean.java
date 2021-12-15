/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Dao.ActivitiesDao;
import Dao.ClienteDao;
import Imp.ActivitiesImp;
import Imp.CustomerImp;
import Model.ItgActivitiesAll;
import Model.ItgActivitiesDetail;
import Model.ItgCompany;
import Model.ItgExpenseReportsAll;
import Model.ItgPersonalInfoAll;
import Model.ItgProjectsAll;
import Model.ItgListValuesDet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.convert.DateTimeConverter;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;


/**
 *
 * @author DLVC
 */

@ManagedBean
@ViewScoped
public class ActivitiesBean {
    
    //Registrar Actividades
    private List<ItgActivitiesAll> listar;
    private ItgActivitiesAll actividades;
    private ItgActivitiesAll asignacion;
    
 
    private List<ItgActivitiesDetail> lista;
    private ItgActivitiesDetail actividad;

    //Registrar PersonalDataAll
    private List<ItgPersonalInfoAll> listaremp;
    private ItgPersonalInfoAll empleados;
    //Selectlist empleados
    private List<SelectItem> listEmpleado;
      private List<SelectItem> listaEmpleado;

 
    //Selectlist de Proyectos
    private List<SelectItem> listProyectos;
    private List<SelectItem> listActividad;
    private List<SelectItem> listProject;
    private List<SelectItem> listarConsultor;
    private ItgPersonalInfoAll proyecto;
    
     private ItgExpenseReportsAll reporte;
    
    private List<ItgActivitiesDetail> listaTable;
    private List<ItgActivitiesAll> listaTableConsultor;
    private ItgActivitiesDetail obtenerHoras;
    private ItgActivitiesAll obtenerConsultor;
    public int cliente;
    public int realizo;
    public int project;
    public String mes;
    public java.util.Date semana;
    public Date fecIn;
    public Date fecFin;
    
    //private ItgActivitiesAll acti;
             
    
    public ActivitiesBean() {
        actividades = new ItgActivitiesAll();
        
        actividad = new ItgActivitiesDetail();
        
        obtenerHoras = new ItgActivitiesDetail();
        
        obtenerConsultor = new ItgActivitiesAll();
        
        semana = new Date();
        
        asignacion = new ItgActivitiesAll();
        
        
        
        //acti = new ItgActivitiesAll();
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public int getProject() {
        return project;
    }

    public void setProject(int project) {
        this.project = project;
    }

    public Date getSemana() {
        return semana;
    }

    public void setSemana(Date semana) {
        this.semana = semana;
    }             
    
    public ItgActivitiesDetail getObtenerHoras() {
        return obtenerHoras;
    }

    public void setObtenerHoras(ItgActivitiesDetail obtenerHoras) {
        this.obtenerHoras = obtenerHoras;
    }

    public ItgActivitiesAll getObtenerConsultor() {
        return obtenerConsultor;
    }

    public void setObtenerConsultor(ItgActivitiesAll obtenerConsultor) {
        this.obtenerConsultor = obtenerConsultor;
    }
    
    public Date getFecIn() {
        return fecIn;
    }

    public void setFecIn(Date fecIn) {
        this.fecIn = fecIn;
    }
    
    
    public Date getFecFin() {
        return fecFin;
    }

    public void setFecFin(Date fecFin) {
        this.fecFin = fecFin;
    }

    
    
    public ItgActivitiesAll getActividades() {
        return actividades;
    }
    
     public void setActividades(ItgActivitiesAll actividades) {
        this.actividades = actividades;
    }
     
    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public int getRealizo() {
        return realizo;
    }

    public void setRealizo(int realizo) {
        this.realizo = realizo;
    }

   

    public ItgActivitiesDetail getActividad() {
        return actividad;
    }

    public void setActividad(ItgActivitiesDetail actividad) {
        this.actividad = actividad;
    }
 
    public List<ItgActivitiesDetail> getLista() {
        return lista;
    }
    public List<ItgActivitiesAll> getListar() {
        ActivitiesDao ADao = new ActivitiesImp();
        listar = ADao.mostrarActividades();
        return listar;
    }

    public List<SelectItem> getListarConsultor() {
         this.listarConsultor = new ArrayList<SelectItem>();
        ActivitiesDao ADao = new ActivitiesImp();
        List<ItgActivitiesAll> c = ADao.listarConsultor();
        listActividad.clear();

        for (ItgActivitiesAll empleado : c) {
            SelectItem projectItem = new SelectItem(empleado.getItgPersonalInfoAll().getPersonalDataId());
            this.listarConsultor.add(projectItem);

        }
        return listarConsultor;
    }

    public List<SelectItem> getListAct() {
        this.listActividad = new ArrayList<SelectItem>();
        ActivitiesDao ADao = new ActivitiesImp();
        List<ItgProjectsAll> c = ADao.listarProyecto(this.realizo);
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
        List<ItgActivitiesAll> c = ADao.listarActividades(this.project, this.mes, this.realizo);
        listActividad.clear();

        for (ItgActivitiesAll empleado : c) {
            SelectItem projectItem = new SelectItem(empleado.getActivityId(),empleado.getNumberWeek()+ " ( Del " + empleado.getStartDay()+ " al " + empleado.getEndDay()+ " de " + empleado.getMonth()+ " del año " + empleado.getYear() + " )");
            this.listActividad.add(projectItem);
        }
        return listActividad;
       
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
    
    public ItgPersonalInfoAll getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ItgPersonalInfoAll empleados) {
        this.empleados = empleados;
    }

    public List<ItgPersonalInfoAll> getListaremp() {
        ActivitiesDao ADao = new ActivitiesImp();
        listaremp = ADao.mostrarEmp();
        return listaremp;
    }
    

    public List<SelectItem> getListProyectos() {
      this.listProyectos = new ArrayList<SelectItem>();
      ActivitiesDao ADao = new ActivitiesImp();
      List<ItgProjectsAll> c = ADao.listarProy(this.cliente);
       listEmpleado.clear();

      for (ItgProjectsAll proyecto : c) {
         SelectItem projectItem = new SelectItem(proyecto.getProjectId(), proyecto.getProjectName());
          this.listProyectos .add(projectItem);

       }
        //ActivitiesDao ADao = new ActivitiesImp();
        //listProyectos = ADao.listarProy();
        
        return listProyectos;
    }

    
    
    public void nuevaActividad() {
        ActivitiesDao ADao = new ActivitiesImp();
       
        if (actividades.getWeekstartDate().before(fecIn) || actividades.getWeekstartDate().after(fecFin)) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR!!", "La fecha del gasto no coincide con la fecha de inicio y fin establecidas para este proyecto"));
        }
        System.out.println("fecha proyecto" + fecIn);
        //System.out.println("fecha actividad" + weekstartDate.getWeekstartDate());
        
      
        ADao.nuevaActividad(actividades);
        actividades = new ItgActivitiesAll();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Éxito","Se agregó correctamente el registro"));
    
        
        }
    
    
    
    
    public void nuevoReporte() {
        ActivitiesDao ADao = new ActivitiesImp();
        actividad.setItgActivitiesAll(actividades);
         ADao.nuevoReporte(actividad);
        actividad = (ItgActivitiesDetail) new ItgActivitiesDetail();
    
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Éxito","Se agregó correctamente el registro"));
       
    }
    
    //Inicia constructor de nuevas actividades     
    @PostConstruct
    public void init() {
        actividad = new ItgActivitiesDetail();
        lista = new ArrayList<ItgActivitiesDetail>();
         
    }
     
    public void createNew() {
        if(lista.contains(actividad)) {
            FacesMessage msg = new FacesMessage("Dublicated", "This book has already been added");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } 
        else {
            lista.add(actividad);
            actividad = new ItgActivitiesDetail();
        }
    }
     
    public String reinit() {
        actividad = new ItgActivitiesDetail();
         
        return null;
    }
     
    public List<ItgActivitiesDetail> getListaTable() {
        ActivitiesDao CDao = new ActivitiesImp();
        listaTable = CDao.listarTable(actividades);
        return listaTable;
    }
    public List<ItgActivitiesAll> getListaTableConsultor() {
        ActivitiesDao CDao = new ActivitiesImp();
        listaTableConsultor = CDao.listarTableActivities(asignacion);
        return listaTableConsultor;
    }
    
    public void modificarActividad() {
        ActivitiesDao CDao = new ActivitiesImp();
        CDao.modificarHoras(obtenerHoras);
        obtenerHoras = new ItgActivitiesDetail();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Éxito","Se modificó correctamente"));
    }
    public void modificarConsultor() {
        ActivitiesDao CDao = new ActivitiesImp();
        CDao.modificarActividades(obtenerConsultor);
        obtenerConsultor = new ItgActivitiesAll();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Éxito","Se modificó correctamente"));
    }
    public void eliminarActividad() {
        ActivitiesDao CDao = new ActivitiesImp();
        CDao.eliminarHoras(obtenerHoras);
        obtenerHoras = new ItgActivitiesDetail();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Éxito","Se elimino correctamente"));
    }
    public void actualizarActividad() {
        ActivitiesDao CDao = new ActivitiesImp();
        CDao.eliminarHoras(obtenerHoras);
        obtenerHoras = new ItgActivitiesDetail();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Éxito","Se elimino correctamente"));
    }
    
     public void valuProy(ValueChangeEvent proyecto) {
        ActivitiesDao Dao = new ActivitiesImp();
        Integer vol = null;

        vol = Integer.parseInt(proyecto.getNewValue().toString());
        System.out.print("el proyecto elejido " + vol);

        for (ItgProjectsAll d : Dao.getProyec()) {
            if (vol == d.getProjectId()) {
                fecIn = d.getProjectStartDate();
                fecFin = d.getProjectEndDate();
                System.out.print("Fecha inicio " + fecIn);
                System.out.print("Fecha Fin " + fecFin);

            }
            /*if (fecFin == null) {
                fecFin = new java.sql.Date(2050, 12, 12);
                System.out.print("Nueva fecha fin " + fecFin);

            }*/

        }
        }

   

     }


