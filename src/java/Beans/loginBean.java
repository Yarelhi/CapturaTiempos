/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Dao.ClienteDao;
import Dao.CompanyDao;
import Dao.UsuarioDao;
import Imp.CustomerImp;
import Imp.OrganizacionImp;
import Imp.UsuarioImp;
import Model.ItgCitiesAll;
import Model.ItgCompany;
import Model.ItgUsersAll;
import Model.ItgUserRolesAll;
import Model.ItgListValuesDet;
import Model.ItgWorkArea;
import Util.MyUtil;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import org.apache.commons.codec.digest.DigestUtils;
import org.primefaces.context.RequestContext;

/**
 *
 * @author DLVC
 */
@ManagedBean
@SessionScoped
public class loginBean implements Serializable {

    private ItgUsersAll usuario;
    private ItgUsersAll Status;
    private ItgCompany org;
    private UsuarioDao usuarioDao;
   
    private List<ItgUsersAll> listarUsuario;
    //Selectlist roles
    private List<SelectItem> listAreas;
    private List<SelectItem> listRoles;
    private List<SelectItem> listavalor;

    public loginBean() {
        this.usuarioDao = new UsuarioImp();
        if (this.usuario == null) {
            this.usuario = new ItgUsersAll();
            
        }
        
    }

    public ItgUsersAll getUsuario() {
        return usuario;
    }

    public ItgUsersAll getStatus() {
        return Status;
    }
    
     public ItgCompany getOrg() {
        return org;
    }

    public void setStatus(ItgUsersAll Status) {
        this.Status = Status;
    }

    public void setUsuario(ItgUsersAll usuario) {
        this.usuario = usuario;
    }
    
     public void setOrg(ItgCompany org) {
        this.org = org;
    }
    
    
    
    

    public List<ItgUsersAll> getListarUsuario() {
        UsuarioDao UDao = new UsuarioImp();
        listarUsuario = UDao.mostrarUsuarios();
        return listarUsuario;
    }

   
    
    public List<SelectItem> getListAreas() {
        this.listAreas = new ArrayList<SelectItem>();
        UsuarioDao RDao = new UsuarioImp();
        List<ItgWorkArea> c = RDao.listarAreas();
        listAreas.clear();

        for (ItgWorkArea areas : c) {
            SelectItem AreatItem = new SelectItem(areas.getAreaId(), areas.getNameArea());
            this.listAreas.add(AreatItem);

        }
        return listAreas;
    }
    
    
    public List<SelectItem> getListRoles() {
        this.listRoles = new ArrayList<SelectItem>();
        UsuarioDao RDao = new UsuarioImp();
        List<ItgUserRolesAll> c = RDao.listarRoles(this.usuario);
        listRoles.clear();

        for (ItgUserRolesAll roles : c) {
            SelectItem RoltItem = new SelectItem(roles.getUserRoleId(), roles.getUserRoleName());
            this.listRoles.add(RoltItem);

        }
        return listRoles;
    }
    
    
    

    public void nuevoUsuario() {
        UsuarioDao CDao = new UsuarioImp();
        CDao.nuevoUsuario(usuario);
        usuario = new ItgUsersAll();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Se agregó correctamente el registro"));
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
 
    
    public void modificarUsuario() {
        UsuarioDao CDao = new UsuarioImp();
        CDao.modificarUsuario(usuario);
        usuario = new ItgUsersAll();
       
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Éxito","Se modificó correctamente"));
    }
    public void modificarStatus() {
        UsuarioDao CDao = new UsuarioImp();
        CDao.modificarStatus(Status);
       Status = new ItgUsersAll();
       
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Éxito","Se modificó correctamente"));
    }
    
     public void modificarOrg() {
        UsuarioDao CDao = new UsuarioImp();
        CDao.modificarOrg(org);
        org = new ItgCompany();
       
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Éxito","Se modificó correctamente"));
    }
    
 
}
