/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Imp;

import Dao.ActivitiesDao;
import Model.ItgActivitiesAll;
import Model.ItgActivitiesDetail;
import Model.ItgCompany;
import Model.ItgPersonalInfoAll;
import Model.ItgProjectsAll;
import Util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author DLVC
 */
public class ActivitiesImp implements ActivitiesDao {

    @Override
    public List<ItgActivitiesAll> mostrarActividades() {
        List<ItgActivitiesAll> listarActividades = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM ItgActivitiesAll";

        try {
            listarActividades = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return listarActividades;
    }

    @Override
    public void nuevaActividad(ItgActivitiesAll itgActivitiesAll) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(itgActivitiesAll);
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
    public List<ItgPersonalInfoAll> listarEmpleados() {
        List<ItgPersonalInfoAll> listarEmpleados = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM ItgPersonalInfoAll WHERE ITG_EMPLOYEES_CUSTOMERS_ALL_EMPLOYEE_CUSTOMER_ID = 2 OR\n" + "ITG_EMPLOYEES_CUSTOMERS_ALL_EMPLOYEE_CUSTOMER_ID = 4 OR ITG_EMPLOYEES_CUSTOMERS_ALL_EMPLOYEE_CUSTOMER_ID = 5";

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
    
    @Override
    public List<ItgActivitiesAll> listarEmpleadoss() {
        List<ItgActivitiesAll> listarEmpleadoss = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM ItgActivitiesAll";

        try {
            listarEmpleadoss = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return listarEmpleadoss;
    }



    @Override
    public List<ItgPersonalInfoAll> mostrarEmp() {
        List<ItgPersonalInfoAll> listarEmp = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM ItgPersonalInfoAll";

        try {
            listarEmp = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return listarEmp;
    }

    @Override
    public void nuevoEmp(ItgPersonalInfoAll itgPersonalInfoAll) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(itgPersonalInfoAll);
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
    public List<ItgPersonalInfoAll> listarClient() {
        List<ItgPersonalInfoAll> listarCliente = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM ItgPersonalInfoAll WHERE ITG_EMPLOYEES_CUSTOMERS_ALL_EMPLOYEE_CUSTOMER_ID = 1";

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
    public List<ItgProjectsAll> listarProy(int cliente) {
        List<ItgProjectsAll> listarProyecto = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM ItgProjectsAll WHERE PARTY_ID = "+ cliente;

        try {
            listarProyecto = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return listarProyecto;
    }
    
     @Override
    public void nuevoReporte(ItgActivitiesDetail itgActivitiesDetail) {
       Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(itgActivitiesDetail);
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
    public List<ItgProjectsAll> listarProyecto(int realizo) {
        List<ItgProjectsAll> ListarActividades = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        //String hql = "FROM XxeksActivities  WHERE XXEKS_PERSONAL_DATA_ALL_PERSONAL_DATA_ID = "+ realizo;
        //String hql = "FROM xxeks_projects_all AS p, xxeks_activities AS a WHERE p.PROJECT_ID = a.XXEKS_PROJECTS_ALL_PROJECT_ID AND a.XXEKS_PERSONAL_DATA_ALL_PERSONAL_DATA_ID ="+ realizo;
        String hql = "FROM ItgProjectsAll AS p WHERE p.projectId IN ( SELECT a.itgProjectsAll FROM ItgActivitiesAll AS a WHERE a.itgPersonalInfoAll IN ("+realizo+"))";
        try {
            ListarActividades = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return ListarActividades;
    }

    @Override
    public List<ItgActivitiesAll> listarConsultor() {
        List<ItgActivitiesAll> listarConsultor= null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "select itgPersonalInfoAll from ItgActivitiesAll";

        try {
            listarConsultor = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return listarConsultor;

}

    @Override
    public List<ItgActivitiesDetail> listarTable(ItgActivitiesAll actividades) {
        List<ItgActivitiesDetail> listaTable = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        
        String  hql = "FROM ItgActivitiesDetail WHERE ITG_ACTIVITIES_ALL_ACTIVITY_ID = "+ actividades.getActivityId();
        try {
            listaTable = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return listaTable;
    }

    @Override
    public List<ItgActivitiesAll> listarTableActivities(ItgActivitiesAll asignacion) {
        List<ItgActivitiesAll> listaTableActivities = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        
        String  hql = "FROM ItgActivitiesAll ORDER BY ItgPersonalInfoAll ";
        try {
            listaTableActivities = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return listaTableActivities;
    }
    
    @Override
    public void modificarHoras(ItgActivitiesDetail itgActivitiesDetail) {
        Session session = null;
        try {
            session =HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(itgActivitiesDetail);
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
    public void modificarActividades(ItgActivitiesAll itgActivitiesAll) {
        Session session = null;
        try {
            session =HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(itgActivitiesAll);
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
    public List<ItgActivitiesAll> listarActividades(int project, String mes, int realizo) {
        List<ItgActivitiesAll> ListarActividades = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM ItgActivitiesAll  WHERE ITG_PROJECTS_ALL_PROJECT_ID IN ("+ project +") AND month  = '"+ mes +"' AND ITG_PERSONAL_INFO_ALL_PERSONAL_DATA_ID = '"+realizo+"'";

        try {
            ListarActividades = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return ListarActividades;
    }
     @Override
    public void eliminarHoras(ItgActivitiesDetail itgActivitiesDetail) {
        Session session = null;
        try {
            session =HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(itgActivitiesDetail);
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
    public List<ItgProjectsAll> getProyec() {
        List<ItgProjectsAll> listaActividades = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM ItgProjectsAll";
        try {
            listaActividades = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return listaActividades;

    }
  

}


