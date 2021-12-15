/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import Model.ItgPersonalInfoAll;
import Model.ItgParties;
import Model.ItgProjectsAll;
import Model.ItgExpenseTypes;
import Model.ItgUsersAll;
import java.util.List;

/**
 *
 * @author DLVC
 */
public interface ProjectDao {
    //Registrar Projects - Proyectos
    public List<ItgProjectsAll> mostrarProjects();
    //Registrar Gastos A Proyecto
    //public List<XxeksTypeExpenses> mostrarGastos();
    
    public void nuevoProyecto(ItgProjectsAll itgProjectsAll);
    public void nuevoGastoP(ItgExpenseTypes itgExpenseTypes);
   
    //Listar la tabla de los tipos de gastos 
     public List<ItgExpenseTypes> listarTableGP(ItgProjectsAll proyectos);
     //Modificar Gastos de proyecto
     public void modificarGasto(ItgExpenseTypes itgExpenseTypes);
     //Eliminar Gastos de Proyecto
     public void eliminarGasto(ItgExpenseTypes itgExpenseTypes);
            
    //Modificar Projects - Proyectos
    public void modificarProyecto(ItgProjectsAll itgProjectsAll);
    //Eliminar
    public void eliminarProyecto(ItgProjectsAll itgProjectsAll);
    //Lista Clientes
    public List<ItgParties> listarClientes();

    //Lista empleados
    public List<ItgUsersAll> listarEmpleados(int area, int rol);
    public List<ItgUsersAll> listarUsers();
    public List<ItgPersonalInfoAll>listaEmple();
    
    //Modificar el area al aprovador del proyecto
    public void modificarAre(int idproyec, int are);
    ////Modificar el rol al aprovador del proyecto
    public void modificarRole(int idproyec, int rol);
}
