/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Dao.ActivitiesDao;
import Dao.ReportExpensesDao;
import Dao.UsuarioDaoSession;
import Imp.ActivitiesImp;
import Imp.ReportExpensesImp;
import Imp.UsuarioDaoImpSession;
import Model.ItgActivitiesAll;
import Model.ItgExpenseReportsDetail;
import Model.ItgExpenseReportsAll;
import Model.ItgPersonalInfoAll;
import Model.ItgProjectsAll;
import Model.ItgVouchersStatus;
import Model.ItgReportStatus;
import Model.ItgUsersAll;
import Model.ItgExpenseTypes;
import Reportes.mail.MailClient;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;

/**
 *
 * @author DLVC
 */
@ManagedBean (name = "reportExpensesBean", eager = true)
@ViewScoped

public class ReportExpensesBean {

    private ItgExpenseReportsAll obtenerReporte;
    private ItgExpenseReportsAll reporte;
    private ItgUsersAll usuario;
    private ItgExpenseReportsDetail obtenerTiGast;
    private ItgExpenseReportsAll obtenerGastR;
    private ItgExpenseReportsAll Status;
    private ItgExpenseReportsAll statusP;
    private ItgExpenseReportsAll comprobantes;
    private ItgExpenseReportsAll datos;

    //Lista de proyectos
    private List<SelectItem> listActividad;
    private List<SelectItem> listGastoRepor;
    private List<SelectItem> listGastoReporM;

    private List<SelectItem> listStatusReport;
    private List<SelectItem> listStatusReportP;
    private List<SelectItem> listStatusReportVo;


    public int realizo;
    public int typeExpen;
    public int project;
    public int projec;
    public int gast;
    public int IdReporte;
    public int reportL;
    private int reportId;
    public Date fecIn;
    public Date fecFin;
    private long totalExpense;
    private long totalExpenseReport;
    private long acomulador;
    private long valor1;
    private long valor;
    public String NameProyec;
    private long valor1M;
    private long valorM;

    //Parametros para el reporte de Gastos Pdf
    private Integer idReport;
    public String nameProyect;

    public Integer getIdReport() {
        return idReport;
    }

    public void setIdReport(Integer idReport) {
        this.idReport = idReport;
    }

    public String getNameProyect() {
        return nameProyect;
    }

    public void setNameProyect(String nameProyect) {
        this.nameProyect = nameProyect;
    }

//    private InputText totalGastoBean;
    private ItgProjectsAll proyectos;

    private ItgExpenseTypes gastos;
    //Cargar Gastos a proyecto
    private ItgExpenseReportsDetail gasto;
    //Tabla de gastos cargados
    private List<ItgExpenseReportsDetail> tableGastReport;
    private List<ItgExpenseReportsDetail> tableGastReportM;

    //Tabla Repotes
    private List<ItgExpenseReportsAll> tableReportE;

    private List<ItgExpenseReportsAll> gastEnca;
    //Tabla de reportes con status aprobado
    private List<ItgExpenseReportsAll> tableReportApro;

    public ReportExpensesBean() {
        obtenerReporte = new ItgExpenseReportsAll();
        reporte = new ItgExpenseReportsAll();
        gasto = new ItgExpenseReportsDetail();
        gastos = new ItgExpenseTypes();
        obtenerTiGast = new ItgExpenseReportsDetail();
        Status = new ItgExpenseReportsAll();
        statusP = new ItgExpenseReportsAll();
        comprobantes = new ItgExpenseReportsAll();
        obtenerGastR = new ItgExpenseReportsAll();
        acomulador = 0;

    }

    public int getRealizo() {
        return realizo;
    }

    public void setRealizo(int realizo) {
        this.realizo = realizo;
    }

    public ItgUsersAll getUsuario() {
        return usuario;
    }

    public ItgExpenseReportsAll getStatus() {
        return Status;
    }

    public int getGast() {
        return gast;
    }

    public void setGast(int gast) {
        this.gast = gast;
    }

    public void setStatus(ItgExpenseReportsAll Status) {
        this.Status = Status;
    }

    public ItgExpenseReportsAll getStatusP() {
        return statusP;
    }

    public void setStatusP(ItgExpenseReportsAll statusP) {
        this.statusP = statusP;
    }

    public String getNameProyec() {
        return NameProyec;
    }

    public void setNameProyec(String NameProyec) {
        this.NameProyec = NameProyec;
    }

    public ItgExpenseReportsAll getComprobantes() {
        return comprobantes;
    }

    public void setComprobantes(ItgExpenseReportsAll comprobantes) {
        this.comprobantes = comprobantes;
    }

    public void setUsuario(ItgUsersAll usuario) {
        this.usuario = usuario;
    }

    public int getProject() {
        return project;
    }

    public void setProject(int project) {
        this.project = project;
    }

    public int getProjec() {
        return projec;
    }

    public int getIdReporte() {
        return IdReporte;
    }

    public void setIdReporte(int IdReporte) {
        this.IdReporte = IdReporte;
    }

    public int getReportL() {
        return reportL;
    }

    public void setReportL(int reportL) {
        this.reportL = reportL;
    }

    public void setProjec(int projec) {
        this.projec = projec;
    }

    public ItgExpenseReportsAll getReporte() {
        return reporte;
    }

    public void setReporte(ItgExpenseReportsAll reporte) {
        this.reporte = reporte;
    }

    public int getTypeExpen() {
        return typeExpen;
    }

    public void setTypeExpen(int typeExpen) {
        this.typeExpen = typeExpen;
    }

    public ItgProjectsAll getProyectos() {
        return proyectos;
    }

    public void setProyectos(ItgProjectsAll proyectos) {
        this.proyectos = proyectos;
    }

    public ItgExpenseReportsAll getObtenerGastR() {
        return obtenerGastR;
    }

    public void setObtenerGastR(ItgExpenseReportsAll obtenerGastR) {
        this.obtenerGastR = obtenerGastR;
    }

    public long getAcomulador() {
        return acomulador;
    }

    public void setAcomulador(long acomulador) {
        this.acomulador = acomulador;
    }

    public long getValor1() {
        return valor1;
    }

    public void setValor1(long valor1) {
        this.valor1 = valor1;
    }

    public long getValor1M() {
        return valor1M;
    }

    public void setValor1M(long valor1M) {
        this.valor1M = valor1M;
    }

    public long getValorM() {
        return valorM;
    }

    public void setValorM(long valorM) {
        this.valorM = valorM;
    }

    public long getValor() {
        return valor;
    }

