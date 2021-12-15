/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Dao.EmpleadoDao;
import Imp.EmployeesImp;
import Model.ItgCitiesAll;
import Model.ItgCountriesAll;
import Model.ItgEmployeesTypesAll;
import Model.ItgPersonalInfoAll;
import Model.ItgStatesAll;
import Model.ItgListValuesDet;
import Model.ItgUserRolesAll;
import Model.ItgUsersAll;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author DLVC
 */
@ManagedBean
@ViewScoped
public class CustomerBean {
    //Registrar PersonalDataAll
    private List<ItgPersonalInfoAll> listar;
    private ItgPersonalInfoAll empleados;    
    //Selectlist de Paises - Estados
    private List<SelectItem> listPaises;    
    private List<SelectItem> listEstados;
    private List<SelectItem> listCiudades;  
    private List<SelectItem> listEmpCustomer;
    private List<SelectItem> listEmpCustomerE; 
     //Registrar CitiesAll
    private List<ItgCitiesAll> listarC;
    private ItgCitiesAll ciudades;
    //Lista de Valores
    private List<SelectItem> listavalor;
    //Lista Table
    private List<ItgPersonalInfoAll> listaTable;
    private List<ItgPersonalInfoAll> listaTableEmp;
    private ItgPersonalInfoAll table;
      
    //Selectlist director
    private List<SelectItem> listDirector;
      private List<SelectItem> listaDirector;

       //Selectlist director
    private List<SelectItem> listGerente;
      private List<SelectItem> listaGerente;

       //Selectlist director
    private List<SelectItem> listLider;
      private List<SelectItem> listaLider;

    
    

    public CustomerBean() {
        empleados = new ItgPersonalInfoAll();
        ciudades = new ItgCitiesAll();
    }

