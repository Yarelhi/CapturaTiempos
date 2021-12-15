/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Dao.ActivitiesDao;
import Dao.UploadDao;
import Imp.ActivitiesImp;
import Imp.UploadImp;
import Model.ItgActivitiesAll;
import Model.ItgActivitiesDetail;
import Model.ItgPersonalInfoAll;
import Model.ItgProjectsAll;
import Util.HibernateUtil;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.faces.application.FacesMessage;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Arrays.stream;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.swing.JOptionPane;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jdbc.ReturningWork;
import org.primefaces.model.UploadedFile;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;


/**
 *
 * @author Briseydy
 */
@ManagedBean
@SessionScoped

public class DowloadBeanplan {
    private StreamedContent filep;
    private StreamedContent filexml;

    private String project_name;
    
    private int project_id;

    
    
    //:)
     private int id;
    private int id_proyecto;
    private List<ItgProjectsAll> listar;
    private ItgProjectsAll proyectos;
    private List<SelectItem> listProyecto;

    public StreamedContent getFilep() {
        return filep;
    }

    public void setFilep(StreamedContent filep) {
        this.filep = filep;
    }

    
    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
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

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public StreamedContent getFilexml() {
        return filexml;
    }

    public void setFilexml(StreamedContent filexml) {
        this.filexml = filexml;
    }

   
   
    
     // Different ways to get the Connection object using Session
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        
        
        // Way2 - using doReturningWork method
        Connection connection = session.doReturningWork(new ReturningWork<Connection>() {
            @Override
            public Connection execute(Connection conn) throws SQLException {
                return conn;
            }
        });
    

   
              
 
//xml
public void downloadplan(){
    ResultSet rs;
        
    try{
        //Class.forName("com.mysql.jdbc.Driver");
        //Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/xxeks_module_times_db", "root", "");
        //PreparedStatement st = cn.prepareStatement("INSERT INTO xxeks_projects_all (attribute1) VALUES(?)");
        
        PreparedStatement st = connection.prepareStatement("SELECT ATTRIBUTE5 FROM itg_projects_all WHERE project_id = (?)");
        st.setInt(1,project_id );
           
           rs=st.executeQuery();
           while (rs.next()){
           InputStream stream = rs.getBinaryStream ("ATTRIBUTE5");
               
           filep = new DefaultStreamedContent(stream,"archivo/pdf", "descarga.pdf");
            }
          
           FacesMessage message = new FacesMessage ("Exito", "Fue descargado.");
            FacesContext.getCurrentInstance().addMessage(null, message); 
           
           } catch (Exception e){
        FacesMessage message = new FacesMessage ("Error de conexion");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
} 
//P?lan de trabajo

}

