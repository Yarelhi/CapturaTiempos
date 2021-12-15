/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Imp;

import Dao.ClienteDao;
import Model.ItgCitiesAll;
import Model.ItgCountriesAll;
import Model.ItgEmployeesTypesAll;
import Model.ItgParties;
import Model.ItgStatesAll;
import Model.ItgListValuesDet;
import Util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author DLVC
 */
public class CustomerImp implements ClienteDao {

    @Override
    public List<ItgParties> mostrarClientes() {
        List<ItgParties> listarClientes = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM ItgParties";

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
    public void nuevoClientes(ItgParties itgParties) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(itgParties);
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
    public List<ItgCountriesAll> listarPaises() {
        List<ItgCountriesAll> listaPaises = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM ItgCountriesAll";

        try {
            listaPaises = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return listaPaises;
    }

    @Override
    public List<ItgStatesAll> listarEstados(ItgParties clientes) {
        List<ItgStatesAll> listaEstados = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM ItgStatesAll WHERE ITG_COUNTRIES_ALL_COUNTRY_ID = '" + clientes.getItgCountriesAll().getCountryId() + "'";

        try {
            listaEstados = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return listaEstados;
    }

    @Override
    public List<ItgCitiesAll> listarCiudades(ItgParties clientes) {
        List<ItgCitiesAll> listaCiudades = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM ItgCitiesAll WHERE ITG_STATES_ALL_STATE_ID = '" + clientes.getItgStatesAll().getStateId() + "'";

        try {
            listaCiudades = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return listaCiudades;
    }

    @Override
    public List<ItgCitiesAll> mostrarCiudades() {
        List<ItgCitiesAll> listarCiudades = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM ItgCitiesAll";

        try {
            listarCiudades = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return listarCiudades;
    }

    @Override
    public void nuevaCiudad(ItgCitiesAll itgCitiesAll) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(itgCitiesAll);
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
    public List<ItgListValuesDet> listaValor() {
        List<ItgListValuesDet> listaV = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM ItgListValuesDet WHERE VALUE_LIST_DETAIL_ID < 3";

        try {
            listaV = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return listaV;
    }

    @Override
    public List<ItgEmployeesTypesAll>listarEmpCus() {
        List<ItgEmployeesTypesAll> listaEmpCust = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM ItgEmployeesTypesAll WHERE NAME = 'Cliente'";

        try {
            listaEmpCust = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return listaEmpCust;
    }

    @Override
    public List<ItgEmployeesTypesAll> listarEmpCusEmp() {
        List<ItgEmployeesTypesAll> listaEmpCust = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM ItgEmployeesTypesAll WHERE NAME != 'Cliente'";

        try {
            listaEmpCust = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return listaEmpCust;
    }

    @Override
    public List<ItgParties> listarTable() {
        List<ItgParties> listaTable = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM ItgParties WHERE PARTY_ID=1";

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
    public List<ItgParties> listarTableEmp() {
        List<ItgParties> listaTableEmp = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM ItgParties WHERE PARTY_ID!=1";

        try {
            listaTableEmp = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return listaTableEmp;
    }

    @Override
    public void modificarCliente(ItgParties itgParties) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(itgParties);
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
    public void eliminarCliente(ItgParties itgParties) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(itgParties);
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
