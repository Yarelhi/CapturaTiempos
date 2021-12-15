/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Dao.CompanyDao;
import Imp.OrganizacionImp;
import Model.ItgCitiesAll;
import Model.ItgCompany;
import Model.ItgPersonalInfoAll;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
//import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import org.primefaces.event.SelectEvent;
/**
 *
 * @author ITG
 */

@ManagedBean

public class OrgBean {
    
    
    private ItgCompany empresa; 
    
    
    //Lista Table
    private List<ItgCompany> listaTable;
    private List<ItgCompany> listarTableEmp;
    private ItgCompany table;
    
     //Selectlist Empresa
    private List<SelectItem> listEmpresa;
      private List<SelectItem> listaEmpresa;
    
       //Registrar CitiesAll
    /*private List<ItgCitiesAll> listarC;
    private ItgCitiesAll ciudades;*/
    
    public OrgBean() {
        empresa = new ItgCompany();
        
    }
    
    public ItgCompany getEmpresa() {
        return empresa;
    }

    public void setEmpresa(ItgCompany empresa) {
        this.empresa = empresa;
    }
    
    public void nuevaEmpresa(){
        CompanyDao CDao = new OrganizacionImp();
        CDao.nuevaEmpresa(empresa);
        empresa = new ItgCompany();
        //Resgistra CitiesAll
        /*CDao.nuevaCiudad(ciudades);
        ciudades = new ItgCitiesAll();*/
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Éxito","Se agregó correctamente el registro"));
    }
    
     public void modificarEmpresa() {
        CompanyDao CDao = new OrganizacionImp();
        CDao.modificarEmpresa(empresa);
        empresa = new ItgCompany();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Éxito","Se modificó correctamente"));
    }
    
    public void eliminarEmpresa() {
        CompanyDao CDao = new OrganizacionImp();
        CDao.eliminarEmpresa(empresa);
        empresa = new ItgCompany();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Éxito","Se eliminó correctamente"));
    }
    
       public ItgCompany getTable() {
        return table;
    }

    public void setTable(ItgCompany table) {
        this.table = table;
    }

    public List<ItgCompany> getListaTable() {
        CompanyDao CDao = new OrganizacionImp();
        listaTable = CDao.listarTable();
        return listaTable;
    }

    public List<ItgCompany> getListarTableEmp() {
        CompanyDao CDao = new OrganizacionImp();
        listarTableEmp = CDao.listarTableEmp();
        return listarTableEmp;
    }  
    
    public List<SelectItem> getListEmpresa() {
     this.listEmpresa= new ArrayList<SelectItem>();
    CompanyDao ADao = new OrganizacionImp();
      List<ItgCompany> c = ADao.listarEmpresas();
       listEmpresa.clear();

      for (ItgCompany empresa : c) {
         SelectItem projectItem = new SelectItem(empresa.getOrganizacionId(),empresa.getOrgName());
          this.listEmpresa .add(projectItem);

       }
   // ActivitiesDao ADao = new ActivitiesImp();
    //    listEmpleado = ADao.listarEmpleados();
        return listEmpresa;
    }
    
}

    

