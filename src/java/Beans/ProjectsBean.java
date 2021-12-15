/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Dao.ActivitiesDao;
import Dao.ProjectDao;
import Dao.UsuarioDao;
import Imp.ActivitiesImp;
import Imp.ProjectImp;
import Imp.UsuarioImp;
import Model.ItgExpenseTypes;
import Model.ItgPersonalInfoAll;
import Model.ItgParties;
import Model.ItgProjectsAll;
import Model.ItgUsersAll;
import Model.ItgUserRolesAll;
import Model.ItgWorkArea;
//import com.sun.jmx.remote.internal.ArrayQueue;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.convert.DateTimeConverter;
import javax.faces.model.SelectItem;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.context.RequestContext;

import javax.annotation.PostConstruct;

/**
 *
 * @author DLVC
 */
@ManagedBean
@ViewScoped

public class ProjectsBean {

    private List<ItgProjectsAll> listar;
    //Registrar Gastos A Proyecto
    private List<ItgExpenseTypes> listarGP;
    
    private List<ItgExpenseTypes> listaTableGP;

    private ItgProjectsAll proyectos;
    private ItgExpenseTypes gastos;
    private List<ItgExpenseTypes> lista;
    private ItgExpenseTypes obtenerGastos;
    //Selectlist de Paises - Estados
    private List<SelectItem> listClientes;
    private List<SelectItem> listProyectos;
    private DataTable tabla;
    //Lista de Roles
    private List<SelectItem> listRol;
    private List<SelectItem> listAreas;

    private List<SelectItem> listEmpleado;
    private List<SelectItem> listEmpleadoM;

    public int area;
    public int rol;
    public int cliente;
    //Agregar gastos a proyecto
    public int project;

    public int aprovador;
    private String approver;
    private boolean required = false;

    private int idProyectoNew;

    public ProjectsBean() {
        proyectos = new ItgProjectsAll();
        gastos = new ItgExpenseTypes();
        obtenerGastos = new ItgExpenseTypes();
        listaTableGP = null;
        approver = "No";
        
    }

    public ItgExpenseTypes getObtenerGastos() {
        return obtenerGastos;
    }

    public void setObtenerGastos(ItgExpenseTypes obtenerGastos) {
        this.obtenerGastos = obtenerGastos;
    }

    public String getApprover() {
        return approver;
    }

    public void setApprover(String approver) {
        this.approver = approver;
    }

    public void valueChangeMethod(ValueChangeEvent approver) {

        String valor;
        valor = approver.getNewValue().toString();

        if (valor.equals("Si")) {
            required = true;

        } else if (valor.equals("No")) {
            required = false; 
        }

    }

    public ItgProjectsAll getProyectos() {
        return proyectos;
    }

    public void setProyectos(ItgProjectsAll proyectos) {
        this.proyectos = proyectos;
    }

    public ItgExpenseTypes getGastos() {
        return gastos;
    }

    public void setGastos(ItgExpenseTypes gastos) {
        this.gastos = gastos;
    }

    public List<ItgProjectsAll> getListar() {
        ProjectDao PDao = new ProjectImp();
        listar = PDao.mostrarProjects();
        return listar;
    }

    public void seleccionLista() {
        proyectos = (ItgProjectsAll) tabla.getRowData();
    }

    public DataTable getTabla() {
        return tabla;
    }

