/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans;

import Util.HibernateUtil;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jdbc.ReturningWork;

/**
 *
 * @author Briseydy
 */
public class ReporteCustomerMBean {
    
    // Different ways to get the Connection object using Session
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        
        
        // Way2 - using doReturningWork method
        Connection connection = session.doReturningWork(new ReturningWork<Connection>() {
            @Override
            public Connection execute(Connection conn) throws SQLException {
                return conn;
            }
        });
    
    // "cm" lo que sea
    public void getReporteIndividual(String ruta, String Cm, String path, String pie, String oracle) throws  ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
    
        //Connection conexion;
        //Class.forName("com.mysql.jdbc.Driver").newInstance();
        //conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/xxeks_module_times_db", "root", "1234");

        //Parametros
        Map parameter = new HashMap();
        parameter.put("CustomerM", Cm);
        parameter.put("Path", path);
        parameter.put("piePagina", pie);
        parameter.put("Oracle", oracle);

        try {
            File file = new File(ruta);

            HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();

            httpServletResponse.setContentType("application/pdf");
            httpServletResponse.addHeader("Content-Type", "application/pdf");

            JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(file.getPath());

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameter, connection);

            JRExporter jrExporter = null;                      
            jrExporter = new JRPdfExporter();
            jrExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            jrExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, httpServletResponse.getOutputStream());

            if (jrExporter != null) {
                try {
                    jrExporter.exportReport();
                } catch (JRException e) {
                    e.printStackTrace();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
