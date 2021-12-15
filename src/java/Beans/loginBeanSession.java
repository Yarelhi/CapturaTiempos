package Beans;

import Dao.ReportExpensesDao;
import java.awt.event.ActionEvent;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import Model.ItgUsersAll;
import org.primefaces.context.RequestContext;
import Dao.UsuarioDaoSession;
import Imp.ReportExpensesImp;
import Imp.UsuarioDaoImpSession;
import Model.ItgExpenseReportsAll;
import Model.ItgUserRolesAll;
import java.util.List;

/**
 *
 * @author ROMERO
 */
@ManagedBean
@SessionScoped
public class loginBeanSession {

    //Tabla de reportes creados
    private List<ItgExpenseReportsAll> listaTabReport;
    //Tabla para el aprovador de reprotes enviados por gmail
    private List<ItgExpenseReportsAll> listaTabAproRe;

    private ItgUsersAll usuario;

    private String username;

    private String password;

    public loginBeanSession() {
        this.usuario = new ItgUsersAll();
    }

    public ItgUsersAll getUsuario() {
        return usuario;
    }

    public void setUsuario(ItgUsersAll usuario) {
        this.usuario = usuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String ruta = "";
    public boolean loggedIn;

    public void loginSession(ActionEvent event) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message;

        UsuarioDaoSession uDao = new UsuarioDaoImpSession();
        this.usuario = uDao.loginSession(this.usuario);
        
       /* if (this.usuario != null && this.usuario.getItgCompany().getOrganizacionId() == 5){
            ruta = "/CapturaTiempos/faces/resources/img/taurino";
            System.out.print("El id es:" + usuario.getItgCompany().getOrganizacionId());
        }else {
            if (this.usuario != null && this.usuario.getItgCompany().getOrganizacionId() == 6){
            ruta = "/CapturaTiempos/faces/resources/img/lga";
            System.out.print("El id es:" + usuario.getItgCompany().getOrganizacionId());
        
            }   else {
                    if (this.usuario != null && this.usuario.getItgCompany().getOrganizacionId() == 7){
                    ruta = "/CapturaTiempos/faces/resources/img/itglobal";
                    System.out.print("El id es:" + usuario.getItgCompany().getOrganizacionId());
            }
        }
    }*/
            

        if (this.usuario != null && this.usuario.getItgUserRolesAll().getUserRoleId() == 1) {

            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", this.usuario.getUsername());
            loggedIn = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", this.usuario.getUsername());
            ruta = "/CapturaTiempos/faces/Views/Direccion/Direccionindex.xhtml";
            System.out.print("El id es:" + usuario.getItgPersonalInfoAll().getPersonalDataId());

        } else {
            if (this.usuario != null && this.usuario.getItgUserRolesAll().getUserRoleId() == 6) {

                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", this.usuario.getUsername());
                loggedIn = true;
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", this.usuario.getUsername());
                ruta = "/CapturaTiempos/faces/Views/Direccion/Direccionindex.xhtml";
                System.out.print("El id es:" + usuario.getItgPersonalInfoAll().getPersonalDataId());

            } else {
                if (this.usuario != null && this.usuario.getItgUserRolesAll().getUserRoleId() == 8) {

                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", this.usuario.getUsername());
                    loggedIn = true;
                    message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", this.usuario.getUsername());
                    ruta = "/CapturaTiempos/faces/Views/Direccion/Direccionindex.xhtml";
                    System.out.print("El id es:" + usuario.getItgPersonalInfoAll().getPersonalDataId());

                } else {
                    if (this.usuario != null && this.usuario.getItgUserRolesAll().getUserRoleId() == 16) {

                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", this.usuario.getUsername());
                        loggedIn = true;
                        message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", this.usuario.getUsername());
                        ruta = "/CapturaTiempos/faces/Views/Direccion/Direccionindex.xhtml";
                        System.out.print("El id es:" + usuario.getItgPersonalInfoAll().getPersonalDataId());

                    } else {
                        if (this.usuario != null && this.usuario.getItgUserRolesAll().getUserRoleId() == 22) {

                            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", this.usuario.getUsername());
                            loggedIn = true;
                            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", this.usuario.getUsername());
                            ruta = "/CapturaTiempos/faces/Views/Direccion/Direccionindex.xhtml";
                            System.out.print("El id es:" + usuario.getItgPersonalInfoAll().getPersonalDataId());

                        } else {
                            if (this.usuario != null && this.usuario.getItgUserRolesAll().getUserRoleId() == 11) {

                                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", this.usuario.getUsername());
                                loggedIn = true;
                                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", this.usuario.getUsername());
                                ruta = "/CapturaTiempos/faces/Views/Admin/A-AdminIndex.xhtml";
                                System.out.print("El id es:" + usuario.getItgPersonalInfoAll().getPersonalDataId());

                            } else {
                                if (this.usuario != null && this.usuario.getItgUserRolesAll().getUserRoleId() == 3) {

                                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", this.usuario.getUsername());
                                    loggedIn = true;
                                    message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", this.usuario.getUsername());
                                    ruta = "/CapturaTiempos/faces/Views/Gerente/G-Index.xhtml";
                                    System.out.print("El id es:" + usuario.getItgPersonalInfoAll().getPersonalDataId());

                                } else {
                                    if (this.usuario != null && this.usuario.getItgUserRolesAll().getUserRoleId() == 13) {

                                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", this.usuario.getUsername());
                                        loggedIn = true;
                                        message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", this.usuario.getUsername());
                                        ruta = "/CapturaTiempos/faces/Views/ControlAdmin/CA-Index.xhtml";
                                        System.out.print("El id es:" + usuario.getItgPersonalInfoAll().getPersonalDataId());

                                    } else {
                                        if (this.usuario != null && this.usuario.getItgUserRolesAll().getUserRoleId() == 14) {

                                            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", this.usuario.getUsername());
                                            loggedIn = true;
                                            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", this.usuario.getUsername());
                                            ruta = "/CapturaTiempos/faces/Views/Gerente/G-Index.xhtml";
                                            System.out.print("El id es:" + usuario.getItgPersonalInfoAll().getPersonalDataId());

                                        } else {
                                            if (this.usuario != null && this.usuario.getItgUserRolesAll().getUserRoleId() == 17) {

                                                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", this.usuario.getUsername());
                                                loggedIn = true;
                                                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", this.usuario.getUsername());
                                                ruta = "/CapturaTiempos/faces/Views/Gerente/G-Index.xhtml";
                                                System.out.print("El id es:" + usuario.getItgPersonalInfoAll().getPersonalDataId());

                                            } else {
                                                if (this.usuario != null && this.usuario.getItgUserRolesAll().getUserRoleId() == 19) {

                                                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", this.usuario.getUsername());
                                                    loggedIn = true;
                                                    message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", this.usuario.getUsername());
                                                    ruta = "/CapturaTiempos/faces/Views/Gerente/G-Index.xhtml";
                                                    System.out.print("El id es:" + usuario.getItgPersonalInfoAll().getPersonalDataId());

                                                } else {
                                                    if (this.usuario != null && this.usuario.getItgUserRolesAll().getUserRoleId() == 4) {

                                                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", this.usuario.getUsername());
                                                        loggedIn = true;
                                                        message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", this.usuario.getUsername());
                                                        ruta = "/CapturaTiempos/faces/Views/Consultor/C-Index.xhtml";
                                                        System.out.print("El id es:" + usuario.getItgPersonalInfoAll().getPersonalDataId());

                                                    } else {
                                                        if (this.usuario != null && this.usuario.getItgUserRolesAll().getUserRoleId() == 21) {

                                                            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", this.usuario.getUsername());
                                                            loggedIn = true;
                                                            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", this.usuario.getUsername());
                                                            ruta = "/CapturaTiempos/faces/Views/Consultor/C-Index.xhtml";
                                                            System.out.print("El id es:" + usuario.getItgPersonalInfoAll().getPersonalDataId());

                                                        } else {
                                                            if (this.usuario != null && this.usuario.getItgUserRolesAll().getUserRoleId() == 10) {

                                                                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", this.usuario.getUsername());
                                                                loggedIn = true;
                                                                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", this.usuario.getUsername());
                                                                ruta = "/CapturaTiempos/faces/Views/Contador/CP-Index.xhtml";
                                                                System.out.print("El id es:" + usuario.getItgPersonalInfoAll().getPersonalDataId());

                                                            } else {
                                                                if (this.usuario != null && this.usuario.getItgUserRolesAll().getUserRoleId() == 5) {
                                                                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", this.usuario.getUsername());
                                                                    loggedIn = true;
                                                                    message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", this.usuario.getUsername());
                                                                    ruta = "/CapturaTiempos/faces/Views/Lider/L-Index.xhtml";
                                                                    System.out.print("El id es:" + usuario.getItgPersonalInfoAll().getPersonalDataId());
                                                                } else {
                                                                    if (this.usuario != null && this.usuario.getItgUserRolesAll().getUserRoleId() == 15) {
                                                                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", this.usuario.getUsername());
                                                                        loggedIn = true;
                                                                        message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", this.usuario.getUsername());
                                                                        ruta = "/CapturaTiempos/faces/Views/Consultor/C-Index.xhtml";
                                                                        System.out.print("El id es:" + usuario.getItgPersonalInfoAll().getPersonalDataId());
                                                                    } else {
                                                                        if (this.usuario != null && this.usuario.getItgUserRolesAll().getUserRoleId() == 18) {
                                                                            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", this.usuario.getUsername());
                                                                            loggedIn = true;
                                                                            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", this.usuario.getUsername());
                                                                            ruta = "/CapturaTiempos/faces/Views/Lider/L-Index.xhtml";
                                                                            System.out.print("El id es:" + usuario.getItgPersonalInfoAll().getPersonalDataId());
                                                                        } else {
                                                                            if (this.usuario != null && this.usuario.getItgUserRolesAll().getUserRoleId() == 20) {
                                                                                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", this.usuario.getUsername());
                                                                                loggedIn = true;
                                                                                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", this.usuario.getUsername());
                                                                                ruta = "/CapturaTiempos/faces/Views/Lider/L-Index.xhtml";
                                                                                System.out.print("El id es:" + usuario.getItgPersonalInfoAll().getPersonalDataId());
                                                                            } else {
                                                                                if (this.usuario != null && this.usuario.getItgUserRolesAll().getUserRoleId() == 7) {
                                                                                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", this.usuario.getUsername());
                                                                                    loggedIn = true;
                                                                                    message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", this.usuario.getUsername());
                                                                                    ruta = "/CapturaTiempos/faces/Views/Consultor/C-Index.xhtml";
                                                                                    System.out.print("El id es:" + usuario.getItgPersonalInfoAll().getPersonalDataId());
                                                                                } else {
                                                                                    if (this.usuario != null && this.usuario.getItgUserRolesAll().getUserRoleId() == 9) {
                                                                                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", this.usuario.getUsername());
                                                                                        loggedIn = true;
                                                                                        message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", this.usuario.getUsername());
                                                                                        ruta = "/CapturaTiempos/faces/Views/ControlAdmin/CA-Index.xhtml";
                                                                                        System.out.print("El id es:" + usuario.getItgPersonalInfoAll().getPersonalDataId());
                                                                                    } else {
                                                                                        if (this.usuario != null && this.usuario.getItgUserRolesAll().getUserRoleId() == 12) {
                                                                                            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", this.usuario.getUsername());
                                                                                            loggedIn = true;
                                                                                            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", this.usuario.getUsername());
                                                                                            ruta = "/CapturaTiempos/faces/Views/ControlAdmin/CA-Index.xhtml";
                                                                                            System.out.print("El id es:" + usuario.getItgPersonalInfoAll().getPersonalDataId());
                                                                                        } else {

                                                                                            loggedIn = false;
                                                                                            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error de Acesso", "Usuario inactivo o datos incorrectos");
                                                                                            this.usuario = new ItgUsersAll();
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

            }

        }
        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("loggedIn", loggedIn);
        context.addCallbackParam("ruta", ruta);
    }
        

    public String cerrarSession() {
        this.username = null;
        this.password = null;
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/Login?faces-redirect=true";
    }

    public List<ItgExpenseReportsAll> getListaTabReport() {
        ReportExpensesDao Dao = new ReportExpensesImp();
        listaTabReport = Dao.listarTabReport(usuario);

        for (ItgExpenseReportsAll exall : listaTabReport) {
            System.out.print("--> Valor " + exall.getNameReport());
        }
        System.out.print("id" + usuario.getItgPersonalInfoAll().getPersonalDataId());
        return listaTabReport;

    }

    public List<ItgExpenseReportsAll> getListaTabAproRe() {
        ReportExpensesDao Dao = new ReportExpensesImp();
        listaTabAproRe = Dao.listarTabAproRe(usuario);
        System.out.print("id" + usuario.getItgPersonalInfoAll().getPersonalDataId());
        return listaTabAproRe;
    }

}
