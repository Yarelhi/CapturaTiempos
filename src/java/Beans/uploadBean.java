
package Beans;


import Dao.UploadDao;
import Imp.UploadImp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.UploadedFile;
import Model.ItgProjectsAll;
import Util.HibernateUtil;
import java.util.ArrayList;
import javax.faces.model.SelectItem;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Briseydy
 */
@ManagedBean
@SessionScoped


public class uploadBean {
    
    private int id;
    private UploadedFile file;
    private UploadedFile filex;
       private UploadedFile filep;
    private int id_proyecto;
    private List<ItgProjectsAll> listar;
    private ItgProjectsAll proyectos;
    private List<SelectItem> listProyecto;
    


    public void setId_proyecto(int id_proyecto) {
        this.id_proyecto = id_proyecto;
    }
    

    public uploadBean(){
        proyectos = new ItgProjectsAll();
    }
    
    public List<ItgProjectsAll> getListar() {
        UploadDao PDao = new UploadImp();
        listar = PDao.listProjects(proyectos);
        return listar;
    }
    
    public List<SelectItem> getListProyecto(){
        this.listProyecto = new ArrayList<SelectItem>();
        UploadDao pDao = new UploadImp();
        List<ItgProjectsAll> c = pDao.listProyecto();
        listProyecto.clear();
        
        for (ItgProjectsAll proyecto : c){
            SelectItem projectItem = new SelectItem(proyecto.getProjectId(), proyecto.getProjectName());
            this.listProyecto.add(projectItem);
            
        }
        return listProyecto;
    }
    public List<SelectItem> getProyecto(){
        this.listProyecto = new ArrayList<SelectItem>();
        UploadDao pDao = new UploadImp();
        List<ItgProjectsAll> c = pDao.proyectos();
        listProyecto.clear();
        
        for (ItgProjectsAll proyecto : c){
            SelectItem projectItem = new SelectItem(proyecto.getProjectId(), proyecto.getProjectName());
            this.listProyecto.add(projectItem);
            
        }
        return listProyecto;
    }
    
    public List<SelectItem> getListxml(){
        this.listProyecto = new ArrayList<SelectItem>();
        UploadDao pDao = new UploadImp();
        List<ItgProjectsAll> c = pDao.listatributo2();
        listProyecto.clear();
        
        for (ItgProjectsAll proyecto : c){
            SelectItem projectItem = new SelectItem(proyecto.getProjectId(), proyecto.getProjectName());
            this.listProyecto.add(projectItem);
            
        }
        return listProyecto;
    }
    public List<SelectItem> getListplan(){
        this.listProyecto = new ArrayList<SelectItem>();
        UploadDao pDao = new UploadImp();
        List<ItgProjectsAll> c = pDao.listatributo5();
        listProyecto.clear();
        
        for (ItgProjectsAll proyecto : c){
            SelectItem projectItem = new SelectItem(proyecto.getProjectId(), proyecto.getProjectName());
            this.listProyecto.add(projectItem);
            
        }
        return listProyecto;
    }

    public ItgProjectsAll getProyectos() {
        return proyectos;
    }

    public void setProyectos(ItgProjectsAll proyectos) {
        this.proyectos = proyectos;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    
    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public UploadedFile getFilex() {
        return filex;
    }

    public void setFilex(UploadedFile filex) {
        this.filex = filex;
    }

    public UploadedFile getFilep() {
        return filep;
    }

    public void setFilep(UploadedFile filep) {
        this.filep = filep;
    }
    
   
    //inicio de metodo Subir Factura en tipo PDF
    public void upload(){ 
      
        try {
            if (file != null){
            Session session = HibernateUtil.getSessionFactory().openSession();
            //consulta en hql(hibernate languaje query
            String hql = "UPDATE ItgProjectsAll SET attribute1 = ? WHERE projectId="+proyectos.getProjectId();
            Query q = session.createQuery(hql);
            q.setBinary(0,file.getContents());
            q.executeUpdate();
            session.close();       
            
            FacesMessage message = new FacesMessage ("exito", file.getFileName()+ " fue subido correctamente");
            FacesContext.getCurrentInstance().addMessage(null, message); 
        }     
    }
      catch (Exception e){ 
        FacesMessage message = new FacesMessage ("Error de conexion" + e.getMessage());
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    }
     // fin de metodo subir archivo PDF
        //inicio de subir factura tipo XML
    public void uploadxml(){ 
         try {
            if (filex != null){
            Session session = HibernateUtil.getSessionFactory().openSession();
            String hql = "UPDATE ItgProjectsAll SET attribute2 = ? WHERE projectId="+proyectos.getProjectId();
            Query q = session.createQuery(hql);
            q.setBinary(0,filex.getContents());
            q.executeUpdate();
            session.close();       
            
            FacesMessage message = new FacesMessage ("exito", filex.getFileName()+ " fue subido correctamente");
            FacesContext.getCurrentInstance().addMessage(null, message); 
        }     
    }
      catch (Exception e){ 
        FacesMessage message = new FacesMessage ("Error de conexion" + e.getMessage());
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
      
       
    }
    //fon de metodo para subir xml
    //plan de trabajo
     public void uploadPlan(){ 
         try {
            if (filep != null){
            Session session = HibernateUtil.getSessionFactory().openSession();
            String hql = "UPDATE ItgProjectsAll SET attribute5 = ? WHERE projectId="+proyectos.getProjectId();
            Query q = session.createQuery(hql);
            q.setBinary(0,filep.getContents());
            q.executeUpdate();
            session.close();       
            
            FacesMessage message = new FacesMessage ("exito", filep.getFileName()+ " fue subido correctamente");
            FacesContext.getCurrentInstance().addMessage(null, message); 
        }     
    }
      catch (Exception e){ 
        FacesMessage message = new FacesMessage ("Error de conexion" + e.getMessage());
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
      
       
    }
    
}
    
    