    public void setValor(long valor) {
        this.valor = valor;
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

    //Gastos a Proyectos
    public ItgExpenseReportsDetail getGasto() {
        return gasto;
    }

    public void setGasto(ItgExpenseReportsDetail gasto) {
        this.gasto = gasto;
    }

    public ItgExpenseTypes getGastos() {
        return gastos;
    }

    public void setGastos(ItgExpenseTypes gastos) {
        this.gastos = gastos;
    }

    public ItgExpenseReportsDetail getObtenerTiGast() {
        return obtenerTiGast;
    }

    public void setObtenerTiGast(ItgExpenseReportsDetail obtenerTiGast) {
        this.obtenerTiGast = obtenerTiGast;
    }

    public ItgExpenseReportsAll getObtenerReporte() {
        return obtenerReporte;
    }

    public void setObtenerReporte(ItgExpenseReportsAll obtenerReporte) {
        this.obtenerReporte = obtenerReporte;
    }

    public ItgExpenseReportsAll getDatos() {
        return datos;
    }

    public void setDatos(ItgExpenseReportsAll datos) {
        this.datos = datos;
    }

    public int getReportId() {

        return reportId;

    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public long getTotalExpense() {
        return totalExpense;
    }

    public void setTotalExpense(long totalExpense) {
        this.totalExpense = totalExpense;
    }

    public long getTotalExpenseReport() {
        return totalExpenseReport;
    }

    public void setTotalExpenseReport(long totalExpenseReport) {
        this.totalExpenseReport = totalExpenseReport;
    }

    public List<SelectItem> getListGastoRepor() {
        this.listGastoRepor = new ArrayList<SelectItem>();
        ReportExpensesDao RDao = new ReportExpensesImp();
        List<ItgExpenseTypes> c = RDao.listaTipoGast(this.project);
        listGastoRepor.clear();

        for (ItgExpenseTypes gast : c) {
            SelectItem projectItem = new SelectItem(gast.getSpendId(), gast.getSpendName());
            this.listGastoRepor.add(projectItem);

        }

        // System.err.println("Lista de gastos" + listGastoRepor.size());      
        if (listGastoRepor.size() <= 0) {
            List<ItgExpenseTypes> tipos = RDao.getGastoReport();
            for (ItgExpenseTypes gast : tipos) {
                SelectItem projectItem = new SelectItem(gast.getSpendId(), gast.getSpendName());
                this.listGastoRepor.add(projectItem);
            }
        }

        return listGastoRepor;
    }

    public List<ItgExpenseReportsDetail> getTableGastReport() {
        ReportExpensesDao CDao = new ReportExpensesImp();
        tableGastReport = CDao.tableGastReport(reporte);
        return tableGastReport;
    }

    public List<ItgExpenseReportsDetail> getTableGastReportM() {
        ReportExpensesDao CDao = new ReportExpensesImp();
        tableGastReportM = CDao.tableGastReportM(obtenerReporte);
        return tableGastReportM;
    }

    public List<ItgExpenseReportsAll> getGastEnca() {
        ReportExpensesDao CDao = new ReportExpensesImp();
        gastEnca = CDao.mostrarGastEncabe(reporte);
        return gastEnca;

    }

    public List<ItgExpenseReportsAll> getGastEncaM() {
        ReportExpensesDao CDao = new ReportExpensesImp();
        gastEnca = CDao.mostrarGastEncabe(obtenerReporte);
        return gastEnca;

    }

    public void nuevoGastReport() {
        acomulador = 0;
        if (reportId == 0) {

            ReportExpensesDao ADao = new ReportExpensesImp();
            ActivitiesDao Dao = new ActivitiesImp();

            List<ItgProjectsAll> pro = Dao.listarProyecto(realizo);
            List<ItgPersonalInfoAll> proye = Dao.listarEmpleados();

            for (ItgPersonalInfoAll proyec : proye) {
                if (proyec.getPersonalDataId() == realizo) {
                    reporte.setItgPersonalInfoAll(proyec);

                }
            }

            for (ItgProjectsAll proyecto : pro) {
                if (proyecto.getProjectId() == project) {
                    reporte.setItgProjectsAll(proyecto);

                }
            }
            for (ItgReportStatus sr : ADao.getStatus()) {
                if (sr.getStatusId().equals(1)) {
                    reporte.setItgReportStatus(sr);
                }

            }
            long valu = 0;
            //reporte.setTotalExpenseReport(gasto.getTotalExpense());
            reporte.setTotalExpenseReport(valu);
            ADao.nuevaReportEA(reporte);
            reportId = reporte.getReportId();
            //reporte = new XxeksReportsExpensesAll();

            //Lineas
            ReportExpensesDao REDao = new ReportExpensesImp();
            if (gasto.getExpenseDate().before(fecIn) || gasto.getExpenseDate().after(fecFin)) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR!!", "La fecha del gasto no coincide con la fecha de inicio y fin establecidas para este proyecto"));
            } else {
                for (ItgExpenseTypes gas : REDao.getGastos()) {
                    if (gas.getSpendId() == gasto.getItgExpenseTypes().getSpendId()) {
                        System.out.println("--totalGasto" + gas.getTotalMaximo());
                        if (gas.getTotalMaximo() == null) {

                            gasto.setItgExpenseReportsAll(reporte);

                            ADao.nuevoGastoReport(gasto);
                            //gasto = new XxeksExpenses();

                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Se agregó correctamente el registro"));
                            Long val = reporte.getTotalExpenseReport() + gasto.getTotalExpense();

                            reporte.setTotalExpenseReport(val);
                            ADao.modificarCReport(reporte.getReportId(), reporte.getTotalExpenseReport());

                        } else if (gasto.getTotalExpense() > gas.getTotalMaximo()) {

                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR!!", "El total del gasto no puede rebasar el límite establecido, intente con otra cantidad"));
                        } else {

                            gasto.setItgExpenseReportsAll(reporte);

                            ADao.nuevoGastoReport(gasto);

                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Se agregó correctamente el registro"));

                            Long val = reporte.getTotalExpenseReport() + gasto.getTotalExpense();

                            reporte.setTotalExpenseReport(val);
                            ADao.modificarCReport(reporte.getReportId(), reporte.getTotalExpenseReport());

                        }
                    }
                }
            }

            //  }
        } else {
            ReportExpensesDao ADao = new ReportExpensesImp();
            ReportExpensesDao REDao = new ReportExpensesImp();

            if (gasto.getExpenseDate().before(fecIn) || gasto.getExpenseDate().after(fecFin)) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR!!", "La fecha del gasto no coincide con la fecha de inicio y fin establecidas para este proyecto"));
            } else {
                for (ItgExpenseTypes gas : REDao.getGastos()) {
                    if (gas.getSpendId() == gasto.getItgExpenseTypes().getSpendId()) {
                        System.out.println("--totalGasto" + gas.getTotalMaximo());
                        if (gas.getTotalMaximo() == null) {
                            gasto.setItgExpenseReportsAll(reporte);

                            ADao.nuevoGastoReport(gasto);
                            //gasto = new XxeksExpenses();

                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Se agregó correctamente el registro"));
                            System.out.print("Linea" + gasto.getTotalExpense());
                            System.out.print("Report-----" + reporte.getReportId());
                            System.out.print("total-----" + reporte.getTotalExpenseReport());

                            Long val = reporte.getTotalExpenseReport() + gasto.getTotalExpense();

                            reporte.setTotalExpenseReport(val);
                            ADao.modificarCReport(reporte.getReportId(), reporte.getTotalExpenseReport());

                        } else if (gasto.getTotalExpense() > gas.getTotalMaximo()) {
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR!!", "El total del gasto no puede rebasar el límite establecido, intente con otra cantidad"));
                        } else {

                            for (ItgExpenseReportsDetail c : REDao.listaExpenses(reporte.getReportId(), gasto.getItgExpenseTypes().getSpendId())) {
                                acomulador = acomulador + c.getTotalExpense();
                            }
                            //acomulador = 145

                            long totalMaximo = 0;
                            for (ItgExpenseTypes c : REDao.listaTipoGast(project)) {
                                if (c.getSpendId() == gasto.getItgExpenseTypes().getSpendId()) {
                                    totalMaximo = c.getTotalMaximo();
                                }
                            }
                            System.out.println(gasto.getTotalExpense() + " Suma Total: " + acomulador);
                            acomulador += gasto.getTotalExpense();
                            System.out.println("---> " + acomulador);

                            System.out.println("Total Maximo: " + totalMaximo);

                            if (acomulador > totalMaximo) {
                                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Revisar", "Cantidad autorizada $" + totalMaximo + ", La cantidad ingresada ha Excedido el monto máximo permitido, intente con otra cantidad"));
                            } else {
                                //meter metodo para guardar linea
                                gasto.setItgExpenseReportsAll(reporte);
                                ADao.nuevoGastoReport(gasto);
                                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Se agregó correctamente el registro"));

                                Long val = reporte.getTotalExpenseReport() + gasto.getTotalExpense();
                                reporte.setTotalExpenseReport(val);
                                ADao.modificarCReport(reporte.getReportId(), reporte.getTotalExpenseReport());
                            }
                        }
                    }
                }
            }

        }
           System.out.println("fecha proyecto" + fecIn);
           System.out.println("fecha actividad" + fecFin );
    }