    public void setTabla(DataTable tabla) {
        this.tabla = tabla;
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

    public List<SelectItem> getListRol() {
        this.listRol = new ArrayList<SelectItem>();
        UsuarioDao RDao = new UsuarioImp();
        List<ItgUserRolesAll> c = RDao.listaRol(this.area);
        listRol.clear();

        for (ItgUserRolesAll roles : c) {
            SelectItem projectItem = new SelectItem(roles.getUserRoleId(), roles.getUserRoleName());
            this.listRol.add(projectItem);

        }

        return listRol;
    }

    public List<SelectItem> getListEmpleado() {
        this.listEmpleado = new ArrayList<SelectItem>();
        ProjectDao RDao = new ProjectImp();
        List<ItgUsersAll> c = RDao.listarEmpleados(this.area, this.rol);
        listEmpleado.clear();

        for (ItgUsersAll usuario : c) {
            SelectItem projectItem = new SelectItem(usuario.getItgPersonalInfoAll().getPersonalDataId(), usuario.getItgPersonalInfoAll().getName() + " " + usuario.getItgPersonalInfoAll().getPaternSurname() + " " + usuario.getItgPersonalInfoAll().getMaternSurname());
            this.listEmpleado.add(projectItem);

        }

        return listEmpleado;
    }

    public List<SelectItem> getListEmpleadoM() {
        this.listEmpleadoM = new ArrayList<SelectItem>();
        ProjectDao RDao = new ProjectImp();
        List<ItgPersonalInfoAll> c = RDao.listaEmple();
        listEmpleadoM.clear();

        for (ItgPersonalInfoAll usuario : c) {
            SelectItem projectItem = new SelectItem(usuario.getPersonalDataId(), usuario.getName() + " " + usuario.getPaternSurname() + " " + usuario.getMaternSurname());
            this.listEmpleadoM.add(projectItem);

        }

        return listEmpleadoM;
    }

    public void nuevoProject() {

        ProjectDao PDao = new ProjectImp();
        UsuarioDao RDao = new UsuarioImp();
        List<ItgWorkArea> are = RDao.listarAreas();
        List<ItgUserRolesAll> role = RDao.listaRol(area);
        List<ItgUsersAll> users = PDao.listarEmpleados(area, rol);

        String valor;
        valor = approver;
        proyectos.setApprover(approver);

        for (ItgUsersAll user : users) {
            if (user.getItgPersonalInfoAll().getPersonalDataId() == aprovador) {
                proyectos.setItgPersonalApprover(user.getItgPersonalInfoAll());
            }
        }

        for (ItgWorkArea areas : are) {
            if (areas.getAreaId() == area) {
                proyectos.setItgWorkArea(areas);

            }
        }

        for (ItgUserRolesAll proyecto : role) {
            if (proyecto.getUserRoleId() == rol) {
                proyectos.setItgUserRolesAll(proyecto);

            }
        }

        PDao.nuevoProyecto(proyectos);
        proyectos = new ItgProjectsAll();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Se agregó correctamente el registro"));
    }

    public void modificarProject() {
        
        ProjectDao PDao = new ProjectImp();
        for (ItgPersonalInfoAll user : PDao.listaEmple()) {
            if (user.getPersonalDataId() == aprovador) {
                proyectos.setItgPersonalApprover(user);
            }
        }
        PDao.modificarProyecto(proyectos);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Se modificó correctamente"));
        System.out.print("--"+proyectos.getItgPersonalApprover().getPersonalDataId());
         for(ItgUsersAll k: PDao.listarUsers()){
             if(k.getItgPersonalInfoAll().getPersonalDataId() == proyectos.getItgPersonalApprover().getPersonalDataId()){
                 proyectos.setItgWorkArea(k.getItgWorkArea());
                 PDao.modificarAre(proyectos.getProjectId(), k.getItgWorkArea().getAreaId());
                 
                 proyectos.setItgUserRolesAll(k.getItgUserRolesAll());
                 PDao.modificarRole(proyectos.getProjectId(), k.getItgUserRolesAll().getUserRoleId());
                 
              }
         }
    }

    public void eliminarProject() {
        ProjectDao PDao = new ProjectImp();
        PDao.eliminarProyecto(proyectos);
        proyectos = new ItgProjectsAll();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Se eliminó correctamente"));
    }

    public List<SelectItem> getListClientes() {
        this.listClientes = new ArrayList<SelectItem>();
        ProjectDao PDao = new ProjectImp();
        List<ItgParties> c = PDao.listarClientes();
        listClientes.clear();

        for (ItgParties cliente : c) {
            SelectItem projectItem = new SelectItem(cliente.getPartyId(), cliente.getPartyName());
            this.listClientes.add(projectItem);

        }
        return listClientes;
    }
    
    public List<SelectItem> getListProyectos() {
        this.listProyectos = new ArrayList<SelectItem>();
        ActivitiesDao ADao = new ActivitiesImp();
        List<ItgProjectsAll> c = ADao.listarProy(this.cliente);
        listProyectos.clear();

        for (ItgProjectsAll proyecto : c) {
            SelectItem projectItem = new SelectItem(proyecto.getProjectId(), proyecto.getProjectName());
            this.listProyectos.add(projectItem);

        }

        return listProyectos;
    }

    public void getIdProyecto(ValueChangeEvent valueChangeEvent) {

        this.idProyectoNew = Integer.parseInt(valueChangeEvent.getNewValue().toString());

    }

    public void nuevoGastoP() {
        ProjectDao PDao = new ProjectImp();
        gastos.setItgProjectsAll(proyectos);
        PDao.nuevoGastoP(gastos);
        gastos = (ItgExpenseTypes) new ItgExpenseTypes();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Se agregó correctamente el registro"));
    }

    public void createNew() {
        if (lista.contains(gastos)) {
            FacesMessage msg = new FacesMessage("Dublicated", "This book has already been added");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            lista.add(gastos);
            gastos = new ItgExpenseTypes();
        }
    }

    public String reinit() {
        gastos = new ItgExpenseTypes();

        return null;
    }

    public List<ItgExpenseTypes> getListaTableGP() {
        listaTableGP = new ArrayList<ItgExpenseTypes>();
        ProjectDao PDao = new ProjectImp();

        this.listProyectos = new ArrayList<SelectItem>();
        ActivitiesDao ADao = new ActivitiesImp();
        List<ItgProjectsAll> c = ADao.listarProy(this.cliente);
        listProyectos.clear();

        for (ItgProjectsAll proyecto : c) {
            if (proyecto.getProjectId() == idProyectoNew) {
                listaTableGP = PDao.listarTableGP(proyecto);
            }
        }

        //listaTableGP = PDao.listarTableGP(proyectos);
        return listaTableGP;
    }

    public void modificarGasto() {
        ProjectDao PDao = new ProjectImp();
        PDao.modificarGasto(obtenerGastos);
        obtenerGastos = new ItgExpenseTypes();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Se modificó correctamente"));
    }

    public void eliminarGasto() {
        ProjectDao PDao = new ProjectImp();
        PDao.eliminarGasto(obtenerGastos);
        obtenerGastos = new ItgExpenseTypes();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Se elimino correctamente"));
    }

    public void actualizarGasto() {
        ProjectDao PDao = new ProjectImp();
        PDao.eliminarGasto(obtenerGastos);
        obtenerGastos = new ItgExpenseTypes();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Se elimino correctamente"));
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public int getAprovador() {
        return aprovador;
    }

    public void setAprovador(int aprovador) {
        this.aprovador = aprovador;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public int getProject() {
        return project;
    }

    public void setProject(int project) {
        this.project = project;
    }

    /**
     * @param idProyectoNew the idProyectoNew to set
     */
    public void setIdProyectoNew(int idProyectoNew) {
        this.idProyectoNew = idProyectoNew;
    }

}
