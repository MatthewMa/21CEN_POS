package com.matthew.model;

import java.io.Serializable;

public class Supplier implements Serializable {

    /**
     * ID : 710ee5cb-8734-40fd-91c6-b37b87858ac9
     * SUPPLIERNAME : 合肥
     * ACCOUNTNUMBER :
     * ADDRESS :
     * ADDRESS2 :
     * CITY :
     * POSTCODE :
     * EMAIL :
     * PHONE :
     * CREDITLIMIT : 0
     * CREDITTERMS :
     * ACTIVE : 
     * CONTACT :
     * NOTES :
     * SFLAG : 
     * SITEGUID : 82133727-ed76-46aa-8a41-42f8be75f96a
     */

    private String ID;
    private String SUPPLIERNAME;
    private String ACCOUNTNUMBER;
    private String ADDRESS;
    private String ADDRESS2;
    private String CITY;
    private String POSTCODE;
    private String EMAIL;
    private String PHONE;
    private int CREDITLIMIT;
    private String CREDITTERMS;
    private String ACTIVE;
    private String CONTACT;
    private String NOTES;
    private String SFLAG;
    private String SITEGUID;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getSUPPLIERNAME() {
        return SUPPLIERNAME;
    }

    public void setSUPPLIERNAME(String SUPPLIERNAME) {
        this.SUPPLIERNAME = SUPPLIERNAME;
    }

    public String getACCOUNTNUMBER() {
        return ACCOUNTNUMBER;
    }

    public void setACCOUNTNUMBER(String ACCOUNTNUMBER) {
        this.ACCOUNTNUMBER = ACCOUNTNUMBER;
    }

    public String getADDRESS() {
        return ADDRESS;
    }

    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
    }

    public String getADDRESS2() {
        return ADDRESS2;
    }

    public void setADDRESS2(String ADDRESS2) {
        this.ADDRESS2 = ADDRESS2;
    }

    public String getCITY() {
        return CITY;
    }

    public void setCITY(String CITY) {
        this.CITY = CITY;
    }

    public String getPOSTCODE() {
        return POSTCODE;
    }

    public void setPOSTCODE(String POSTCODE) {
        this.POSTCODE = POSTCODE;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getPHONE() {
        return PHONE;
    }

    public void setPHONE(String PHONE) {
        this.PHONE = PHONE;
    }

    public int getCREDITLIMIT() {
        return CREDITLIMIT;
    }

    public void setCREDITLIMIT(int CREDITLIMIT) {
        this.CREDITLIMIT = CREDITLIMIT;
    }

    public String getCREDITTERMS() {
        return CREDITTERMS;
    }

    public void setCREDITTERMS(String CREDITTERMS) {
        this.CREDITTERMS = CREDITTERMS;
    }

    public String getACTIVE() {
        return ACTIVE;
    }

    public void setACTIVE(String ACTIVE) {
        this.ACTIVE = ACTIVE;
    }

    public String getCONTACT() {
        return CONTACT;
    }

    public void setCONTACT(String CONTACT) {
        this.CONTACT = CONTACT;
    }

    public String getNOTES() {
        return NOTES;
    }

    public void setNOTES(String NOTES) {
        this.NOTES = NOTES;
    }

    public String getSFLAG() {
        return SFLAG;
    }

    public void setSFLAG(String SFLAG) {
        this.SFLAG = SFLAG;
    }

    public String getSITEGUID() {
        return SITEGUID;
    }

    public void setSITEGUID(String SITEGUID) {
        this.SITEGUID = SITEGUID;
    }
}
