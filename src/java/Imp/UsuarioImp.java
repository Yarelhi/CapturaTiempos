/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Imp;

import Dao.UsuarioDao;
import Model.ItgCompany;
import Model.ItgUsersAll;
import Model.ItgUserRolesAll;
import Model.ItgWorkArea;
import Util.HibernateUtil;
import java.util.List;
import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author DLVC
 */
public class UsuarioImp implements UsuarioDao {


  
    @Override
    public List<ItgUsersAll> mostrarUsuarios() {
        List<ItgUsersAll> listarUsuarios = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "FROM ItgUsersAll";
        try {
            listarUsuarios = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return listarUsuarios;
    }

    @Override
    public void nuevoUsuario(ItgUsersAll itgUsersAll) {
        Session session = null;
        try {
            String encript = DigestUtils.sha512Hex(itgUsersAll.getPassword());
            itgUsersAll.setPassword(encript);
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(itgUsersAll);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    @Override
    public List<ItgWorkArea> listarAreas() {
        List<ItgWorkArea> listarArea = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM ItgWorkArea";

        try {
            listarArea = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return listarArea;
    }
    
    @Override
    public List<ItgUserRolesAll> listaRol(int area) {
        List<ItgUserRolesAll> listaRol = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM ItgUserRolesAll WHERE ITG_WORK_AREA_AREA_ID=" +area;
        
        try{
            listaRol = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
            transaction.rollback();
            
        }
        return listaRol;
       
    }
    
    @Override
    public List<ItgUserRolesAll> listarRoles(ItgUsersAll usuario) {
        List<ItgUserRolesAll> listarRol = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM ItgUserRolesAll WHERE ITG_WORK_AREA_AREA_ID='" + usuario.getItgWorkArea().getAreaId()+ "'";

        try {
            listarRol = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return listarRol;
    }
     @Override
    public void modificarUsuario(ItgUsersAll itgUsersAll) {
        Session session = null;
        try {
            String encript = DigestUtils.sha512Hex(itgUsersAll.getPassword());
            itgUsersAll.setPassword(encript);
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(itgUsersAll);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
     @Override
    public void modificarStatus(ItgUsersAll itgUsersAll) {
        Session session = null;
        try {
            
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(itgUsersAll);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    @Override
    public void modificarOrg(ItgCompany itgCompany) {
        Session session = null;
        try {
            
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(itgCompany);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    
}
