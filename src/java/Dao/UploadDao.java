/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.ItgProjectsAll;
import java.util.List;

/**
 *
 * @author Diana
 */
public interface UploadDao {
    public List<ItgProjectsAll> listProjects(ItgProjectsAll proyectos);
    public List<ItgProjectsAll> listProyecto();
    public List<ItgProjectsAll> listatributo2();
    public List<ItgProjectsAll> listatributo5();
    public List<ItgProjectsAll> proyectos();
}
