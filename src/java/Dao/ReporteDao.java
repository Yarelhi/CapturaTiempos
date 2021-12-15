/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import Model.ItgActivitiesAll;
import Model.ItgPersonalInfoAll;
import Model.ItgProjectsAll;
import java.util.List;

/**
 *
 * @author ÁNGEL
 */
public interface ReporteDao {
    
    public List<ItgActivitiesAll> Actividades();
    public List<ItgActivitiesAll> Nombre();
    public List<ItgActivitiesAll> NombreList();
    //Listar Datatable
    public List<ItgActivitiesAll> listarTable();
    //Listar consultores parametro
    public List<ItgPersonalInfoAll> listarEmpleados();
    //Listar actividades parametro
    public List<ItgActivitiesAll> listarActividades(ItgPersonalInfoAll actividades);
    public List<ItgProjectsAll> listarProyecto(ItgPersonalInfoAll consultor);
    public List<ItgActivitiesAll> listarActividades(int project, String mes);
    
     //Reporte de clientes Física
    public List<ItgPersonalInfoAll> CustomerF();
    
    //Reporte de clienes Moral
    public List<ItgPersonalInfoAll> CustomerM();
}
