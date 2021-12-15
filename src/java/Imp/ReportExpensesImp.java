/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Imp;

import Dao.ReportExpensesDao;
import Model.ItgExpenseReportsDetail;
import Model.ItgExpenseReportsAll;
import Model.ItgPersonalInfoAll;
import Model.ItgProjectsAll;
import Model.ItgVouchersStatus;
import Model.ItgReportStatus;
import Model.ItgExpenseTypes;
import Model.ItgUsersAll;
import Util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Administrador
 */
public class ReportExpensesImp implements ReportExpensesDao {

    @Override
    public List<ItgExpenseReportsAll> mostrarReportEA() {
        List<ItgExpenseReportsAll> listarReportEA = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "From ItgExpenseReportsAll";

        try {
            listarReportEA = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return listarReportEA;

    }

    @Override
    public void nuevaReportEA(ItgExpenseReportsAll itgExpenseReportsAll) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(itgExpenseReportsAll);
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
    public List<ItgExpenseReportsDetail> mostarGastosReport() {
        List<ItgExpenseReportsDetail> listarGastoReport = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "From ItgExpenseReportsDetail";

        try {
            listarGastoReport = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return listarGastoReport;
    }

    @Override
    public void nuevoGastoReport(ItgExpenseReportsDetail itgExpenseReportsDetail) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(itgExpenseReportsDetail);
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
    public List<ItgExpenseTypes> listaTipoGast(int project) {
        List<ItgExpenseTypes> listaTableGast = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM ItgExpenseTypes WHERE ITG_PROJECTS_ALL_PROJECT_ID = " + project + " ";
        try {
            listaTableGast = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return listaTableGast;
    }

    @Override
    public List<ItgExpenseReportsDetail> tableGastReport(ItgExpenseReportsAll reporte) {
        List<ItgExpenseReportsDetail> tableGastReport = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM ItgExpenseReportsDetail WHERE ITG_EXPENSE_REPORTS_ALL_ALL_REPORT_ID = " + reporte.getReportId();
        try {
            tableGastReport = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return tableGastReport;
    }

    @Override
    public List<ItgExpenseTypes> getGastoReport() {
        List<ItgExpenseTypes> gasto = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM ItgExpenseTypes WHERE  ITG_PROJECTS_ALL_PROJECT_ID  is null";
        try {
            gasto = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return gasto;
    }

    @Override
    public List<ItgExpenseTypes> getGastos() {
        List<ItgExpenseTypes> gasto = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM ItgExpenseTypes";
        try {
            gasto = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return gasto;
    }

    @Override
    public void modificarGastoReport(ItgExpenseReportsDetail itgExpenseReportsDetail) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(itgExpenseReportsDetail);
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
    public void eliminarGastoReport(ItgExpenseReportsDetail itgExpenseReportsDetail) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(itgExpenseReportsDetail);
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
    public List<ItgExpenseReportsDetail> obtenerGastLine() {
        List<ItgExpenseReportsDetail> listGastLine = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM ItgExpenseReportsDetail";
        try {
            listGastLine = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return listGastLine;

    }

    @Override
    public void modificarCReport(int id, long totalReport) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Query q;
        q = session.createQuery("update ItgExpenseReportsAll set totalExpenseReport=:totalReport where reportId=:id");
        q.setParameter("totalReport", totalReport);
        q.setParameter("id", id);

        int status = q.executeUpdate();
        System.out.println(status);
        transaction.commit();

    }

    @Override
    public void modificarEncabe(ItgExpenseReportsAll itgExpenseReportsAll) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(itgExpenseReportsAll);
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
    public List<ItgExpenseReportsAll> mostrarGastEncabe(ItgExpenseReportsAll reporte) {
        List<ItgExpenseReportsAll> listaTableGast = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM ItgExpenseReportsAll WHERE REPORT_ID = " + reporte.getReportId();
        try {
            listaTableGast = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return listaTableGast;

    }

    @Override
    public List<ItgExpenseReportsDetail> listaExpenses(int IdReporte, int tipoExpenses) {
        List<ItgExpenseReportsDetail> listaExpenses = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM ItgExpenseReportsDetail WHERE ITG_EXPENSE_REPORTS_ALL_ALL_REPORT_ID=" + IdReporte + " AND ITG_EXPENSE_TYPES_SPEND_ID = " + tipoExpenses;
        try {
            listaExpenses = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return listaExpenses;
    }

    @Override
    public List<ItgExpenseReportsDetail> getGastosEmail(int IdReporte) {
        List<ItgExpenseReportsDetail> listaExpenses = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM ItgExpenseReportsDetail WHERE ITG_EXPENSE_REPORTS_ALL_ALL_REPORT_ID=" + IdReporte;
        try {
            listaExpenses = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return listaExpenses;
    }

    @Override
    public List<ItgUsersAll> getCorrreo(int idPersonal) {
        List<ItgUsersAll> listaExpenses = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM ItgUsersAll WHERE ITG_PERSONAL_INFO_ALL_PERSONAL_DATA_ID=" + idPersonal;
        try {
            listaExpenses = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return listaExpenses;
    }

    @Override
    public List<ItgUsersAll> getDirector(int area) {
        List<ItgUsersAll> listaExpenses = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM ItgUsersAll WHERE ITG_WORK_AREA_AREA_ID=" + area;
        try {
            listaExpenses = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return listaExpenses;

    }

    @Override
    public List<ItgProjectsAll> getProyec() {
        List<ItgProjectsAll> listaExpenses = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM ItgProjectsAll";
        try {
            listaExpenses = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return listaExpenses;

    }

    @Override
    public List<ItgPersonalInfoAll> getAprobador() {
        List<ItgPersonalInfoAll> listaExpenses = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM ItgPersonalInfoAll";
        try {
            listaExpenses = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return listaExpenses;

    }

    @Override
    public List<ItgExpenseReportsAll> listarTabReport(ItgUsersAll usuario) {
        List<ItgExpenseReportsAll> listarReportEA = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "From ItgExpenseReportsAll WHERE ITG_PERSONAL_INFO_ALL_PERSONAL_DATA_ID=" + usuario.getItgPersonalInfoAll().getPersonalDataId() + "";

        try {
            listarReportEA = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return listarReportEA;
    }

    @Override
    public List<ItgReportStatus> getStatus() {
        List<ItgReportStatus> verStatus = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "From ItgReportStatus";

        try {
            verStatus = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return verStatus;

    }

    @Override
    public List<ItgVouchersStatus> getStatusVoucher() {
        List<ItgVouchersStatus> verStatus = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "From ItgVouchersStatus";

        try {
            verStatus = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return verStatus;

    }

    @Override
    public void modificarStatusRepor(int id, int idStatus) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Query q;
        q = session.createQuery("update ItgExpenseReportsAll set  ITG_REPORT_STATUS_STATUS_ID=:idStatus where reportId=:id");
        q.setParameter("idStatus", idStatus);
        q.setParameter("id", id);

        int status = q.executeUpdate();
        System.out.println(status);
        transaction.commit();
    }

    @Override
    public void modifcarStatusVouchers(int idRepor, int idVoucher) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Query q;
        q = session.createQuery("update ItgExpenseReportsAll set  ITG_VOUCHERS_STATUS_VOUCHER_ID=:idVoucher where reportId=:idRepor");
        q.setParameter("idVoucher", idVoucher);
        q.setParameter("idRepor", idRepor);

        int status = q.executeUpdate();
        System.out.println(status);
        transaction.commit();

    }

    @Override
    public List<ItgExpenseReportsAll> listarTabReportE() {
        List<ItgExpenseReportsAll> listarReportEA = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "From ItgExpenseReportsAll";

        try {
            listarReportEA = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return listarReportEA;

    }

    @Override
    public List<ItgReportStatus> listaStatusReport() {
        List<ItgReportStatus> listarStatusReport = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM ItgReportStatus WHERE STATUS_ID = 3 OR\n" + "STATUS_ID = 6 OR STATUS_ID = 5 OR STATUS_ID = 2";

        try {
            listarStatusReport = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return listarStatusReport;
    }

    @Override
    public List<ItgReportStatus> listaStatusReportP() {
        List<ItgReportStatus> listarStatusReport = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM ItgReportStatus WHERE STATUS_ID = 3 OR\n" + "STATUS_ID = 7 OR STATUS_ID = 4";

        try {
            listarStatusReport = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return listarStatusReport;
    }

    @Override
    public void modificarStatus(ItgExpenseReportsAll itgExpenseReportsAll) {
        Session session = null;
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(itgExpenseReportsAll);
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
    public List<ItgVouchersStatus> listaStatusReportVo() {
        List<ItgVouchersStatus> listarStatusReportVo = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM ItgVouchersStatus";

        try {
            listarStatusReportVo = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return listarStatusReportVo;

    }

    @Override
    public List<ItgExpenseReportsAll> listarTabReportS() {
        List<ItgExpenseReportsAll> listarReportEA = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "From ItgExpenseReportsAll WHERE ITG_REPORT_STATUS_STATUS_ID=3 OR\n" + "ITG_REPORT_STATUS_STATUS_ID = 7 OR ITG_REPORT_STATUS_STATUS_ID = 4";

        try {
            listarReportEA = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return listarReportEA;
    }

    @Override
    public List<ItgExpenseReportsDetail> tableGastReportM(ItgExpenseReportsAll obtenerReporte) {
        List<ItgExpenseReportsDetail> tableGastReport = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM ItgExpenseReportsDetail WHERE ITG_EXPENSE_REPORTS_ALL_ALL_REPORT_ID = " + obtenerReporte.getReportId();
        try {
            tableGastReport = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return tableGastReport;
    }

    @Override
    public List<ItgExpenseTypes> listaTipoGastM(int projec) {
        List<ItgExpenseTypes> listaExpensesM = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM ItgExpenseTypes WHERE ITG_PROJECTS_ALL_PROJECT_ID=" + projec + "";
        try {
            listaExpensesM = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return listaExpensesM;
    }

    @Override
    public void asignarApproverReport(int idRepor, int idApro) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Query q;
        q = session.createQuery("update ItgExpenseReportsAll set  ITG_PERSONAL_INFO_ALL_APROVER_ID=:idApro where reportId=:idRepor");
        q.setParameter("idApro", idApro);
        q.setParameter("idRepor", idRepor);

        int status = q.executeUpdate();
        System.out.println(status);
        transaction.commit();
    }

    @Override
    public List<ItgExpenseReportsAll> listarTabAproRe(ItgUsersAll usuario) {
        List<ItgExpenseReportsAll> listarReportApro = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "From ItgExpenseReportsAll WHERE ITG_PERSONAL_INFO_ALL_APROVER_ID=" + usuario.getItgPersonalInfoAll().getPersonalDataId() + "";

        try {
            listarReportApro = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return listarReportApro;
    }

    @Override
    public void modificarBoton(int idRepor, boolean boton) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Query q;
        q = session.createQuery("update ItgExpenseReportsAll set  NAME_REPORT=:boton where reportId=:idRepor");
        q.setParameter("boton", boton);
        q.setParameter("idRepor", idRepor);

        int status = q.executeUpdate();
        System.out.println(status);
        transaction.commit();
    }

    @Override
    public List<ItgUsersAll> getUsers() {
        List<ItgUsersAll> listaUsers = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM ItgUsersAll";
        try {
            listaUsers = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return listaUsers;
    }

    @Override
    public List<ItgPersonalInfoAll> getEmpleM(int idEmpleado) {
        List<ItgPersonalInfoAll> getEmpleado = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM ItgPersonalInfoAll WHERE PERSONAL_DATA_ID = " + idEmpleado;
        try {
            getEmpleado = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return getEmpleado;
    }

    @Override
    public void modificarBotonD(int idRepor, boolean boton) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Query q;
        q = session.createQuery("update ItgExpenseReportsAll set  ATTRIBUTE4=:boton where reportId=:idRepor");
        q.setParameter("boton", boton);
        q.setParameter("idRepor", idRepor);

        int status = q.executeUpdate();
        System.out.println(status);
        transaction.commit();
    }

    @Override
    public void eliminarReportL(ItgExpenseReportsAll itgExpenseReportsAll) {
         Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(itgExpenseReportsAll);
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
    public void modificarBotonEl(int idRepor, boolean boton) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Query q;
        q = session.createQuery("update ItgExpenseReportsAll set  ATTRIBUTE5=:boton where reportId=:idRepor");
        q.setParameter("boton", boton);
        q.setParameter("idRepor", idRepor);

        int status = q.executeUpdate();
        System.out.println(status);
        transaction.commit();
    }

}
