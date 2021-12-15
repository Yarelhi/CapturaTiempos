/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Imp;

import Dao.CompanyDao;
import Model.ItgCompany;
import Util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 *
 * @author ITG
 */
public class OrganizacionImp implements CompanyDao {
    
    @Override
    public List<ItgCompany> mostrarEmpresa() {
        List<ItgCompany> listarClientes = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM ItgCompany";

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
    public void nuevaEmpresa(ItgCompany itgCompany) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(itgCompany);
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
    public void modificarEmpresa(ItgCompany itgCompany) {
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

    @Override
    public void eliminarEmpresa(ItgCompany itgCompany) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(itgCompany);
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
    public List<ItgCompany> listarTable() {
        List<ItgCompany> listaTable = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM ItgCompany WHERE ITG_EMPLOYEES_CUSTOMERS_ALL_EMPLOYEE_CUSTOMER_ID=1";

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
    public List<ItgCompany> listarTableEmp() {
        List<ItgCompany> listarTableEmp = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM ItgCompany";

        try {
            listarTableEmp = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return listarTableEmp;
    }
    
    @Override
    public List<ItgCompany> listarEmpresas() {
        List<ItgCompany> listarEmpresas = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM ItgCompany";

        try {
            listarEmpresas = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return listarEmpresas;
    }
    
    
}


    


