/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.ItgCompany;
import java.util.List;

/**
 *
 * @author ITG
 */
public interface CompanyDao {
    
    //Registrar Customers - Clientes
    public List<ItgCompany> mostrarEmpresa();
    public void nuevaEmpresa(ItgCompany itgCompany);
    //Modificar Clientes - Customers
    public void modificarEmpresa(ItgCompany itgCompany);
    //Eliminar
    public void eliminarEmpresa(ItgCompany itgCompany);
    //Listar Datatable
    public List<ItgCompany> listarTable();
    //Listar Datatable
    public List<ItgCompany> listarTableEmp();
     //Lista Empleados
    public List<ItgCompany> listarEmpresas();

}