    public void nuevoGasM() {
        acomulador = 0;
        ReportExpensesDao ADao = new ReportExpensesImp();

        ReportExpensesDao REDao = new ReportExpensesImp();
        if (gasto.getExpenseDate().before(fecIn) || gasto.getExpenseDate().after(fecFin)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR!!", "La fecha del gasto no coincide con la fecha de inicio y fin establecidas para este proyecto"));
        } else {
            for (ItgExpenseTypes gas : REDao.getGastos()) {
                if (gas.getSpendId() == gasto.getItgExpenseTypes().getSpendId()) {
                    System.out.println("--totalGasto" + gas.getTotalMaximo());
                    if (gas.getTotalMaximo() == null) {
                        gasto.setItgExpenseReportsAll(obtenerReporte);

                        ADao.nuevoGastoReport(gasto);
                        //gasto = new XxeksExpenses();

                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Se agregó correctamente el registro"));
                        System.out.print("Linea" + gasto.getTotalExpense());
                        System.out.print("Report-----" + obtenerReporte.getReportId());
                        System.out.print("total-----" + obtenerReporte.getTotalExpenseReport());

                        Long val = obtenerReporte.getTotalExpenseReport() + gasto.getTotalExpense();

                        obtenerReporte.setTotalExpenseReport(val);
                        ADao.modificarCReport(obtenerReporte.getReportId(), obtenerReporte.getTotalExpenseReport());

                    } else if (gasto.getTotalExpense() > gas.getTotalMaximo()) {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR!!", "El total del gasto no puede rebasar el límite establecido, intente con otra cantidad"));
                    } else {

                        for (ItgExpenseReportsDetail c : REDao.listaExpenses(obtenerReporte.getReportId(), gasto.getItgExpenseTypes().getSpendId())) {
                            acomulador = acomulador + c.getTotalExpense();
                        }
                        //acomulador = 145

                        long totalMaximo = 0;
                        for (ItgExpenseTypes c : REDao.listaTipoGastM(projec)) {
                            if (c.getSpendId() == gasto.getItgExpenseTypes().getSpendId()) {
                                totalMaximo = c.getTotalMaximo();
                            }
                        }
                        System.out.println(gasto.getTotalExpense() + " Suma Total: " + acomulador);
                        acomulador += gasto.getTotalExpense();
                        System.out.println("---> " + acomulador);

                        System.out.println("Total Maximo: " + totalMaximo);

                        if (acomulador > totalMaximo) {
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Revisar", "Cantidad autorizada $" + totalMaximo + ", La cantidad ingresada ha Excedido el monto máximo permitido, intente con otra cantidad"));
                        } else {
                            //meter metodo para guardar linea
                            gasto.setItgExpenseReportsAll(obtenerReporte);
                            ADao.nuevoGastoReport(gasto);
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Se agregó correctamente el registro"));

                            Long val = obtenerReporte.getTotalExpenseReport() + gasto.getTotalExpense();
                            obtenerReporte.setTotalExpenseReport(val);
                            ADao.modificarCReport(obtenerReporte.getReportId(), obtenerReporte.getTotalExpenseReport());
                        }
                    }
                }
            }
        }

    }

    public void modificarGasto() {
        acomulador = 0;
        Long vale1 = null;
        ReportExpensesDao Dao = new ReportExpensesImp();
        ReportExpensesDao REDao = new ReportExpensesImp();
        if (obtenerTiGast.getExpenseDate().before(fecIn) || obtenerTiGast.getExpenseDate().after(fecFin)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR!!", "La fecha del gasto no coincide con la fecha de inicio y fin establecidas para este proyecto"));

        } else {
            for (ItgExpenseTypes gas : REDao.getGastos()) {
                if (gas.getSpendId() == obtenerTiGast.getItgExpenseTypes().getSpendId()) {
                    System.out.println("TotalGasto: " + gas.getTotalMaximo());
                    if (gas.getTotalMaximo() == null && obtenerTiGast.getTotalExpense() != valor1) {

                        Dao.modificarGastoReport(obtenerTiGast);
                        obtenerTiGast = new ItgExpenseReportsDetail();
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Se modificó correctamente"));
                        System.out.print("Valor nuevo es:  " + valor);
                        System.out.print("Valor viejo es:  " + valor1);

                        Long valR1 = reporte.getTotalExpenseReport() - valor1 + valor;

                        reporte.setTotalExpenseReport(valR1);

                        Dao.modificarCReport(reporte.getReportId(), reporte.getTotalExpenseReport());

                    } else if (obtenerTiGast.getTotalExpense() > gas.getTotalMaximo()) {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR!!", "El total del gasto no puede rebasar el límite establecido, intente con otra cantidad"));
                    } else {
                        for (ItgExpenseReportsDetail c : REDao.listaExpenses(reporte.getReportId(), obtenerTiGast.getItgExpenseTypes().getSpendId())) {
                            acomulador = acomulador + c.getTotalExpense();
                            vale1 = acomulador + valor - valor1;

                        }

                        long totalMaximo = 0;
                        for (ItgExpenseTypes c : REDao.listaTipoGast(project)) {
                            if (c.getSpendId() == obtenerTiGast.getItgExpenseTypes().getSpendId()) {
                                totalMaximo = c.getTotalMaximo();
                            }
                        }

                        System.out.println(obtenerTiGast.getTotalExpense() + "Suma Total:" + vale1);

                        System.out.println("Total Maximo: " + totalMaximo);
                        System.out.println("MetodModi " + acomulador);
                        if (vale1 > totalMaximo) {
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Revisar", "Cantidad autorizada $" + totalMaximo + ",  La cantidad ingresada ha Excedido el monto máximo permitido, intente con otra cantidad"));

                        } else {

                            Dao.modificarGastoReport(obtenerTiGast);
                            obtenerTiGast = new ItgExpenseReportsDetail();
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Se modificó correctamente"));
                            Long valR1 = reporte.getTotalExpenseReport() - valor1 + valor;
                            reporte.setTotalExpenseReport(valR1);

                            Dao.modificarCReport(reporte.getReportId(), reporte.getTotalExpenseReport());

                        }
                    }

                }
            }
        }

        //  HtmlInputText inputTextGP = (HtmlInputText)FacesContext.getCurrentInstance().getViewRoot().findComponent("contact_form:acumulado");
        //inputTextGP.setValue(reporte.getTotalExpenseReport());
        //FacesContext.getCurrentInstance().renderResponse();
    }

    public void modificarGastoM() {
        Long vale1 = null;
        ReportExpensesDao Dao = new ReportExpensesImp();
        ReportExpensesDao REDao = new ReportExpensesImp();
        if (obtenerTiGast.getExpenseDate().before(fecIn) || obtenerTiGast.getExpenseDate().after(fecFin)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR!!", "La fecha del gasto no coincide con la fecha de inicio y fin establecidas para este proyecto"));

        } else {
            for (ItgExpenseTypes gas : REDao.getGastos()) {
                if (gas.getSpendId() == obtenerTiGast.getItgExpenseTypes().getSpendId()) {
                    System.out.println("TotalGasto: " + gas.getTotalMaximo());
                    if (gas.getTotalMaximo() == null) {

                        Dao.modificarGastoReport(obtenerTiGast);
                        obtenerTiGast = new ItgExpenseReportsDetail();
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Se modificó correctamente"));
                        Long valR1 = obtenerReporte.getTotalExpenseReport() - valor1M + valorM;
                        obtenerReporte.setTotalExpenseReport(valR1);

                        Dao.modificarCReport(obtenerReporte.getReportId(), obtenerReporte.getTotalExpenseReport());

                    } else if (obtenerTiGast.getTotalExpense() > gas.getTotalMaximo()) {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR!!", "El total del gasto no puede rebasar el límite establecido, intente con otra cantidad"));
                    } else {
                        for (ItgExpenseReportsDetail c : REDao.listaExpenses(obtenerReporte.getReportId(), obtenerTiGast.getItgExpenseTypes().getSpendId())) {

                            //acomulador = acomulador + c.getTotalExpense() -c.getTotalExpense();
                            acomulador = acomulador + c.getTotalExpense();
                            vale1 = acomulador + valorM - valor1M;

                        }

                        long totalMaximo = 0;
                        for (ItgExpenseTypes c : REDao.listaTipoGastM(projec)) {
                            if (c.getSpendId() == obtenerTiGast.getItgExpenseTypes().getSpendId()) {
                                totalMaximo = c.getTotalMaximo();

                            }
                        }

                        System.out.println(obtenerTiGast.getTotalExpense() + "Suma Total:" + vale1);

                        System.out.println("Total Maximo: " + totalMaximo);
                        acomulador += obtenerTiGast.getTotalExpense() - valor1M;
                        System.out.println("MetodModi " + acomulador);
                        if (vale1 > totalMaximo) {
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Revisar", "Cantidad autorizada $" + totalMaximo + ",  La cantidad ingresada ha Excedido el monto máximo permitido, intente con otra cantidad"));

                        } else {
                            Dao.modificarGastoReport(obtenerTiGast);
                            obtenerTiGast = new ItgExpenseReportsDetail();
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Se modificó correctamente"));
                            Long valR1 = obtenerReporte.getTotalExpenseReport() - valor1M + valorM;
                            obtenerReporte.setTotalExpenseReport(valR1);
                            Dao.modificarCReport(obtenerReporte.getReportId(), obtenerReporte.getTotalExpenseReport());
                        }
                    }

                }
            }
        }

    }

