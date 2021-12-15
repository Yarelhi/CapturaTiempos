/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;
import Model.ItgExpenseReportsAll;
import Model.ItgExpenseReportsDetail;
import Model.ItgPersonalInfoAll;
import Model.ItgProjectsAll;
import Model.ItgReportStatus;
import Model.ItgVouchersStatus;
import Model.ItgExpenseTypes;
import Model.ItgUsersAll;
import java.util.List;


public interface ReportExpensesDao {
    //Registrar encabezado del reporte
    public List<ItgExpenseReportsAll> mostrarReportEA();
   
    public void nuevaReportEA(ItgExpenseReportsAll itgExpenseReportsAll);
    //Mostrar el Gasto total del encabezado del reporte
    public List<ItgExpenseReportsAll>mostrarGastEncabe(ItgExpenseReportsAll reporte);
    
    //Modificar encabezado Reporte
    public void modificarEncabe(ItgExpenseReportsAll itgExpenseReportsAll);
    
    //Modidficar campo de Gasto del reporte
    public void modificarCReport(int id, long totalReport);
    //Modificar Status Reporte y estatus de los vouchers del reporte
    public void modificarStatusRepor(int idRepor, int idStatus);
    public void modifcarStatusVouchers(int idRepor, int idVoucher);
    //Asignar el aprobador al reporte al enviar por correo
    public void asignarApproverReport(int idRepor, int idApro);
    //Deshabilitar el Boton modificar de la tabla reportes 
    public void modificarBoton(int idRepor, boolean boton);
    //Deshabilitar Boton de modificar para el director
    public void modificarBotonD(int idRepor, boolean boton);
    //Deshabilitar Boton de eliminar reportes
    public void modificarBotonEl(int idRepor, boolean boton);
    
    // Nuevo Gasto del reporte
    
    public List <ItgExpenseReportsDetail> mostarGastosReport();
    public void nuevoGastoReport(ItgExpenseReportsDetail itgExpenseReportsDetail);
    public List<ItgExpenseReportsDetail> obtenerGastLine();
    //Lista de Status del Reporte
    public List<ItgReportStatus>listaStatusReport();
    //Lista de Status del Reporte para pagar
    public List<ItgReportStatus>listaStatusReportP();
    //Lista de statusVouchers del reporte
    public List<ItgVouchersStatus>listaStatusReportVo();
    
    //Lista de Tipos de gastos 
    public List<ItgExpenseTypes>listaTipoGast(int project);
    public List<ItgExpenseTypes>listaTipoGastM(int projec);
    public List<ItgExpenseTypes>getGastoReport();
    public List<ItgExpenseTypes>getGastos();
    public void modificarGastoReport(ItgExpenseReportsDetail itgExpenseReportsDetail);
    public void eliminarGastoReport(ItgExpenseReportsDetail itgExpenseReportsDetail);
    public List<ItgExpenseReportsDetail>listaExpenses(int IdReporte, int tipoExpenses);
    
    //Listar la tabla de Gastos Agregados
    public List<ItgExpenseReportsDetail>tableGastReport(ItgExpenseReportsAll reporte);
    public List<ItgExpenseReportsDetail>tableGastReportM(ItgExpenseReportsAll obtenerReporte);
    public List<ItgExpenseReportsDetail>getGastosEmail(int IdReporte);
    public void eliminarReportL(ItgExpenseReportsAll itgExpenseReportsAll);
    
    //Listar usuarios para enviar reporte por correo
    public List<ItgUsersAll>getCorrreo(int idPersonal);
    public List<ItgUsersAll>getUsers();
    public List<ItgUsersAll>getDirector(int area);
    public List<ItgProjectsAll>getProyec();
    public List<ItgPersonalInfoAll>getAprobador();
    
    //Tabla de Reportes creados
    public List<ItgExpenseReportsAll>listarTabReport(ItgUsersAll usuario);
    //Tabla para el aprobador de reportes
    public List<ItgExpenseReportsAll>listarTabAproRe(ItgUsersAll usuario);
    public List<ItgExpenseReportsAll>listarTabReportE();
    //Tabla de reportes con status aprobado
    public List<ItgExpenseReportsAll>listarTabReportS();
    
    public List<ItgReportStatus>getStatus();
    public List<ItgVouchersStatus>getStatusVoucher();
    
    //Modificar Status del reporte
    public void modificarStatus(ItgExpenseReportsAll itgExpenseReportsAll);
    //Enviar Correo cuando se cambia el estatus del reporte
    public List<ItgPersonalInfoAll>getEmpleM(int idEmpleado);
    
    
}