    public ItgPersonalInfoAll getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ItgPersonalInfoAll empleados) {
        this.empleados = empleados;
    }

    public List<ItgPersonalInfoAll> getListar() {
        EmpleadoDao PDao = new EmployeesImp();
        listar=PDao.mostrarClientes();
        return listar;
    }
    
    public void nuevoEmpleados(){
        EmpleadoDao CDao = new EmployeesImp();
        CDao.nuevoClientes(empleados);
        empleados = new ItgPersonalInfoAll();
        //Resgistra CitiesAll
        CDao.nuevaCiudad(ciudades);
        ciudades = new ItgCitiesAll();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Éxito","Se agregó correctamente el registro"));
    }
    
    
    public void nuevaCiudad(){
        EmpleadoDao CDao = new EmployeesImp();
        //Resgistra CitiesAll
        CDao.nuevaCiudad(ciudades);
        ciudades = new ItgCitiesAll();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Éxito","Se agregó correctamente el registro"));
    }
    
    public void modificarEmpleado() {
        EmpleadoDao CDao = new EmployeesImp();
        CDao.modificarCliente(empleados);
        empleados = new ItgPersonalInfoAll();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Éxito","Se modificó correctamente"));
    }
    
    public void eliminarEmpleado() {
        EmpleadoDao CDao = new EmployeesImp();
        CDao.eliminarCliente(empleados);
        empleados = new ItgPersonalInfoAll();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Éxito","Se eliminó correctamente"));
    }
    
    //Lista Paises
    public List<SelectItem> getListPaises() {
        this.listPaises = new ArrayList<SelectItem>();
        EmpleadoDao PDao = new EmployeesImp();
        List<ItgCountriesAll> p = PDao.listarPaises();
        listPaises.clear();
        
        for (ItgCountriesAll pais : p) {
            SelectItem paisItem = new SelectItem(pais.getCountryId(),pais.getCountryName());
            this.listPaises.add(paisItem);
            
        }
                
        return listPaises;
    }
    
    public List<SelectItem> getListEstados() {
        this.listEstados = new ArrayList<SelectItem>();
        EmpleadoDao CFDao = new EmployeesImp();
        List<ItgStatesAll> e = CFDao.listarEstados(this.empleados);
        listEstados.clear();
        
        for (ItgStatesAll estado : e) {
            SelectItem estadoItem = new SelectItem(estado.getStateId(),estado.getStateName());
            this.listEstados.add(estadoItem);
            
        }
        return listEstados;
    }

    public List<SelectItem> getListCiudades() {
        this.listCiudades = new ArrayList<SelectItem>();
        EmpleadoDao CFDao = new EmployeesImp();
        List<ItgCitiesAll> e = CFDao.listarCiudades(this.empleados);
        listCiudades.clear();
        
        for (ItgCitiesAll ciudad : e) {
            SelectItem ciudadItem = new SelectItem(ciudad.getCityId(),ciudad.getCityName());
            this.listCiudades.add(ciudadItem);
            
        }
        return listCiudades;
    }

    public List<SelectItem> getListEmpCustomer() {
        this.listEmpCustomer = new ArrayList<SelectItem>();
        EmpleadoDao PDao = new EmployeesImp();
        List<ItgEmployeesTypesAll> p = PDao.listarEmpCus();
        listEmpCustomer.clear();
        
        for (ItgEmployeesTypesAll emp : p) {
            SelectItem empItem = new SelectItem(emp.getEmployeeCustomerId(),emp.getName());
            this.listEmpCustomer.add(empItem);
            
        }
        return listEmpCustomer;
    }

    public List<SelectItem> getListEmpCustomerE() {
        this.listEmpCustomerE = new ArrayList<SelectItem>();
        EmpleadoDao PDao = new EmployeesImp();
        List<ItgEmployeesTypesAll> p = PDao.listarEmpCusEmp();
        listEmpCustomerE.clear();
        
        for (ItgEmployeesTypesAll emp : p) {
            SelectItem empItem = new SelectItem(emp.getEmployeeCustomerId(),emp.getName());
            this.listEmpCustomerE.add(empItem);
            
        }
        return listEmpCustomerE;
    }  
    

    public List<SelectItem> getListavalor() {
        this.listavalor = new ArrayList<SelectItem>();
        EmpleadoDao VDao = new EmployeesImp();
        List<ItgListValuesDet> v = VDao.listaValor();
        listavalor.clear();
        
        for (ItgListValuesDet valor : v) {
            SelectItem valorItem = new SelectItem(valor.getValueListDetailId(),valor.getValueListDetailValue());
            this.listavalor.add(valorItem);
            
        }
        return listavalor;
    }   
 
    //Métodos para Registrar - Listar Ciudades - CitiesAll
    public ItgCitiesAll getCiudades() {
        return ciudades;
    }

    public void setCiudades(ItgCitiesAll ciudades) {
        this.ciudades = ciudades;
    }

    public List<ItgCitiesAll> getListarC() {
        EmpleadoDao CiDao = new EmployeesImp();
        listarC=CiDao.mostrarCiudades();
        return listarC;
    }

    public ItgPersonalInfoAll getTable() {
        return table;
    }

    public void setTable(ItgPersonalInfoAll table) {
        this.table = table;
    }

    public List<ItgPersonalInfoAll> getListaTable() {
        EmpleadoDao CDao = new EmployeesImp();
        listaTable = CDao.listarTable();
        return listaTable;
    }

    public List<ItgPersonalInfoAll> getListaTableEmp() {
        EmpleadoDao CDao = new EmployeesImp();
        listaTableEmp = CDao.listarTableEmp();
        return listaTableEmp;
    }  
    
    
    public List<SelectItem> getListDirector() {
     this.listDirector = new ArrayList<SelectItem>();
    EmpleadoDao ADao = new EmployeesImp();
      List<ItgUsersAll> c = ADao.listarDirectores();
       listDirector.clear();

      for (ItgUsersAll director : c) {
         SelectItem projectItem = new SelectItem(director.getUserId(), director.getUsername());
          this.listDirector .add(projectItem);

       }
   // ActivitiesDao ADao = new ActivitiesImp();
    //    listEmpleado = ADao.listarEmpleados();
        return listDirector;
    }
    
    public List<SelectItem> getListGerente() {
     this.listGerente = new ArrayList<SelectItem>();
    EmpleadoDao ADao = new EmployeesImp();
      List<ItgUsersAll> c = ADao.listarGerentes();
       listGerente.clear();

      for (ItgUsersAll director : c) {
         SelectItem projectItem = new SelectItem(director.getUserId(), director.getUsername());
          this.listGerente .add(projectItem);

       }
   // ActivitiesDao ADao = new ActivitiesImp();
    //    listEmpleado = ADao.listarEmpleados();
        return listGerente;
    }
    
     public List<SelectItem> getListLider() {
     this.listLider = new ArrayList<SelectItem>();
    EmpleadoDao ADao = new EmployeesImp();
      List<ItgUsersAll> c = ADao.listarLider();
       listLider.clear();

      for (ItgUsersAll director : c) {
         SelectItem projectItem = new SelectItem(director.getUserId(), director.getUsername());
          this.listLider .add(projectItem);

       }
   // ActivitiesDao ADao = new ActivitiesImp();
    //    listEmpleado = ADao.listarEmpleados();
        return listLider;
    }
    
    
}