    public void eliminarGasto() {
        ReportExpensesDao Dao = new ReportExpensesImp();
        Dao.eliminarGastoReport(obtenerTiGast);
        //obtenerTiGast = new XxeksExpenses();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Se elimino correctamente"));

        Long val = reporte.getTotalExpenseReport() - obtenerTiGast.getTotalExpense();
        reporte.setTotalExpenseReport(val);
        Dao.modificarCReport(reporte.getReportId(), reporte.getTotalExpenseReport());

    }

    public void eliminarGastoM() {
        ReportExpensesDao Dao = new ReportExpensesImp();
        Dao.eliminarGastoReport(obtenerTiGast);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Se elimino correctamente"));
        Long val = obtenerReporte.getTotalExpenseReport() - obtenerTiGast.getTotalExpense();
        obtenerReporte.setTotalExpenseReport(val);
        Dao.modificarCReport(obtenerReporte.getReportId(), obtenerReporte.getTotalExpenseReport());

    }

    public void eliminarReporteL() {
        ReportExpensesDao Dao = new ReportExpensesImp();
        System.out.print("Riport" + obtenerReporte.getReportId());
        for (ItgExpenseReportsDetail r : Dao.getGastosEmail(reportL)) {
            if (r.getItgExpenseReportsAll().getReportId() == reportL) {
                Dao.eliminarGastoReport(r);
            }
        }
        Dao.eliminarReportL(obtenerReporte);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Se elimino correctamente"));

    }

    public void actualizarGasto() {
        ReportExpensesDao Dao = new ReportExpensesImp();
        Dao.eliminarGastoReport(obtenerTiGast);
        obtenerTiGast = new ItgExpenseReportsDetail();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Se elimino correctamente"));
    }

    public void valueChangeMethod(ValueChangeEvent totalExpense) {
        ReportExpensesDao Dao = new ReportExpensesImp();

        valor = Long.parseLong(totalExpense.getNewValue().toString());
        valor1 = Long.parseLong(totalExpense.getOldValue().toString());

        for (ItgExpenseTypes gas : Dao.getGastos()) {
            if (gas.getSpendId() == obtenerTiGast.getItgExpenseTypes().getSpendId()) {
                System.out.print("Total Maximo: " + gas.getTotalMaximo());
                if (gas.getTotalMaximo() == null && getTotalExpense() != valor1) {

                    System.out.print("Valor viejo es:  " + valor1);

                } else if (valor > gas.getTotalMaximo()) {
                    System.out.print("No se modifica el gasto");

                }

            }

        }

    }

    public void valueChange(ValueChangeEvent totalExpense) {
        acomulador = 0;
        ReportExpensesDao Dao = new ReportExpensesImp();
        System.out.print("Total: " + obtenerReporte.getTotalExpenseReport());

        valorM = Long.parseLong(totalExpense.getNewValue().toString());
        valor1M = Long.parseLong(totalExpense.getOldValue().toString());

        for (ItgExpenseTypes gas : Dao.getGastos()) {
            if (gas.getSpendId() == obtenerTiGast.getItgExpenseTypes().getSpendId()) {
                System.out.print("Total Maximo: " + gas.getTotalMaximo());
                if (gas.getTotalMaximo() == null && getTotalExpense() != valor1M) {

                    System.out.print("Valor nuevo es:  " + valorM);
                    System.out.print("Valor viejo es:  " + valor1M);

                } else if (valorM > gas.getTotalMaximo()) {
                    System.out.print("No se modifica el gasto");

                }

            }

        }
    }

