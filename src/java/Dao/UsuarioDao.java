/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import Model.ItgCompany;
import Model.ItgPersonalInfoAll;
import Model.ItgStatesAll;
import Model.ItgUsersAll;
import Model.ItgWorkArea;
import Model.ItgUserRolesAll;
import java.util.List;

/**
 *
 * @author DLVC
 */
public interface UsuarioDao {
   
    //Registrar Usuarios
    public List<ItgUsersAll> mostrarUsuarios();
    public void nuevoUsuario(ItgUsersAll itgUsersAll);
    
    //Lista Áreas
    public List<ItgWorkArea> listarAreas();
    
    //Lista Roles
    public List<ItgUserRolesAll> listarRoles(ItgUsersAll usuario);
    public List<ItgUserRolesAll>listaRol(int area);
    
    
    public void modificarUsuario(ItgUsersAll itgUsersAll);
    public void modificarStatus(ItgUsersAll itgUsersAll);
    public void modificarOrg(ItgCompany itgCompany);
}
