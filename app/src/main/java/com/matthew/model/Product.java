package com.matthew.model;

import java.io.Serializable;

public class Product implements Serializable {
    @Override
    public String toString() {
        return "Product{" +
                "ID='" + ID + '\'' +
                ", REFERENCE='" + REFERENCE + '\'' +
                ", CODE='" + CODE + '\'' +
                ", CODETYPE='" + CODETYPE + '\'' +
                ", NAME='" + NAME + '\'' +
                ", PRICEBUY=" + PRICEBUY +
                ", PRICESELL=" + PRICESELL +
                ", CATEGORY='" + CATEGORY + '\'' +
                ", TAXCAT='" + TAXCAT + '\'' +
                ", ATTRIBUTESETID='" + ATTRIBUTESETID + '\'' +
                ", STOCKCOST=" + STOCKCOST +
                ", STOCKVOLUME=" + STOCKVOLUME +
                ", ISCOM='" + ISCOM + '\'' +
                ", ISSCALE='" + ISSCALE + '\'' +
                ", ISKITCHEN='" + ISKITCHEN + '\'' +
                ", PRINTKB='" + PRINTKB + '\'' +
                ", SENDSTATUS='" + SENDSTATUS + '\'' +
                ", ISSERVICE='" + ISSERVICE + '\'' +
                ", DISPLAY='" + DISPLAY + '\'' +
                ", ATTRIBUTES='" + ATTRIBUTES + '\'' +
                ", ISVPRICE='" + ISVPRICE + '\'' +
                ", ISVERPATRIB='" + ISVERPATRIB + '\'' +
                ", TEXTTIP='" + TEXTTIP + '\'' +
                ", WARRANTY='" + WARRANTY + '\'' +
                ", IMAGE='" + IMAGE + '\'' +
                ", STOCKUNITS=" + STOCKUNITS +
                ", ALIAS='" + ALIAS + '\'' +
                ", ALWAYSAVAILABLE='" + ALWAYSAVAILABLE + '\'' +
                ", DISCOUNTED='" + DISCOUNTED + '\'' +
                ", CANDISCOUNT='" + CANDISCOUNT + '\'' +
                ", ISCATALOG='" + ISCATALOG + '\'' +
                ", CATORDER=" + CATORDER +
                ", ISPACK='" + ISPACK + '\'' +
                ", PACKQUANTITY=" + PACKQUANTITY +
                ", PACKPRODUCT='" + PACKPRODUCT + '\'' +
                ", PROMOTIONID='" + PROMOTIONID + '\'' +
                ", ALLPRODUCTS='" + ALLPRODUCTS + '\'' +
                ", MANAGESTOCK='" + MANAGESTOCK + '\'' +
                ", SFLAG='" + SFLAG + '\'' +
                ", SITEGUID='" + SITEGUID + '\'' +
                ", COMMISSION=" + COMMISSION +
                ", SUPPLIER='" + SUPPLIER + '\'' +
                ", ENVIRONMENT=" + ENVIRONMENT +
                ", DEPOSIT=" + DEPOSIT +
                ", EXPIRY='" + EXPIRY + '\'' +
                ", NOTES='" + NOTES + '\'' +
                ", PACK=" + PACK +
                ", PACKPRICE=" + PACKPRICE +
                ", UNITSIZE='" + UNITSIZE + '\'' +
                ", UNIT='" + UNIT + '\'' +
                ", DATES='" + DATES + '\'' +
                ", AMOUNT=" + AMOUNT +
                ", TOTALAMOUNT=" + TOTALAMOUNT +
                ", LASTSALEDATE='" + LASTSALEDATE + '\'' +
                ", PROFITPERCENT=" + PROFITPERCENT +
                ", SOLD=" + SOLD +
                '}';
    }

