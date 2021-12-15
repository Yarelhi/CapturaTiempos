package Model;
// Generated 26 nov 2021 18:05:10 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * ItgParties generated by hbm2java
 */
public class ItgParties  implements java.io.Serializable {


     private Integer partyId;
     private ItgCitiesAll itgCitiesAll;
     private ItgCountriesAll itgCountriesAll;
     private ItgStatesAll itgStatesAll;
     private String partyName;
     private String partyType;
     private String alias;
     private String paternSurname;
     private String maternSurname;
     private Date dischargeDate;
     private String nationality;
     private BigDecimal phoneNumber1;
     private BigDecimal phoneNumber2;
     private BigDecimal phoneNumber3;
     private String rfc;
     private String mail1;
     private String mail2;
     private String mail3;
     private String delegation;
     private String streetNumber;
     private String colony;
     private String postalCode;
     private String attribute1;
     private String attribute2;
     private String attribute3;
     private String attribute4;
     private Integer status;
     private Date createDate;
     private Long createdBy;
     private Date lastUpdateDate;
     private Long lastUpdatedBy;
     private Set itgProjectsAlls = new HashSet(0);

    public ItgParties() {
        itgCitiesAll = new ItgCitiesAll();
        itgCountriesAll = new ItgCountriesAll();
        itgStatesAll = new ItgStatesAll();
    }

	
    public ItgParties(ItgCitiesAll itgCitiesAll, ItgCountriesAll itgCountriesAll, ItgStatesAll itgStatesAll) {
        this.itgCitiesAll = itgCitiesAll;
        this.itgCountriesAll = itgCountriesAll;
        this.itgStatesAll = itgStatesAll;
    }
    public ItgParties(ItgCitiesAll itgCitiesAll, ItgCountriesAll itgCountriesAll, ItgStatesAll itgStatesAll, String partyName, String partyType, String alias, String paternSurname, String maternSurname, Date dischargeDate, String nationality, BigDecimal phoneNumber1, BigDecimal phoneNumber2, BigDecimal phoneNumber3, String rfc, String mail1, String mail2, String mail3, String delegation, String streetNumber, String colony, String postalCode, String attribute1, String attribute2, String attribute3, String attribute4, Integer status, Date createDate, Long createdBy, Date lastUpdateDate, Long lastUpdatedBy, Set itgProjectsAlls) {
       this.itgCitiesAll = itgCitiesAll;
       this.itgCountriesAll = itgCountriesAll;
       this.itgStatesAll = itgStatesAll;
       this.partyName = partyName;
       this.partyType = partyType;
       this.alias = alias;
       this.paternSurname = paternSurname;
       this.maternSurname = maternSurname;
       this.dischargeDate = dischargeDate;
       this.nationality = nationality;
       this.phoneNumber1 = phoneNumber1;
       this.phoneNumber2 = phoneNumber2;
       this.phoneNumber3 = phoneNumber3;
       this.rfc = rfc;
       this.mail1 = mail1;
       this.mail2 = mail2;
       this.mail3 = mail3;
       this.delegation = delegation;
       this.streetNumber = streetNumber;
       this.colony = colony;
       this.postalCode = postalCode;
       this.attribute1 = attribute1;
       this.attribute2 = attribute2;
       this.attribute3 = attribute3;
       this.attribute4 = attribute4;
       this.status = status;
       this.createDate = createDate;
       this.createdBy = createdBy;
       this.lastUpdateDate = lastUpdateDate;
       this.lastUpdatedBy = lastUpdatedBy;
       this.itgProjectsAlls = itgProjectsAlls;
    }
   
    public Integer getPartyId() {
        return this.partyId;
        
    }
    
    public void setPartyId(Integer partyId) {
        this.partyId = partyId;
    }
    public ItgCitiesAll getItgCitiesAll() {
        return this.itgCitiesAll;
    }
    
    public void setItgCitiesAll(ItgCitiesAll itgCitiesAll) {
        this.itgCitiesAll = itgCitiesAll;
    }
    public ItgCountriesAll getItgCountriesAll() {
        return this.itgCountriesAll;
    }
    
    public void setItgCountriesAll(ItgCountriesAll itgCountriesAll) {
        this.itgCountriesAll = itgCountriesAll;
    }
    public ItgStatesAll getItgStatesAll() {
        return this.itgStatesAll;
    }
    
