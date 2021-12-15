/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Dao.ClienteDao;
import Imp.CustomerImp;
import Model.ItgCitiesAll;
import Model.ItgCountriesAll;
import Model.ItgEmployeesTypesAll;
import Model.ItgParties;
import Model.ItgStatesAll;
import Model.ItgListValuesDet;
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
public class PartiesBean {
    //Registrar PersonalDataAll
    private List<ItgParties> listar;
    private ItgParties clientes;    
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
    private List<ItgParties> listaTable;
    private List<ItgParties> listaTableEmp;
    private ItgParties table;

    public PartiesBean() {
        clientes = new ItgParties();
        ciudades = new ItgCitiesAll();
    }

    public ItgParties getClientes() {
        return clientes;
    }

    public void setClientes(ItgParties clientes) {
        this.clientes = clientes;
    }

    public List<ItgParties> getListar() {
        ClienteDao PDao = new CustomerImp();
        listar=PDao.mostrarClientes();
        return listar;
    }
    
    public void nuevoClientes(){
        ClienteDao CDao = new CustomerImp();
        CDao.nuevoClientes(clientes);
        clientes = new ItgParties();
        //Resgistra CitiesAll
        CDao.nuevaCiudad(ciudades);
        ciudades = new ItgCitiesAll();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Éxito","Se agregó correctamente el registro"));
    }
    
    
    public void nuevaCiudad(){
        ClienteDao CDao = new CustomerImp();
        //Resgistra CitiesAll
        CDao.nuevaCiudad(ciudades);
        ciudades = new ItgCitiesAll();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Éxito","Se agregó correctamente el registro"));
    }
    
    public void modificarCliente() {
        ClienteDao CDao = new CustomerImp();
        CDao.modificarCliente(clientes);
        clientes = new ItgParties();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Éxito","Se modificó correctamente"));
    }
    
    public void eliminarCliente() {
        ClienteDao CDao = new CustomerImp();
        CDao.eliminarCliente(clientes);
        clientes = new ItgParties();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Éxito","Se eliminó correctamente"));
    }
    
    //Lista Paises
    public List<SelectItem> getListPaises() {
        this.listPaises = new ArrayList<SelectItem>();
        ClienteDao PDao = new CustomerImp();
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
        ClienteDao CFDao = new CustomerImp();
        List<ItgStatesAll> e = CFDao.listarEstados(this.clientes);
        listEstados.clear();
        
        for (ItgStatesAll estado : e) {
            SelectItem estadoItem = new SelectItem(estado.getStateId(),estado.getStateName());
            this.listEstados.add(estadoItem);
            
        }
        return listEstados;
    }

    public List<SelectItem> getListCiudades() {
        this.listCiudades = new ArrayList<SelectItem>();
        ClienteDao CFDao = new CustomerImp();
        List<ItgCitiesAll> e = CFDao.listarCiudades(this.clientes);
        listCiudades.clear();
        
        for (ItgCitiesAll ciudad : e) {
            SelectItem ciudadItem = new SelectItem(ciudad.getCityId(),ciudad.getCityName());
            this.listCiudades.add(ciudadItem);
            
        }
        return listCiudades;
    }

    public List<SelectItem> getListEmpCustomer() {
        this.listEmpCustomer = new ArrayList<SelectItem>();
        ClienteDao PDao = new CustomerImp();
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
        ClienteDao PDao = new CustomerImp();
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
        ClienteDao VDao = new CustomerImp();
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
        ClienteDao CiDao = new CustomerImp();
        listarC=CiDao.mostrarCiudades();
        return listarC;
    }

    public ItgParties getTable() {
        return table;
    }

    public void setTable(ItgParties table) {
        this.table = table;
    }

    public List<ItgParties> getListaTable() {
        ClienteDao CDao = new CustomerImp();
        listaTable = CDao.listarTable();
        return listaTable;
    }

    public List<ItgParties> getListaTableEmp() {
        ClienteDao CDao = new CustomerImp();
        listaTableEmp = CDao.listarTableEmp();
        return listaTableEmp;
    }  
    
    
}

    

