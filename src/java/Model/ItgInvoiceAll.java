package Model;
// Generated 26/10/2021 05:06:03 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * ItgInvoiceAll generated by hbm2java
 */
public class ItgInvoiceAll  implements java.io.Serializable {


     private Integer idInvoiseReport;
     private ItgActivitiesAll itgActivitiesAll;
     private ItgProjectsAll itgProjectsAll;
     private byte[] xml;
     private Date date;
     private String empresa;

    public ItgInvoiceAll() {
    }

    public ItgInvoiceAll(ItgActivitiesAll itgActivitiesAll, ItgProjectsAll itgProjectsAll, byte[] xml, Date date, String empresa) {
       this.itgActivitiesAll = itgActivitiesAll;
       this.itgProjectsAll = itgProjectsAll;
       this.xml = xml;
       this.date = date;
       this.empresa = empresa;
    }
   
    public Integer getIdInvoiseReport() {
        return this.idInvoiseReport;
    }
    
    public void setIdInvoiseReport(Integer idInvoiseReport) {
        this.idInvoiseReport = idInvoiseReport;
    }
    public ItgActivitiesAll getItgActivitiesAll() {
        return this.itgActivitiesAll;
    }
    
    public void setItgActivitiesAll(ItgActivitiesAll itgActivitiesAll) {
        this.itgActivitiesAll = itgActivitiesAll;
    }
    public ItgProjectsAll getItgProjectsAll() {
        return this.itgProjectsAll;
    }
    
    public void setItgProjectsAll(ItgProjectsAll itgProjectsAll) {
        this.itgProjectsAll = itgProjectsAll;
    }
    public byte[] getXml() {
        return this.xml;
    }
    
    public void setXml(byte[] xml) {
        this.xml = xml;
    }
    public Date getDate() {
        return this.date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    public String getEmpresa() {
        return this.empresa;
    }
    
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }




}