    public void sendMail() {

        ReportExpensesDao Dao = new ReportExpensesImp();
        if (reporte.getReportId() == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "El reporte no tiene gastos agregados"));

        } else {
            MailClient client = new MailClient();

            String NameProyect = "";

            try {
                NameProyect = reporte.getItgProjectsAll().getProjectName();
            } catch (NullPointerException e) {
                NameProyect = "-";
            }

            String Message = "<html>" + "<table class=\"egt\">" + "<tr align=\"left\">"
                    + "<th colspan=\"4\"><h3><font color='000101'>Nuevo Reporte de Gastos Número " + reporte.getReportId() + " para Aprobación" + "</font></h3></th>"
                    + "</tr>" + "<td><br/></td>" + "<td><br/></td>"
                    + "<td><br/></td>" + "<td><br/></td>" + "</tr>" + "<tr>"
                    + "<td><h4>Realizó:</h4></td>"
                    + "<td><h4><font color='000000'>" + reporte.getItgPersonalInfoAll().getName() + " " + reporte.getItgPersonalInfoAll().getPaternSurname() + " " + reporte.getItgPersonalInfoAll().getMaternSurname()
                    + "</font></h4></td>" + "<br></br>"
                    + "<td></td>"
                    + "<td><h4> Fecha del Reporte: </h4></td>"
                    + "<td><h4><font color='000000'>" + reporte.getReportDate()
                    + "</font></h4></td>"
                    + "<td>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</td>"
                    + "<td></td>" + "</tr>" + "<tr>" + "<td><h4>Proyecto:</h4></td>"
                    + "<td><h4><font color='000000'>" + NameProyect
                    + "</font></h4></td>" + "<br></br>"
                    + "<td>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</td>"
                    + "<td><h4> Método de Pago: </h4></td>"
                    + "<td><h4><font color='000000'>" + reporte.getPaymentMethod() + "</font></h4></td>"
                    + "<td>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</td>"
                    + "<td></td>" + "</tr>" + "<tr>" + "<td><h4>Motivo del gasto:</h4></td>"
                    + "<td><h4><font color='000000'>" + reporte.getReasonExpense()
                    + "</font></h4></td>" + "<br></br>"
                    + "<td></td>"
                    + "<td><h4>Total de Gastos $:</h4></td>"
                    + "<td><h4><font color='000000'>" + reporte.getTotalExpenseReport()
                    + "</font></h4></td>"
                    + "<td></td>" + "<tr>" + "</font></h4></td>" + "<td></td>"
                    + "<td></td>" + "</tr>" + "</tr>" + "</table>" + "<br></br>"
                    + //Lineas
                    "<html>" + "<table  width=\"100%\" class=\"egt\">"
                    + "<tr align=\"center\">"
                    + "<th width=\"25%\"><h3>Tipo de Gasto</h3></th>"
                    + "<th width=\"25%\"><h3>Descripción</h3></th>"
                    + "<th width=\"25%\"><h3>Fecha</h3></th>"
                    + "<th width=\"25%\"><h3>Total del Gasto $</h3></th>"
                    + "</tr>"
                    + "</table>";

            String lineas = "";

            for (ItgExpenseReportsDetail a : Dao.getGastosEmail(reporte.getReportId())) {
                String linea = "<html>" + "<table width=\"100%\" class=\"egt\">"
                        + "<tr align=\"center\" >"
                        + "<td width=\"25%\"><h4>" + a.getItgExpenseTypes().getSpendName() + "</h4></td>"
                        + "<td width=\"25%\"><h4>" + a.getDescription() + "</h4></td>"
                        + "<td width=\"25%\"><h4>" + a.getExpenseDate() + "</h4></td>"
                        + "<td width=\"25%\"><h4>" + a.getTotalExpense() + "</h4></td>"
                        + "</tr>" + "</table>";

                lineas = lineas + linea;
            }
            Message = Message + lineas;

            String correo = "";

            if (reporte.getItgProjectsAll() != null) {
                for (ItgProjectsAll p : Dao.getProyec()) {
                    if (reporte.getItgProjectsAll().getProjectId() == p.getProjectId()) {
                        if (p.getItgPersonalApprover() == null) {
                            for (ItgUsersAll f : Dao.getCorrreo(reporte.getItgPersonalInfoAll().getPersonalDataId())) {
                                if (f.getItgPersonalInfoAll().getPersonalDataId() == reporte.getItgPersonalInfoAll().getPersonalDataId()) {
                                    System.out.print("Pertenece al área" + f.getItgWorkArea().getNameArea());
                                    if (f.getItgUserRolesAll().getUserRoleName().equals("Director") && reporte.getTotalExpenseReport() >= 50000) {
                                        System.out.print("Este usuario " + f.getUserId());
                                        for (ItgUsersAll h : Dao.getUsers()) {
                                            if (h.getItgUserRolesAll().getUserRoleId() == 22) {
                                                correo = h.getItgPersonalInfoAll().getMail1();
                                                reporte.setItgPersonalApprover(h.getItgPersonalInfoAll());
                                                Dao.asignarApproverReport(reporte.getReportId(), reporte.getItgPersonalApprover().getPersonalDataId());

                                                for (ItgReportStatus s : Dao.getStatus()) {
                                                    if (s.getStatusId().equals(2)) {
                                                        reporte.setItgReportStatus(s);
                                                        Dao.modificarStatusRepor(reporte.getReportId(), reporte.getItgReportStatus().getStatusId());

                                                        reporte.setNameReport(Boolean.TRUE);
                                                        Dao.modificarBoton(reporte.getReportId(), reporte.getNameReport());

                                                    }
                                                }
                                            }
                                        }

                                    } else if (f.getItgUserRolesAll().getUserRoleName().equals("Director")) {
                                        correo = f.getItgPersonalInfoAll().getMail1();
                                        reporte.setItgPersonalApprover(f.getItgPersonalInfoAll());
                                        Dao.asignarApproverReport(reporte.getReportId(), reporte.getItgPersonalApprover().getPersonalDataId());

                                        for (ItgReportStatus s : Dao.getStatus()) {
                                            if (s.getStatusId().equals(3)) {
                                                reporte.setItgReportStatus(s);
                                                Dao.modificarStatusRepor(reporte.getReportId(), reporte.getItgReportStatus().getStatusId());

                                                reporte.setNameReport(Boolean.TRUE);
                                                Dao.modificarBoton(reporte.getReportId(), reporte.getNameReport());

                                            }
                                        }

                                    } else {

                                        for (ItgUsersAll d : Dao.getDirector(f.getItgWorkArea().getAreaId())) {
                                            if (d.getItgUserRolesAll().getUserRoleName().equals("Director")) {
                                                System.out.print("Director" + d.getItgPersonalInfoAll().getPersonalDataId());
                                                correo = d.getItgPersonalInfoAll().getMail1();
                                                reporte.setItgPersonalApprover(d.getItgPersonalInfoAll());
                                                Dao.asignarApproverReport(reporte.getReportId(), reporte.getItgPersonalApprover().getPersonalDataId());
                                                for (ItgReportStatus s : Dao.getStatus()) {
                                                    if (s.getStatusId().equals(2)) {
                                                        reporte.setItgReportStatus(s);
                                                        Dao.modificarStatusRepor(reporte.getReportId(), reporte.getItgReportStatus().getStatusId());

                                                        reporte.setNameReport(Boolean.TRUE);
                                                        Dao.modificarBoton(reporte.getReportId(), reporte.getNameReport());

                                                    }
                                                }

                                            }
                                        }
                                    }

                                }

                            }

                        } else {
                            for (ItgPersonalInfoAll a : Dao.getAprobador()) {
                                if (p.getItgPersonalApprover().getPersonalDataId() == a.getPersonalDataId()) {
                                    System.out.print("Aprobador es:" + a.getPersonalDataId());
                                    reporte.setItgPersonalApprover(a);
                                    Dao.asignarApproverReport(reporte.getReportId(), reporte.getItgPersonalApprover().getPersonalDataId());
                                    correo = a.getMail1();
                                    for (ItgReportStatus s : Dao.getStatus()) {
                                        if (s.getStatusId().equals(2)) {
                                            reporte.setItgReportStatus(s);
                                            Dao.modificarStatusRepor(reporte.getReportId(), reporte.getItgReportStatus().getStatusId());

                                            reporte.setNameReport(Boolean.TRUE);
                                            Dao.modificarBoton(reporte.getReportId(), reporte.getNameReport());

                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                for (ItgUsersAll f : Dao.getCorrreo(reporte.getItgPersonalInfoAll().getPersonalDataId())) {
                    if (f.getItgPersonalInfoAll().getPersonalDataId() == reporte.getItgPersonalInfoAll().getPersonalDataId()) {
                        System.out.print("Pertenece al área" + f.getItgWorkArea().getNameArea());
                        if (f.getItgUserRolesAll().getUserRoleName().equals("Director") && reporte.getTotalExpenseReport() >= 50000) {
                            System.out.print("Este usuario " + f.getUserId());
                            for (ItgUsersAll h : Dao.getUsers()) {
                                if (h.getItgUserRolesAll().getUserRoleId() == 22) {
                                    correo = h.getItgPersonalInfoAll().getMail1();
                                    reporte.setItgPersonalApprover(h.getItgPersonalInfoAll());
                                    Dao.asignarApproverReport(reporte.getReportId(), reporte.getItgPersonalApprover().getPersonalDataId());

                                    for (ItgReportStatus s : Dao.getStatus()) {
                                        if (s.getStatusId().equals(2)) {
                                            reporte.setItgReportStatus(s);
                                            Dao.modificarStatusRepor(reporte.getReportId(), reporte.getItgReportStatus().getStatusId());

                                            reporte.setNameReport(Boolean.TRUE);
                                            Dao.modificarBoton(reporte.getReportId(), reporte.getNameReport());

                                        }
                                    }
                                }
                            }

                        } else if (f.getItgUserRolesAll().getUserRoleName().equals("Director")) {
                            correo = f.getItgPersonalInfoAll().getMail1();
                            reporte.setItgPersonalApprover(f.getItgPersonalInfoAll());
                            Dao.asignarApproverReport(reporte.getReportId(), reporte.getItgPersonalApprover().getPersonalDataId());

                            for (ItgReportStatus s : Dao.getStatus()) {
                                if (s.getStatusId().equals(3)) {
                                    reporte.setItgReportStatus(s);
                                    Dao.modificarStatusRepor(reporte.getReportId(), reporte.getItgReportStatus().getStatusId());

                                    reporte.setNameReport(Boolean.TRUE);
                                    Dao.modificarBoton(reporte.getReportId(), reporte.getNameReport());

                                }
                            }

                        } else {

                            for (ItgUsersAll d : Dao.getDirector(f.getItgWorkArea().getAreaId())) {
                                if (d.getItgUserRolesAll().getUserRoleName().equals("Director")) {
                                    System.out.print("Director" + d.getItgPersonalInfoAll().getPersonalDataId());
                                    correo = d.getItgPersonalInfoAll().getMail1();
                                    reporte.setItgPersonalApprover(d.getItgPersonalInfoAll());
                                    Dao.asignarApproverReport(reporte.getReportId(), reporte.getItgPersonalApprover().getPersonalDataId());

                                    for (ItgReportStatus s : Dao.getStatus()) {
                                        if (s.getStatusId().equals(2)) {
                                            reporte.setItgReportStatus(s);
                                            Dao.modificarStatusRepor(reporte.getReportId(), reporte.getItgReportStatus().getStatusId());

                                            reporte.setNameReport(Boolean.TRUE);
                                            Dao.modificarBoton(reporte.getReportId(), reporte.getNameReport());

                                        }
                                    }
                                }
                            }
                        }

                    }

                }
            }
            client.sendMail(Message, correo, "iT-Global-Informe de Reporte de Gastos");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Tu reporte de gastos ha sido enviado, por favor presiona el botón de Salir"));

            reporte.setAttribute5(Boolean.TRUE);
            Dao.modificarBotonEl(reporte.getReportId(), reporte.getAttribute5());

            for (ItgVouchersStatus sv : Dao.getStatusVoucher()) {
                if (sv.getVoucherId().equals(2)) {
                    reporte.setItgVouchersStatus(sv);
                    Dao.modifcarStatusVouchers(reporte.getReportId(), reporte.getItgVouchersStatus().getVoucherId());

                }

            }

        }
    }
   
    
    
    public void sendMailM() {

        ReportExpensesDao Dao = new ReportExpensesImp();
        if (obtenerReporte.getReportId() == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "El reporte no tiene gastos agregados"));

        } else {
            MailClient client = new MailClient();
            String NameProyect = "";

            try {
                NameProyect = obtenerReporte.getItgProjectsAll().getProjectName();
            } catch (NullPointerException e) {
                NameProyect = "-";
            }

            String Message = "<html>" + "<table class=\"egt\">" + "<tr align=\"left\">"
                    + "<th colspan=\"4\"><h3><font color='000101'>Nuevo Reporte de Gastos Número " + obtenerReporte.getReportId() + " para Aprobación" + "</font></h3></th>"
                    + "</tr>" + "<td><br/></td>" + "<td><br/></td>"
                    + "<td><br/></td>" + "<td><br/></td>" + "</tr>" + "<tr>"
                    + "<td><h4>Realizó:</h4></td>"
                    + "<td><h4><font color='000000'>" + obtenerReporte.getItgPersonalInfoAll().getName() + " " + obtenerReporte.getItgPersonalInfoAll().getPaternSurname() + " " + obtenerReporte.getItgPersonalInfoAll().getMaternSurname()
                    + "</font></h4></td>" + "<br></br>"
                    + "<td></td>"
                    + "<td><h4> Fecha del Reporte: </h4></td>"
                    + "<td><h4><font color='000000'>" + obtenerReporte.getReportDate()
                    + "</font></h4></td>"
                    + "<td>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</td>"
                    + "<td></td>" + "</tr>" + "<tr>" + "<td><h4>Proyecto:</h4></td>"
                    + "<td><h4><font color='000000'>" + NameProyect
                    + "</font></h4></td>" + "<br></br>"
                    + "<td>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</td>"
                    + "<td><h4> Método de Pago: </h4></td>"
                    + "<td><h4><font color='000000'>" + obtenerReporte.getPaymentMethod() + "</font></h4></td>"
                    + "<td>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</td>"
                    + "<td></td>" + "</tr>" + "<tr>" + "<td><h4>Motivo del gasto:</h4></td>"
                    + "<td><h4><font color='000000'>" + obtenerReporte.getReasonExpense()
                    + "</font></h4></td>" + "<br></br>"
                    + "<td></td>"
                    + "<td><h4>Total de Gastos $:</h4></td>"
                    + "<td><h4><font color='000000'>" + obtenerReporte.getTotalExpenseReport()
                    + "</font></h4></td>"
                    + "<td></td>" + "<tr>" + "</font></h4></td>" + "<td></td>"
                    + "<td></td>" + "</tr>" + "</tr>" + "</table>" + "<br></br>"
                    + //Lineas
                    "<html>" + "<table  width=\"100%\" class=\"egt\">"
                    + "<tr align=\"center\">"
                    + "<th width=\"25%\"><h3>Tipo de Gasto</h3></th>"
                    + "<th width=\"25%\"><h3>Descripción</h3></th>"
                    + "<th width=\"25%\"><h3>Fecha</h3></th>"
                    + "<th width=\"25%\"><h3>Total del Gasto $</h3></th>"
                    + "</tr>"
                    + "</table>";

            String lineas = "";

            for (ItgExpenseReportsDetail a : Dao.getGastosEmail(obtenerReporte.getReportId())) {
                String linea = "<html>" + "<table width=\"100%\" class=\"egt\">"
                        + "<tr align=\"center\" >"
                        + "<td width=\"25%\"><h4>" + a.getItgExpenseTypes().getSpendName() + "</h4></td>"
                        + "<td width=\"25%\"><h4>" + a.getDescription() + "</h4></td>"
                        + "<td width=\"25%\"><h4>" + a.getExpenseDate() + "</h4></td>"
                        + "<td width=\"25%\"><h4>" + a.getTotalExpense() + "</h4></td>"
                        + "</tr>" + "</table>";

                lineas = lineas + linea;
            }
            Message = Message + lineas;

            String correo = "";
            if (obtenerReporte.getItgProjectsAll() != null) {
                for (ItgProjectsAll p : Dao.getProyec()) {
                    if (obtenerReporte.getItgProjectsAll().getProjectId() == p.getProjectId()) {
                        if (p.getItgPersonalApprover() == null) {
                            for (ItgUsersAll f : Dao.getCorrreo(obtenerReporte.getItgPersonalInfoAll().getPersonalDataId())) {
                                if (f.getItgPersonalInfoAll().getPersonalDataId() == obtenerReporte.getItgPersonalInfoAll().getPersonalDataId()) {
                                    System.out.print("Pertenece al área" + f.getItgWorkArea().getNameArea());
                                    if (f.getItgUserRolesAll().getUserRoleName().equals("Director") && obtenerReporte.getTotalExpenseReport() >= 50000) {
                                        System.out.print("Este usuario " + f.getUserId());
                                        for (ItgUsersAll h : Dao.getUsers()) {
                                            if (h.getItgUserRolesAll().getUserRoleId() == 22) {
                                                correo = h.getItgPersonalInfoAll().getMail1();
                                                obtenerReporte.setItgPersonalApprover(h.getItgPersonalInfoAll());
                                                Dao.asignarApproverReport(obtenerReporte.getReportId(), obtenerReporte.getItgPersonalApprover().getPersonalDataId());

                                                for (ItgReportStatus s : Dao.getStatus()) {
                                                    if (s.getStatusId().equals(2)) {
                                                        obtenerReporte.setItgReportStatus(s);
                                                        Dao.modificarStatusRepor(obtenerReporte.getReportId(), obtenerReporte.getItgReportStatus().getStatusId());

                                                        obtenerReporte.setNameReport(Boolean.TRUE);
                                                        Dao.modificarBoton(obtenerReporte.getReportId(), obtenerReporte.getNameReport());

                                                    }
                                                }
                                            }
                                        }

                                    } else if (f.getItgUserRolesAll().getUserRoleName().equals("Director")) {
                                        correo = f.getItgPersonalInfoAll().getMail1();
                                        obtenerReporte.setItgPersonalApprover(f.getItgPersonalInfoAll());
                                        Dao.asignarApproverReport(obtenerReporte.getReportId(), obtenerReporte.getItgPersonalApprover().getPersonalDataId());

                                        for (ItgReportStatus s : Dao.getStatus()) {
                                            if (s.getStatusId().equals(3)) {
                                                obtenerReporte.setItgReportStatus(s);
                                                Dao.modificarStatusRepor(obtenerReporte.getReportId(), obtenerReporte.getItgReportStatus().getStatusId());

                                                obtenerReporte.setNameReport(Boolean.TRUE);
                                                Dao.modificarBoton(obtenerReporte.getReportId(), obtenerReporte.getNameReport());

                                            }
                                        }

                                    } else {

                                        for (ItgUsersAll d : Dao.getDirector(f.getItgWorkArea().getAreaId())) {
                                            if (d.getItgUserRolesAll().getUserRoleName().equals("Director")) {
                                                System.out.print("Director" + d.getItgPersonalInfoAll().getPersonalDataId());
                                                correo = d.getItgPersonalInfoAll().getMail1();
                                                obtenerReporte.setItgPersonalApprover(d.getItgPersonalInfoAll());
                                                Dao.asignarApproverReport(obtenerReporte.getReportId(), obtenerReporte.getItgPersonalApprover().getPersonalDataId());
                                                for (ItgReportStatus s : Dao.getStatus()) {
                                                    if (s.getStatusId().equals(2)) {
                                                        obtenerReporte.setItgReportStatus(s);
                                                        Dao.modificarStatusRepor(obtenerReporte.getReportId(), obtenerReporte.getItgReportStatus().getStatusId());

                                                        obtenerReporte.setNameReport(Boolean.TRUE);
                                                        Dao.modificarBoton(obtenerReporte.getReportId(), obtenerReporte.getNameReport());
                                                    }
                                                }
                                            }
                                        }
                                    }

                                }

                            }
                        } else {
                            for (ItgPersonalInfoAll a : Dao.getAprobador()) {
                                if (p.getItgPersonalApprover().getPersonalDataId() == a.getPersonalDataId()) {
                                    System.out.print("Aprobador es:" + a.getPersonalDataId());
                                    obtenerReporte.setItgPersonalApprover(a);
                                    Dao.asignarApproverReport(obtenerReporte.getReportId(), obtenerReporte.getItgPersonalApprover().getPersonalDataId());
                                    correo = a.getMail1();
                                    for (ItgReportStatus s : Dao.getStatus()) {
                                        if (s.getStatusId().equals(2)) {
                                            obtenerReporte.setItgReportStatus(s);
                                            Dao.modificarStatusRepor(obtenerReporte.getReportId(), obtenerReporte.getItgReportStatus().getStatusId());

                                            obtenerReporte.setNameReport(Boolean.TRUE);
                                            Dao.modificarBoton(obtenerReporte.getReportId(), obtenerReporte.getNameReport());
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                for (ItgUsersAll f : Dao.getCorrreo(obtenerReporte.getItgPersonalInfoAll().getPersonalDataId())) {
                    if (f.getItgPersonalInfoAll().getPersonalDataId() == obtenerReporte.getItgPersonalInfoAll().getPersonalDataId()) {
                        System.out.print("Pertenece al área" + f.getItgWorkArea().getNameArea());
                        if (f.getItgUserRolesAll().getUserRoleName().equals("Director") && obtenerReporte.getTotalExpenseReport() >= 50000) {
                            System.out.print("Este usuario " + f.getUserId());
                            for (ItgUsersAll h : Dao.getUsers()) {
                                if (h.getItgUserRolesAll().getUserRoleId() == 22) {
                                    correo = h.getItgPersonalInfoAll().getMail1();
                                    obtenerReporte.setItgPersonalApprover(h.getItgPersonalInfoAll());
                                    Dao.asignarApproverReport(obtenerReporte.getReportId(), obtenerReporte.getItgPersonalApprover().getPersonalDataId());

                                    for (ItgReportStatus s : Dao.getStatus()) {
                                        if (s.getStatusId().equals(2)) {
                                            obtenerReporte.setItgReportStatus(s);
                                            Dao.modificarStatusRepor(obtenerReporte.getReportId(), obtenerReporte.getItgReportStatus().getStatusId());

                                            obtenerReporte.setNameReport(Boolean.TRUE);
                                            Dao.modificarBoton(obtenerReporte.getReportId(), obtenerReporte.getNameReport());

                                        }
                                    }
                                }
                            }

                        } else if (f.getItgUserRolesAll().getUserRoleName().equals("Director")) {
                            correo = f.getItgPersonalInfoAll().getMail1();
                            obtenerReporte.setItgPersonalApprover(f.getItgPersonalInfoAll());
                            Dao.asignarApproverReport(obtenerReporte.getReportId(), obtenerReporte.getItgPersonalApprover().getPersonalDataId());

                            for (ItgReportStatus s : Dao.getStatus()) {
                                if (s.getStatusId().equals(3)) {
                                    obtenerReporte.setItgReportStatus(s);
                                    Dao.modificarStatusRepor(obtenerReporte.getReportId(), obtenerReporte.getItgReportStatus().getStatusId());

                                    obtenerReporte.setNameReport(Boolean.TRUE);
                                    Dao.modificarBoton(obtenerReporte.getReportId(), obtenerReporte.getNameReport());

                                }
                            }

                        } else {

                            for (ItgUsersAll d : Dao.getDirector(f.getItgWorkArea().getAreaId())) {
                                if (d.getItgUserRolesAll().getUserRoleName().equals("Director")) {
                                    System.out.print("Director" + d.getItgPersonalInfoAll().getPersonalDataId());
                                    correo = d.getItgPersonalInfoAll().getMail1();
                                    obtenerReporte.setItgPersonalApprover(d.getItgPersonalInfoAll());
                                    Dao.asignarApproverReport(obtenerReporte.getReportId(), obtenerReporte.getItgPersonalApprover().getPersonalDataId());
                                    for (ItgReportStatus s : Dao.getStatus()) {
                                        if (s.getStatusId().equals(2)) {
                                            obtenerReporte.setItgReportStatus(s);
                                            Dao.modificarStatusRepor(obtenerReporte.getReportId(), obtenerReporte.getItgReportStatus().getStatusId());

                                            obtenerReporte.setNameReport(Boolean.TRUE);
                                            Dao.modificarBoton(obtenerReporte.getReportId(), obtenerReporte.getNameReport());
                                        }
                                    }

                                }
                            }
                        }

                    }

                }

            }
            client.sendMail(Message, correo, "iT-Global-Informe de Reporte de Gastos");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Tu reporte de gastos ha sido enviado, por favor presiona el botón de Salir"));

            obtenerReporte.setAttribute5(Boolean.TRUE);
            Dao.modificarBotonEl(obtenerReporte.getReportId(), obtenerReporte.getAttribute5());

            for (ItgVouchersStatus sv : Dao.getStatusVoucher()) {
                if (sv.getVoucherId().equals(2)) {
                    obtenerReporte.setItgVouchersStatus(sv);
                    Dao.modifcarStatusVouchers(obtenerReporte.getReportId(), obtenerReporte.getItgVouchersStatus().getVoucherId());

                }

            }

        }
    }

    public List<ItgExpenseReportsAll> getTableReportE() {
        ReportExpensesDao CDao = new ReportExpensesImp();
        tableReportE = CDao.listarTabReportE();
        return tableReportE;
    }

    public List<ItgExpenseReportsAll> getTableReportApro() {
        ReportExpensesDao CDao = new ReportExpensesImp();
        tableReportApro = CDao.listarTabReportS();
        return tableReportApro;
    }

    public List<SelectItem> getListStatusReport() {
        this.listStatusReport = new ArrayList<SelectItem>();
        ReportExpensesDao Dao = new ReportExpensesImp();
        List<ItgReportStatus> s = Dao.listaStatusReport();
        listStatusReport.clear();

        for (ItgReportStatus status : s) {
            SelectItem projectItem = new SelectItem(status.getStatusId(), status.getStatusName());
            this.listStatusReport.add(projectItem);

        }

        return listStatusReport;
    }

    public List<SelectItem> getListStatusReportP() {
        this.listStatusReportP = new ArrayList<SelectItem>();
        ReportExpensesDao Dao = new ReportExpensesImp();
        List<ItgReportStatus> s = Dao.listaStatusReportP();
        listStatusReportP.clear();

        for (ItgReportStatus status : s) {
            SelectItem projectItem = new SelectItem(status.getStatusId(), status.getStatusName());
            this.listStatusReportP.add(projectItem);

        }

        return listStatusReportP;
    }

    public List<SelectItem> getListStatusReportVo() {
        this.listStatusReportVo = new ArrayList<SelectItem>();
        ReportExpensesDao Dao = new ReportExpensesImp();
        List<ItgVouchersStatus> v = Dao.listaStatusReportVo();
        listStatusReportVo.clear();

        for (ItgVouchersStatus stav : v) {
            SelectItem projectItem = new SelectItem(stav.getVoucherId(), stav.getNameStatus());
            this.listStatusReportVo.add(projectItem);
        }
        return listStatusReportVo;
    }

    public void modificarStatus() {
        ReportExpensesDao Dao = new ReportExpensesImp();
        Dao.modificarStatus(Status);
        //Status = new XxeksReportsExpensesAll();
        System.out.print("Id modificado es" + Status.getReportId());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Se modificó correctamente"));

        MailClient client = new MailClient();

        String Message = "El Status del Reporte Número " + Status.getReportId() + " que enviaste para aprobación ha sido modificado por el Director.";
        String correo = "";
        for (ItgPersonalInfoAll d : Dao.getEmpleM(Status.getItgPersonalInfoAll().getPersonalDataId())) {
            if (d.getPersonalDataId() == Status.getItgPersonalInfoAll().getPersonalDataId()) {
                correo = d.getMail1();

            }
        }

        client.sendMail(Message, correo, "iT-Global-Informe de Reporte de Gastos");
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Se ha informado al empleado que su Status se ha modificado"));
    }

    public void modificarStatusP() {
        ReportExpensesDao Dao = new ReportExpensesImp();
        Dao.modificarStatus(statusP);
        //statusP = new XxeksReportsExpensesAll();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Se modificó correctamente"));

        MailClient client = new MailClient();

        String Message = "El Status del Reporte Número " + statusP.getReportId() + " ha sido modificado por el Contador.";
        String correo = "";
        for (ItgPersonalInfoAll d : Dao.getEmpleM(statusP.getItgPersonalInfoAll().getPersonalDataId())) {
            if (d.getPersonalDataId() == statusP.getItgPersonalInfoAll().getPersonalDataId()) {
                correo = d.getMail1();

            }
        }

        client.sendMail(Message, correo, "iT-Global-Informe de Reporte de Gastos");
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Se ha informado al empleado que su Status se ha modificado"));
    }

    public void modificarComprobantes() {
        ReportExpensesDao Dao = new ReportExpensesImp();
        Dao.modificarStatus(comprobantes);
        comprobantes = new ItgExpenseReportsAll();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Se modificó correctamente"));
    }

    public void verid() {
        IdReporte = obtenerReporte.getReportId();
        System.out.print("Id hyes" + IdReporte);
        ReportExpensesDao Dao = new ReportExpensesImp();
        
        if (obtenerReporte.getItgProjectsAll() == null) {
            projec = 0;
            System.out.print("Proyecto es x: " + obtenerReporte.getItgProjectsAll());
        } else {
            projec = obtenerReporte.getItgProjectsAll().getProjectId();
            System.out.print("Proyecto es 1: " + projec);

        }

        for (ItgProjectsAll d : Dao.getProyec()) {
            if (projec == d.getProjectId()) {
                fecIn = d.getProjectStartDate();
                fecFin = d.getProjectEndDate();
                System.out.print("Fecha inicio " + fecIn);
                System.out.print("Fecha Fin " + fecFin);

            }
            if (fecFin == null) {
                fecFin = new java.sql.Date(2050, 12, 12);
                System.out.print("Nueva fecha fin " + fecFin);

            }

        }

        try {
            NameProyec = obtenerReporte.getItgProjectsAll().getProjectName();
        } catch (NullPointerException e) {
            NameProyec = "-";
        }

        
    }

    public void ver3() {
        reportL = obtenerReporte.getReportId();
        System.out.print("Id hyes" + reportL);
    }

    public void verid1() {
        gast = obtenerTiGast.getItgExpenseTypes().getSpendId();
        System.out.print("Tipo de Gasto es" + gast);

    }

    public List<SelectItem> getListGastoReporM() {
        this.listGastoReporM = new ArrayList<SelectItem>();
        ReportExpensesDao RDao = new ReportExpensesImp();
        List<ItgExpenseTypes> c = RDao.listaTipoGastM(projec);
        listGastoReporM.clear();

        for (ItgExpenseTypes gast : c) {
            SelectItem projectItem = new SelectItem(gast.getSpendId(), gast.getSpendName());
            this.listGastoReporM.add(projectItem);

        }

        if (listGastoReporM.size() <= 0) {
            List<ItgExpenseTypes> tipos = RDao.getGastoReport();
            for (ItgExpenseTypes gast : tipos) {
                SelectItem projectItem = new SelectItem(gast.getSpendId(), gast.getSpendName());
                this.listGastoReporM.add(projectItem);
            }
        }

        return listGastoReporM;
    }

    public void valueChangeDisa(ValueChangeEvent status) {
        Integer valu = null;
        ReportExpensesDao Dao = new ReportExpensesImp();
        valu = Integer.parseInt(status.getNewValue().toString());
        System.out.print("nuevo valoro:" + valu);
        System.out.print("Id re:" + Status.getReportId());

        if (valu.equals(3)) {
            Status.setNameReport(Boolean.TRUE);
            Dao.modificarBoton(Status.getReportId(), Status.getNameReport());

        } else if (valu.equals(5)) {
            Status.setNameReport(Boolean.TRUE);
            Dao.modificarBoton(Status.getReportId(), Status.getNameReport());

        } else if (valu.equals(6)) {
            Status.setNameReport(Boolean.FALSE);
            Dao.modificarBoton(Status.getReportId(), Status.getNameReport());
        } else if (valu.equals(2)) {
            Status.setNameReport(Boolean.TRUE);
            Dao.modificarBoton(Status.getReportId(), Status.getNameReport());
        }

    }

    public void valuChange(ValueChangeEvent status) {
        Integer valo = null;
        ReportExpensesDao Dao = new ReportExpensesImp();
        valo = Integer.parseInt(status.getNewValue().toString());
        System.out.print("nuevo valor:" + valo);

        if (valo.equals(4)) {
            statusP.setAttribute4(Boolean.TRUE);
            Dao.modificarBotonD(statusP.getReportId(), statusP.getAttribute4());
        } else if (valo.equals(7)) {
            statusP.setAttribute4(Boolean.TRUE);
            Dao.modificarBotonD(statusP.getReportId(), statusP.getAttribute4());
        } else if (valo.equals(3)) {
            statusP.setAttribute4(Boolean.FALSE);
            Dao.modificarBotonD(statusP.getReportId(), statusP.getAttribute4());

        }
    }

    public void generarReporte() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        idReport = obtenerReporte.getReportId();
        System.out.print("Id Reporte PDF" + idReport);

        try {
            nameProyect = obtenerReporte.getItgProjectsAll().getProjectName();
        } catch (NullPointerException e) {
            nameProyect = "-";
            System.out.print(nameProyect);
        }

        ReporteExpensesBean rGastos = new ReporteExpensesBean();

        FacesContext facesContext = FacesContext.getCurrentInstance();
        ServletContext servletContext = (ServletContext) facesContext.getExternalContext().getContext();
        String ruta = servletContext.getRealPath("/Reportes/ReporteGastos.jasper");
        String path = servletContext.getRealPath("/Reportes/Img/logo.png");
        String pie = servletContext.getRealPath("/Reportes/Img/tel2.png");
        String oracle = servletContext.getRealPath("/Reportes/Img/oracle.png");

        rGastos.getReporteExpensesBean(ruta, this.idReport, this.nameProyect, path, pie, oracle);
        FacesContext.getCurrentInstance().responseComplete();

    }

    public void valuProy(ValueChangeEvent proyecto) {
        ReportExpensesDao Dao = new ReportExpensesImp();
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
            if (fecFin == null) {
                fecFin = new java.sql.Date(2050, 12, 12);
                System.out.print("Nueva fecha fin " + fecFin);

            }

        }

    }
    
    
    
}