    /**
     * ID : 6da2c35e-802b-4c1c-8dca-864f6e3774db
     * REFERENCE : LJ268
     * CODE : 1115
     * CODETYPE : CODE128
     * NAME : Lychee
     * PRICEBUY : 1.36
     * PRICESELL : 2.69
     * CATEGORY : c3efccf9-fa1f-481e-92bb-499066cde329
     * TAXCAT : 2931f392-9d49-4e84-8553-edcb08ca840a
     * ATTRIBUTESETID :
     * STOCKCOST : 0
     * STOCKVOLUME : 0
     * ISCOM :  
     * ISSCALE : 
     * ISKITCHEN :  
     * PRINTKB :  
     * SENDSTATUS :  
     * ISSERVICE :  
     * DISPLAY : <HTML>Lychee
     * ATTRIBUTES :
     * ISVPRICE :  
     * ISVERPATRIB :  
     * TEXTTIP : Lychee
     * WARRANTY :  
     * IMAGE :
     * STOCKUNITS : 0
     * ALIAS : 荔枝
     * ALWAYSAVAILABLE :  
     * DISCOUNTED : no
     * CANDISCOUNT :  
     * ISCATALOG : 
     * CATORDER : 0
     * ISPACK :  
     * PACKQUANTITY : 0
     * PACKPRODUCT :
     * PROMOTIONID :
     * ALLPRODUCTS :  
     * MANAGESTOCK : 
     * SFLAG : 
     * SITEGUID : 82133727-ed76-46aa-8a41-42f8be75f96a
     * COMMISSION : 0
     * SUPPLIER : c2279824-6583-4891-bcea-e99ad6967cee
     * ENVIRONMENT : 0
     * DEPOSIT : 0
     * EXPIRY : 2019/2/23
     * NOTES :
     * PACK : 0
     * PACKPRICE : 0
     * UNITSIZE :
     * UNIT : lb
     * DATES : 0001-01-01T00:00:00Z
     * AMOUNT : -4
     * TOTALAMOUNT : 22
     * LASTSALEDATE : 2018/12/11
     * PROFITPERCENT : 98
     * SOLD : 26
     */

    private String ID;
    private String REFERENCE;
    private String CODE;
    private String CODETYPE;
    private String NAME;
    private double PRICEBUY;
    private double PRICESELL;
    private String CATEGORY;
    private String TAXCAT;
    private String ATTRIBUTESETID;
    private int STOCKCOST;
    private int STOCKVOLUME;
    private String ISCOM;
    private String ISSCALE;
    private String ISKITCHEN;
    private String PRINTKB;
    private String SENDSTATUS;
    private String ISSERVICE;
    private String DISPLAY;
    private String ATTRIBUTES;
    private String ISVPRICE;
    private String ISVERPATRIB;
    private String TEXTTIP;
    private String WARRANTY;
    private String IMAGE;
    private int STOCKUNITS;
    private String ALIAS;
    private String ALWAYSAVAILABLE;
    private String DISCOUNTED;
    private String CANDISCOUNT;
    private String ISCATALOG;
    private int CATORDER;
    private String ISPACK;
    private int PACKQUANTITY;
    private String PACKPRODUCT;
    private String PROMOTIONID;
    private String ALLPRODUCTS;
    private String MANAGESTOCK;
    private String SFLAG;
    private String SITEGUID;
    private int COMMISSION;
    private String SUPPLIER;
    private double ENVIRONMENT;
    private double DEPOSIT;
    private String EXPIRY;
    private String NOTES;
    private double PACK;
    private double PACKPRICE;
    private String UNITSIZE;
    private String UNIT;
    private String DATES;
    private double AMOUNT;
    private double TOTALAMOUNT;
    private String LASTSALEDATE;
    private double PROFITPERCENT;
    private double SOLD;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getREFERENCE() {
        return REFERENCE;
    }

    public void setREFERENCE(String REFERENCE) {
        this.REFERENCE = REFERENCE;
    }

    public String getCODE() {
        return CODE;
    }

    public void setCODE(String CODE) {
        this.CODE = CODE;
    }

    public String getCODETYPE() {
        return CODETYPE;
    }

