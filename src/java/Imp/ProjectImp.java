/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Imp;

import Dao.ProjectDao;
import Model.ItgPersonalInfoAll;
import Model.ItgParties;
import Model.ItgProjectsAll;
import Model.ItgExpenseTypes;
import Model.ItgUsersAll;
import Util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author DLVC
 */
public class ProjectImp implements ProjectDao {

    @Override
    public List<ItgProjectsAll> mostrarProjects() {
        List<ItgProjectsAll> listarClientes = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM ItgProjectsAll";

        try {
            listarClientes = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return listarClientes;
    }

    @Override
    public void nuevoProyecto(ItgProjectsAll itgProjectsAll) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(itgProjectsAll);
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
    public List<ItgParties> listarClientes() {
        List<ItgParties> listarCliente = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM ItgParties  ";

        try {
            listarCliente = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return listarCliente;
    }
    
    @Override
    public void modificarProyecto(ItgProjectsAll itgProjectsAll) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(itgProjectsAll);
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
    public void eliminarProyecto(ItgProjectsAll itgProjectsAll) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(itgProjectsAll);
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
    public List<ItgUsersAll> listarEmpleados(int area, int rol) {
        List<ItgUsersAll> listarEmpleados = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        
        String hql = "FROM ItgUsersAll WHERE ITG_WORK_AREA_AREA_ID = "+area+" AND ITG_USER_ROLES_ALL_USER_ROLE_ID = "+rol+" ";
        try {
            listarEmpleados = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return listarEmpleados;
    }
    
    
    //Gastos a Proyectos 
    
    

    @Override
    public void nuevoGastoP(ItgExpenseTypes itgExpenseTypes) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(itgExpenseTypes);
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
    public List<ItgExpenseTypes> listarTableGP(ItgProjectsAll proyectos){
        List<ItgExpenseTypes> listaTableGP = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        
        String  hql = "FROM ItgExpenseTypes WHERE ITG_PROJECTS_ALL_PROJECT_ID = "+ proyectos.getProjectId();
        try {
            listaTableGP = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return listaTableGP;
    }

    @Override
    public void modificarGasto(ItgExpenseTypes itgExpenseTypes) {
        Session session = null; 
        try {
            session =HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(itgExpenseTypes);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        } finally {
            if(session != null){
                session.close();
            }
        }
        
    }

    @Override
    public void eliminarGasto(ItgExpenseTypes itgExpenseTypes) {
        Session session = null; 
        try {
            session =HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(itgExpenseTypes);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        } finally {
            if(session != null){
                session.close();
            }
        }

    }

    @Override
    public List<ItgPersonalInfoAll> listaEmple() {
        List<ItgPersonalInfoAll> listarEm = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM ItgPersonalInfoAll WHERE ITG_EMPLOYEES_CUSTOMERS_ALL_EMPLOYEE_CUSTOMER_ID = 2 ";

        try {
            listarEm = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return listarEm;
    }

    @Override
    public List<ItgUsersAll> listarUsers() {
        List<ItgUsersAll> listarUsers = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM ItgUsersAll";

        try {
            listarUsers = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return listarUsers;
    }

    @Override
    public void modificarAre(int idproyec, int are) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Query q;
        q = session.createQuery("update ItgProjectsAll set  ITG_WORK_AREA_AREA_ID=:are where PROJECT_ID=:idproyec");
        q.setParameter("are", are);
        q.setParameter("idproyec", idproyec);

        int status = q.executeUpdate();
        System.out.println(status);
        transaction.commit();
    }

    @Override
    public void modificarRole(int idproyec, int rol) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Query q;
        q = session.createQuery("update ItgProjectsAll set  ITG_USERS_ROLES_ALL_USER_ROLE_ID=:rol where PROJECT_ID=:idproyec");
        q.setParameter("rol", rol);
        q.setParameter("idproyec", idproyec);

        int status = q.executeUpdate();
        System.out.println(status);
        transaction.commit();
    }

    

}
