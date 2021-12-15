/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.ItgCitiesAll;
import Model.ItgCountriesAll;
import Model.ItgEmployeesTypesAll;
import Model.ItgPersonalInfoAll;
import Model.ItgStatesAll;
import Model.ItgListValuesDet;
import Model.ItgUserRolesAll;
import Model.ItgUsersAll;
import java.util.List;

/**
 *
 * @author DLVC
 */
public interface EmpleadoDao {
    //Registrar Customers - Clientes
    public List<ItgPersonalInfoAll> mostrarClientes();
    public void nuevoClientes(ItgPersonalInfoAll itgPersonalInfoAll);
    //Modificar Clientes - Customers
    public void modificarCliente(ItgPersonalInfoAll itgPersonalInfoAll);
    //Eliminar
    public void eliminarCliente(ItgPersonalInfoAll itgPersonalInfoAll);
    //Lista Paises
    public List<ItgCountriesAll> listarPaises();    
    //Lista Estados
    public List<ItgStatesAll> listarEstados(ItgPersonalInfoAll empleados);
    //Lista Ciudades
    public List<ItgCitiesAll> listarCiudades(ItgPersonalInfoAll empleados);
    //Lista Clientes - Empleados
    public List<ItgEmployeesTypesAll> listarEmpCus();
    public List<ItgEmployeesTypesAll> listarEmpCusEmp();
    //Registrar Cities - Ciudades
    public List<ItgCitiesAll>mostrarCiudades();
    public void nuevaCiudad(ItgCitiesAll itgCitiesAll);
    //Lista de Valores
    public List<ItgListValuesDet> listaValor();
    //Listar Datatable
    public List<ItgPersonalInfoAll> listarTable();
    //Listar Datatable
    public List<ItgPersonalInfoAll> listarTableEmp();
    //Listar Directores
    public List<ItgUsersAll> listarDirectores();
    //Lista Gerentes
    public List<ItgUsersAll> listarGerentes();
    //Lista Lider
    public List<ItgUsersAll> listarLider();
    
    
}