    public void setCODETYPE(String CODETYPE) {
        this.CODETYPE = CODETYPE;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public double getPRICEBUY() {
        return PRICEBUY;
    }

    public void setPRICEBUY(double PRICEBUY) {
        this.PRICEBUY = PRICEBUY;
    }

    public double getPRICESELL() {
        return PRICESELL;
    }

    public void setPRICESELL(double PRICESELL) {
        this.PRICESELL = PRICESELL;
    }

    public String getCATEGORY() {
        return CATEGORY;
    }

    public void setCATEGORY(String CATEGORY) {
        this.CATEGORY = CATEGORY;
    }

    public String getTAXCAT() {
        return TAXCAT;
    }

    public void setTAXCAT(String TAXCAT) {
        this.TAXCAT = TAXCAT;
    }

    public String getATTRIBUTESETID() {
        return ATTRIBUTESETID;
    }

    public void setATTRIBUTESETID(String ATTRIBUTESETID) {
        this.ATTRIBUTESETID = ATTRIBUTESETID;
    }

    public int getSTOCKCOST() {
        return STOCKCOST;
    }

    public void setSTOCKCOST(int STOCKCOST) {
        this.STOCKCOST = STOCKCOST;
    }

    public int getSTOCKVOLUME() {
        return STOCKVOLUME;
    }

    public void setSTOCKVOLUME(int STOCKVOLUME) {
        this.STOCKVOLUME = STOCKVOLUME;
    }

    public String getISCOM() {
        return ISCOM;
    }

    public void setISCOM(String ISCOM) {
        this.ISCOM = ISCOM;
    }

    public String getISSCALE() {
        return ISSCALE;
    }

    public void setISSCALE(String ISSCALE) {
        this.ISSCALE = ISSCALE;
    }

    public String getISKITCHEN() {
        return ISKITCHEN;
    }

    public void setISKITCHEN(String ISKITCHEN) {
        this.ISKITCHEN = ISKITCHEN;
    }

    public String getPRINTKB() {
        return PRINTKB;
    }

    public void setPRINTKB(String PRINTKB) {
        this.PRINTKB = PRINTKB;
    }

    public String getSENDSTATUS() {
        return SENDSTATUS;
    }

    public void setSENDSTATUS(String SENDSTATUS) {
        this.SENDSTATUS = SENDSTATUS;
    }

    public String getISSERVICE() {
        return ISSERVICE;
    }

    public void setISSERVICE(String ISSERVICE) {
        this.ISSERVICE = ISSERVICE;
    }

    public String getDISPLAY() {
        return DISPLAY;
    }

    public void setDISPLAY(String DISPLAY) {
        this.DISPLAY = DISPLAY;
    }

    public String getATTRIBUTES() {
        return ATTRIBUTES;
    }

    public void setATTRIBUTES(String ATTRIBUTES) {
        this.ATTRIBUTES = ATTRIBUTES;
    }

    public String getISVPRICE() {
        return ISVPRICE;
    }

    public void setISVPRICE(String ISVPRICE) {
        this.ISVPRICE = ISVPRICE;
    }

    public String getISVERPATRIB() {
        return ISVERPATRIB;
    }

    public void setISVERPATRIB(String ISVERPATRIB) {
        this.ISVERPATRIB = ISVERPATRIB;
    }

    public String getTEXTTIP() {
        return TEXTTIP;
    }

    public void setTEXTTIP(String TEXTTIP) {
        this.TEXTTIP = TEXTTIP;
    }

    public String getWARRANTY() {
        return WARRANTY;
    }

    public void setWARRANTY(String WARRANTY) {
        this.WARRANTY = WARRANTY;
    }

    public String getIMAGE() {
        return IMAGE;
    }

    public void setIMAGE(String IMAGE) {
        this.IMAGE = IMAGE;
    }

    public int getSTOCKUNITS() {
        return STOCKUNITS;
    }

    public void setSTOCKUNITS(int STOCKUNITS) {
        this.STOCKUNITS = STOCKUNITS;
    }

    public String getALIAS() {
        return ALIAS;
    }

    public void setALIAS(String ALIAS) {
        this.ALIAS = ALIAS;
    }

    public String getALWAYSAVAILABLE() {
        return ALWAYSAVAILABLE;
    }

    public void setALWAYSAVAILABLE(String ALWAYSAVAILABLE) {
        this.ALWAYSAVAILABLE = ALWAYSAVAILABLE;
    }

    public String getDISCOUNTED() {
        return DISCOUNTED;
    }

    public void setDISCOUNTED(String DISCOUNTED) {
        this.DISCOUNTED = DISCOUNTED;
    }

    public String getCANDISCOUNT() {
        return CANDISCOUNT;
    }

    public void setCANDISCOUNT(String CANDISCOUNT) {
        this.CANDISCOUNT = CANDISCOUNT;
    }

    public String getISCATALOG() {
        return ISCATALOG;
    }

    public void setISCATALOG(String ISCATALOG) {
        this.ISCATALOG = ISCATALOG;
    }

    public int getCATORDER() {
        return CATORDER;
    }

    public void setCATORDER(int CATORDER) {
        this.CATORDER = CATORDER;
    }

    public String getISPACK() {
        return ISPACK;
    }

    public void setISPACK(String ISPACK) {
        this.ISPACK = ISPACK;
    }

    public int getPACKQUANTITY() {
        return PACKQUANTITY;
    }

    public void setPACKQUANTITY(int PACKQUANTITY) {
        this.PACKQUANTITY = PACKQUANTITY;
    }

    public String getPACKPRODUCT() {
        return PACKPRODUCT;
    }

    public void setPACKPRODUCT(String PACKPRODUCT) {
        this.PACKPRODUCT = PACKPRODUCT;
    }

    public String getPROMOTIONID() {
        return PROMOTIONID;
    }

    public void setPROMOTIONID(String PROMOTIONID) {
        this.PROMOTIONID = PROMOTIONID;
    }

    public String getALLPRODUCTS() {
        return ALLPRODUCTS;
    }

    public void setALLPRODUCTS(String ALLPRODUCTS) {
        this.ALLPRODUCTS = ALLPRODUCTS;
    }

    public String getMANAGESTOCK() {
        return MANAGESTOCK;
    }

    public void setMANAGESTOCK(String MANAGESTOCK) {
        this.MANAGESTOCK = MANAGESTOCK;
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

    public int getCOMMISSION() {
        return COMMISSION;
    }

    public void setCOMMISSION(int COMMISSION) {
        this.COMMISSION = COMMISSION;
    }

    public String getSUPPLIER() {
        return SUPPLIER;
    }

    public void setSUPPLIER(String SUPPLIER) {
        this.SUPPLIER = SUPPLIER;
    }

    public double getENVIRONMENT() {
        return ENVIRONMENT;
    }

    public void setENVIRONMENT(int ENVIRONMENT) {
        this.ENVIRONMENT = ENVIRONMENT;
    }

    public double getDEPOSIT() {
        return DEPOSIT;
    }

    public void setDEPOSIT(int DEPOSIT) {
        this.DEPOSIT = DEPOSIT;
    }

    public String getEXPIRY() {
        return EXPIRY;
    }

    public void setEXPIRY(String EXPIRY) {
        this.EXPIRY = EXPIRY;
    }

    public String getNOTES() {
        return NOTES;
    }

    public void setNOTES(String NOTES) {
        this.NOTES = NOTES;
    }

    public double getPACK() {
        return PACK;
    }

    public void setPACK(int PACK) {
        this.PACK = PACK;
    }

    public double getPACKPRICE() {
        return PACKPRICE;
    }

    public void setPACKPRICE(int PACKPRICE) {
        this.PACKPRICE = PACKPRICE;
    }

    public String getUNITSIZE() {
        return UNITSIZE;
    }

    public void setUNITSIZE(String UNITSIZE) {
        this.UNITSIZE = UNITSIZE;
    }

    public String getUNIT() {
        return UNIT;
    }

    public void setUNIT(String UNIT) {
        this.UNIT = UNIT;
    }

    public String getDATES() {
        return DATES;
    }

    public void setDATES(String DATES) {
        this.DATES = DATES;
    }

    public double getAMOUNT() {
        return AMOUNT;
    }

    public void setAMOUNT(double AMOUNT) {
        this.AMOUNT = AMOUNT;
    }

    public double getTOTALAMOUNT() {
        return TOTALAMOUNT;
    }

    public void setTOTALAMOUNT(double TOTALAMOUNT) {
        this.TOTALAMOUNT = TOTALAMOUNT;
    }

    public String getLASTSALEDATE() {
        return LASTSALEDATE;
    }

    public void setLASTSALEDATE(String LASTSALEDATE) {
        this.LASTSALEDATE = LASTSALEDATE;
    }

    public double getPROFITPERCENT() {
        return PROFITPERCENT;
    }

    public void setPROFITPERCENT(int PROFITPERCENT) {
        this.PROFITPERCENT = PROFITPERCENT;
    }

    public double getSOLD() {
        return SOLD;
    }

    public void setSOLD(int SOLD) {
        this.SOLD = SOLD;
    }
}
