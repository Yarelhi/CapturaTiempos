/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Imp;

import Dao.EmpleadoDao;
import Model.ItgCitiesAll;
import Model.ItgCountriesAll;
import Model.ItgEmployeesTypesAll;
import Model.ItgPersonalInfoAll;
import Model.ItgStatesAll;
import Model.ItgListValuesDet;
import Model.ItgUserRolesAll;

import Model.ItgUsersAll;
import Util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author DLVC
 */
public class EmployeesImp implements EmpleadoDao {

    @Override
    public List<ItgPersonalInfoAll> mostrarClientes() {
        List<ItgPersonalInfoAll> listarClientes = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM ItgPersonalInfoAll";

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
    public void nuevoClientes(ItgPersonalInfoAll itgPersonalInfoAll) {
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
    public List<ItgStatesAll> listarEstados(ItgPersonalInfoAll clientes) {
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
    public List<ItgCitiesAll> listarCiudades(ItgPersonalInfoAll clientes) {
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
    public List<ItgPersonalInfoAll> listarTable() {
        List<ItgPersonalInfoAll> listaTable = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM ItgPersonalInfoAll WHERE ITG_EMPLOYEES_CUSTOMERS_ALL_EMPLOYEE_CUSTOMER_ID=1";

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
    public List<ItgPersonalInfoAll> listarTableEmp() {
        List<ItgPersonalInfoAll> listaTableEmp = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM ItgPersonalInfoAll WHERE ITG_EMPLOYEES_CUSTOMERS_ALL_EMPLOYEE_CUSTOMER_ID !=1";

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
    public List<ItgUsersAll> listarDirectores() {
        List<ItgUsersAll> listarConsultor= null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM ItgUsersAll WHERE ITG_USER_ROLES_ALL_USER_ROLE_ID IN (1, 8, 16) " ;

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
    public List<ItgUsersAll> listarGerentes() {
        List<ItgUsersAll> listarConsultor= null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM ItgUsersAll WHERE ITG_USER_ROLES_ALL_USER_ROLE_ID IN (3, 17) " ;

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
    public List<ItgUsersAll> listarLider() {
        List<ItgUsersAll> listarConsultor= null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM ItgUsersAll WHERE ITG_USER_ROLES_ALL_USER_ROLE_ID IN (5, 20) " ;

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
    public void modificarCliente(ItgPersonalInfoAll itgPersonalInfoAll) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(itgPersonalInfoAll);
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
    public void eliminarCliente(ItgPersonalInfoAll itgPersonalInfoAll) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(itgPersonalInfoAll);
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
