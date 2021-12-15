/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.ItgCitiesAll;
import Model.ItgCompany;
import Model.ItgCountriesAll;
import Model.ItgEmployeesTypesAll;
import Model.ItgParties;
import Model.ItgStatesAll;
import Model.ItgListValuesDet;
import java.util.List;

/**
 *
 * @author DLVC
 */
public interface ClienteDao {
    //Registrar Customers - Clientes
    public List<ItgParties> mostrarClientes();
    public void nuevoClientes(ItgParties itgParties);
    //Modificar Clientes - Customers
    public void modificarCliente(ItgParties itgParties);
    //Eliminar
    public void eliminarCliente(ItgParties itgParties);
    //Lista Paises
    public List<ItgCountriesAll> listarPaises();    
    //Lista Estados
    public List<ItgStatesAll> listarEstados(ItgParties clientes);
    //Lista Ciudades
    public List<ItgCitiesAll> listarCiudades(ItgParties clientes);
    //Lista Clientes - Empleados
    public List<ItgEmployeesTypesAll> listarEmpCus();
    public List<ItgEmployeesTypesAll> listarEmpCusEmp();
    //Registrar Cities - Ciudades
    public List<ItgCitiesAll>mostrarCiudades();
    public void nuevaCiudad(ItgCitiesAll itgCitiesAll);
    //Lista de Valores
    public List<ItgListValuesDet> listaValor();
    //Listar Datatable
    public List<ItgParties> listarTable();
    //Listar Datatable
    public List<ItgParties> listarTableEmp();
  
}