    public void setItgStatesAll(ItgStatesAll itgStatesAll) {
        this.itgStatesAll = itgStatesAll;
    }
    public String getPartyName() {
        return this.partyName;
    }
    
    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }
    public String getPartyType() {
        return this.partyType;
    }
    
    public void setPartyType(String partyType) {
        this.partyType = partyType;
    }
    public String getAlias() {
        if(alias == null){
            return "";
        }else{
        return this.alias;
    }
    }
    
    public void setAlias(String alias) {
        this.alias = alias;
    }
    public String getPaternSurname() {
        if(paternSurname == null){
            return "";
        }else{
        return this.paternSurname;
    }
    }
    
    public void setPaternSurname(String paternSurname) {
        this.paternSurname = paternSurname;
    }
    public String getMaternSurname() {
        if(maternSurname == null){
            return "";
        }else{
        return this.maternSurname;
    }
    }
    
    public void setMaternSurname(String maternSurname) {
        this.maternSurname = maternSurname;
    }
    public Date getDischargeDate() {
        return this.dischargeDate;
    }
    
    public void setDischargeDate(Date dischargeDate) {
        this.dischargeDate = dischargeDate;
    }
    public String getNationality() {
        return this.nationality;
    }
    
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    public BigDecimal getPhoneNumber1() {
        return this.phoneNumber1;
    }
    
    public void setPhoneNumber1(BigDecimal phoneNumber1) {
        this.phoneNumber1 = phoneNumber1;
    }
    public BigDecimal getPhoneNumber2() {
        return this.phoneNumber2;
    }
    
    public void setPhoneNumber2(BigDecimal phoneNumber2) {
        this.phoneNumber2 = phoneNumber2;
    }
    public BigDecimal getPhoneNumber3() {
        return this.phoneNumber3;
    }
    
    public void setPhoneNumber3(BigDecimal phoneNumber3) {
        this.phoneNumber3 = phoneNumber3;
    }
    public String getRfc() {
        return this.rfc;
    }
    
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }
    public String getMail1() {
        return this.mail1;
    }
    
    public void setMail1(String mail1) {
        this.mail1 = mail1;
    }
    public String getMail2() {
        return this.mail2;
    }
    
    public void setMail2(String mail2) {
        this.mail2 = mail2;
    }
    public String getMail3() {
        return this.mail3;
    }
    
    public void setMail3(String mail3) {
        this.mail3 = mail3;
    }
    public String getDelegation() {
        return this.delegation;
    }
    
    public void setDelegation(String delegation) {
        this.delegation = delegation;
    }
    public String getStreetNumber() {
        return this.streetNumber;
    }
    
    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }
    public String getColony() {
        return this.colony;
    }
    
    public void setColony(String colony) {
        this.colony = colony;
    }
    public String getPostalCode() {
        return this.postalCode;
    }
    
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    public String getAttribute1() {
        return this.attribute1;
    }
    
    public void setAttribute1(String attribute1) {
        this.attribute1 = attribute1;
    }
    public String getAttribute2() {
        return this.attribute2;
    }
    
    public void setAttribute2(String attribute2) {
        this.attribute2 = attribute2;
    }
    public String getAttribute3() {
        return this.attribute3;
    }
    
    public void setAttribute3(String attribute3) {
        this.attribute3 = attribute3;
    }
    public String getAttribute4() {
        return this.attribute4;
    }
    
    public void setAttribute4(String attribute4) {
        this.attribute4 = attribute4;
    }
    public Integer getStatus() {
        return this.status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }
    public Date getCreateDate() {
        return this.createDate;
    }
    
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    public Long getCreatedBy() {
        return this.createdBy;
    }
    
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }
    public Date getLastUpdateDate() {
        return this.lastUpdateDate;
    }
    
    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
    public Long getLastUpdatedBy() {
        return this.lastUpdatedBy;
    }
    
    public void setLastUpdatedBy(Long lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }
    public Set getItgProjectsAlls() {
        return this.itgProjectsAlls;
    }
    
    public void setItgProjectsAlls(Set itgProjectsAlls) {
        this.itgProjectsAlls = itgProjectsAlls;
    }

}


