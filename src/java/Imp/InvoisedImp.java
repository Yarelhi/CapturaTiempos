/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Imp;

import Dao.InvoisedDao;
import Model.ItgInvoiceAll;
import Model.ItgPersonalInfoAll;
import Model.ItgProjectsAll;
import Util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;


/**
 *
 * @author Diana
 */
public class InvoisedImp implements InvoisedDao {

    @Override
    public List<ItgInvoiceAll> mostrarFacturas() {
        List<ItgInvoiceAll> listarFacturas = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM ItgInvoiceAll";

        try {
            listarFacturas = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return listarFacturas;
    }

    @Override
    public void nuevaFactura(ItgInvoiceAll ItgInvoiceAll) {
         Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(ItgInvoiceAll);
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

        String hql = "FROM ItgProjectsAll WHERE ITG_PERSONAL_INFO_ALL_PERSONAL_DATA_ID = "+ cliente;

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
    public List<ItgInvoiceAll> listarConsultor() {
       List<ItgInvoiceAll> listarConsultor= null;
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

    }
    

