/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Imp;

import Dao.UploadDao;
import Model.ItgProjectsAll;
import Util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Diana
 */
public class UploadImp implements UploadDao {

    @Override
    public List<ItgProjectsAll> listProjects(ItgProjectsAll proyectos) {
         List<ItgProjectsAll> listarProyec = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM ItgProjectsAll WHERE projectId= " + proyectos.getProjectId();

        try {
            listarProyec = session.createQuery(hql).list();
            transaction.commit();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return listarProyec;
    }

    @Override
    public List<ItgProjectsAll> listProyecto() {
        List<ItgProjectsAll> listarProyecto = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        
        String hql = "from ItgProjectsAll where attribute1 is not null";
        
        try {
            listarProyecto = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return listarProyecto;
    }
    @Override
    public List<ItgProjectsAll> listatributo2() {
        List<ItgProjectsAll> listarProyecto = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        
        String hql = "from ItgProjectsAll where attribute2 is not null";
        
        try {
            listarProyecto = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return listarProyecto;
    }
    @Override
    public List<ItgProjectsAll> listatributo5() {
        List<ItgProjectsAll> listarProyecto = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        
        String hql = "from ItgProjectsAll where attribute5 is not null";
        
        try {
            listarProyecto = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return listarProyecto;
    }
    @Override
    public List<ItgProjectsAll> proyectos() {
        List<ItgProjectsAll> listarProyecto = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        
        String hql = "from ItgProjectsAll";
        
        try {
            listarProyecto = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return listarProyecto;
    }
    
}
