/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Imp;

import Dao.ReporteDao;
import Model.ItgActivitiesAll;
import Model.ItgPersonalInfoAll;
import Model.ItgProjectsAll;
import Util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 *
 * @author ÁNGEL
 */
public class ReporteImp implements ReporteDao {

    @Override
    public List<ItgActivitiesAll> Actividades() {
        List<ItgActivitiesAll> listarActividades = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "SELECT activityId FROM ItgActivitiesAll";
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
    public List<ItgActivitiesAll> Nombre() {
        List<ItgActivitiesAll> listarActividades = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "SELECT activityId FROM ItgActivitiesAll ORDER BY  activityId ASC";
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
    public List<ItgActivitiesAll> NombreList() {
        List<ItgActivitiesAll> listarNombre = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "SELECT elaboratedBy FROM ItgActivitiesAll";
        try {
            listarNombre = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return listarNombre;
    }

    @Override
    public List<ItgActivitiesAll> listarTable() {
       List<ItgActivitiesAll> listaTable = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM ItgActivitiesAll";

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
    public List<ItgActivitiesAll> listarActividades(ItgPersonalInfoAll actividades) {
        List<ItgActivitiesAll> listaActividades = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM ItgActivitiesAll WHERE ITG_PERSONAL_INFO_ALL_PERSONAL_DATA_ID = '" + actividades.getPersonalDataId() + "'";

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
 @Override
    public List<ItgProjectsAll> listarProyecto(ItgPersonalInfoAll consultor) {
        List<ItgProjectsAll> ListarActividades = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        //String hql = "FROM XxeksActivities  WHERE XXEKS_PERSONAL_DATA_ALL_PERSONAL_DATA_ID = "+ realizo;
        //String hql = "FROM xxeks_projects_all AS p, xxeks_activities AS a WHERE p.PROJECT_ID = a.XXEKS_PROJECTS_ALL_PROJECT_ID AND a.XXEKS_PERSONAL_DATA_ALL_PERSONAL_DATA_ID ="+ realizo;
        String hql = "FROM ItgProjectsAll AS p WHERE p.projectId IN ( SELECT a.itgProjectsAll FROM ItgActivities AS a WHERE a.itgPersonalInfoAll IN ("+consultor+"))";
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
    public List<ItgActivitiesAll> listarActividades(int project, String mes) {
        List<ItgActivitiesAll> ListarActividades = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM ItgActivitiesAll  WHERE ITG_PROJECTS_ALL_PROJECT_ID IN ("+ project +") AND month  = '"+ mes +"'";

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
    public List<ItgPersonalInfoAll> CustomerF() {
        List<ItgPersonalInfoAll> listarClientesF = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "SELECT name FROM ItgPersonalInfoAll WHERE ITG_EMPLOYEES_CUSTOMERS_ALL_EMPLOYEE_CUSTOMER_ID=1 and ATTRIBUTE1 = 'Fisica'";
        try {
            listarClientesF = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return listarClientesF;
    }
//Reporte de clientes Moral
    @Override
    public List<ItgPersonalInfoAll> CustomerM() {
        List<ItgPersonalInfoAll> listarClientesM = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "SELECT name FROM ItgPersonalInfoAll WHERE ITG_EMPLOYEES_CUSTOMERS_ALL_EMPLOYEE_CUSTOMER_ID=1 and ATTRIBUTE1 = 'Moral'";
        try {
            listarClientesM = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return listarClientesM;
    }
}
