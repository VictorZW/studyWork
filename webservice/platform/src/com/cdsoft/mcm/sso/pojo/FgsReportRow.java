package com.cdsoft.mcm.sso.pojo;

/**
 * 分公司收耗存日报【入库】-一行记录
 * 对应报表：http://10.158.189.57/fam.cost.SupplyControl.cmd?method=supplyReportHead_com
 */
public class FgsReportRow {
    private String REGION_ID;//区域ID ，如山东分公司 8335
    private String REGION_NAME;//分公司名称，如山东
    private String ENTITY_ORG_ID;//组织ID 如邹县电厂 130
    private String CMIS_COMPANY_NAME;//电厂名称，如邹县电厂
    private int MERGE_NUM;//合并行参数，第一行时为需要合并的行数量，其他行时为0
    private String FDL_DR;//当日发电量
    private String JML_DR;//当日进煤数量
    private String JML_HC;//运输方式-火车
    private String JML_QC;//运输方式-汽车
    private String JML_CY;//运输方式-船运
    private String JML_BQY;//区域结构-本区域
    private String JML_SX;//区域结构-山西
    private String JML_SHX;//区域结构-陕西
    private String JML_QHD;//区域结构-秦皇岛
    private String JML_QT;//区域结构-其他
    private String JML_LJ;//累计进煤数量
    private String JML_DRHY;//当日耗用
    private String JML_LJHY;//累计耗用
    private String JML_ZMKC;//账面库存
    private String JML_KYKC;//可用库存
    private String JML_ZRKC;//与昨日库存比较
    private String JML_AVGTEN;//按10天平均日耗煤量
    private String JML_RHML80FH;//按电厂80%负荷率

    public FgsReportRow() {
    }

    public FgsReportRow(FDL_DR fdlDr,
                        JML_DR jmlDr,
                        JML_HC jmlHc,
                        JML_QC jmlQc,
                        JML_CY jmlCy,
                        JML_BQY jmlBqy,
                        JML_SX jmlSx,
                        JML_SHX jmlShx,
                        JML_QHD jmlQhd,
                        JML_QT jmlQt,
                        JML_LJ jmlLj,
                        JML_DRHY jmlDrhy,
                        JML_LJHY jmlLjhy,
                        JML_ZMKC jmlZmkc,
                        JML_KYKC jmlKykc,
                        JML_ZRKC jmlZrkc,
                        JML_AVGTEN jmlAvgten,
                        JML_RHML80FH jmlRhml80FH) {
        this.REGION_ID = fdlDr.getREGION_ID();
        this.REGION_NAME = fdlDr.getREGION_NAME();
        this.ENTITY_ORG_ID = fdlDr.getENTITY_ORG_ID();
        this.CMIS_COMPANY_NAME = fdlDr.getCMIS_COMPANY_NAME();
        this.FDL_DR = fdlDr.getFDL_DR();
        this.JML_DR = jmlDr.getJML_DR();
        this.JML_HC = jmlHc.getJML_HC();
        this.JML_QC = jmlQc.getJML_QC();
        this.JML_CY = jmlCy.getJML_CY();
        this.JML_BQY = jmlBqy.getJML_BQY();
        this.JML_SX = jmlSx.getJML_SX();
        this.JML_SHX = jmlShx.getJML_SHX();
        this.JML_QHD = jmlQhd.getJML_QHD();
        this.JML_QT = jmlQt.getJML_QT();
        this.JML_LJ = jmlLj.getJML_LJ();
        this.JML_DRHY = jmlDrhy.getJML_DRHY();
        this.JML_LJHY = jmlLjhy.getJML_LJHY();
        this.JML_ZMKC = jmlZmkc.getJML_ZMKC();
        this.JML_KYKC = jmlKykc.getJML_KYKC();
        this.JML_ZRKC = jmlZrkc.getJML_ZRKC();
        this.JML_AVGTEN = jmlAvgten.getJML_AVGTEN();
        this.JML_RHML80FH = jmlRhml80FH.getJML_RHML80FH();
    }

    public FgsReportRow(FDL_DR fdlDr,
                        JML_DR jmlDr,
                        JML_HC jmlHc,
                        JML_QC jmlQc,
                        JML_CY jmlCy,
                        JML_LJ jmlLj,
                        JML_DRHY jmlDrhy,
                        JML_LJHY jmlLjhy,
                        JML_ZMKC jmlZmkc,
                        JML_KYKC jmlKykc,
                        JML_ZRKC jmlZrkc,
                        JML_AVGTEN jmlAvgten,
                        JML_RHML80FH jmlRhml80FH) {
        this.REGION_ID = fdlDr.getREGION_ID();
        this.REGION_NAME = fdlDr.getREGION_NAME();
        this.ENTITY_ORG_ID = fdlDr.getENTITY_ORG_ID();
        this.CMIS_COMPANY_NAME = fdlDr.getCMIS_COMPANY_NAME();
        this.FDL_DR = fdlDr.getFDL_DR();
        this.JML_DR = jmlDr.getJML_DR();
        this.JML_HC = jmlHc.getJML_HC();
        this.JML_QC = jmlQc.getJML_QC();
        this.JML_CY = jmlCy.getJML_CY();
        this.JML_LJ = jmlLj.getJML_LJ();
        this.JML_DRHY = jmlDrhy.getJML_DRHY();
        this.JML_LJHY = jmlLjhy.getJML_LJHY();
        this.JML_ZMKC = jmlZmkc.getJML_ZMKC();
        this.JML_KYKC = jmlKykc.getJML_KYKC();
        this.JML_ZRKC = jmlZrkc.getJML_ZRKC();
        this.JML_AVGTEN = jmlAvgten.getJML_AVGTEN();
        this.JML_RHML80FH = jmlRhml80FH.getJML_RHML80FH();
    }
    public String getREGION_ID() {
        return REGION_ID;
    }

    public void setREGION_ID(String REGION_ID) {
        this.REGION_ID = REGION_ID;
    }

    public String getREGION_NAME() {
        return REGION_NAME;
    }

    public void setREGION_NAME(String REGION_NAME) {
        this.REGION_NAME = REGION_NAME;
    }

    public String getENTITY_ORG_ID() {
        return ENTITY_ORG_ID;
    }

    public void setENTITY_ORG_ID(String ENTITY_ORG_ID) {
        this.ENTITY_ORG_ID = ENTITY_ORG_ID;
    }

    public String getCMIS_COMPANY_NAME() {
        return CMIS_COMPANY_NAME;
    }

    public void setCMIS_COMPANY_NAME(String CMIS_COMPANY_NAME) {
        this.CMIS_COMPANY_NAME = CMIS_COMPANY_NAME;
    }

    public int getMERGE_NUM() {
        return MERGE_NUM;
    }

    public void setMERGE_NUM(int MERGE_NUM) {
        this.MERGE_NUM = MERGE_NUM;
    }

    public String getFDL_DR() {
        return FDL_DR;
    }

    public void setFDL_DR(String FDL_DR) {
        this.FDL_DR = FDL_DR;
    }

    public String getJML_DR() {
        return JML_DR;
    }

    public void setJML_DR(String JML_DR) {
        this.JML_DR = JML_DR;
    }

    public String getJML_HC() {
        return JML_HC;
    }

    public void setJML_HC(String JML_HC) {
        this.JML_HC = JML_HC;
    }

    public String getJML_QC() {
        return JML_QC;
    }

    public void setJML_QC(String JML_QC) {
        this.JML_QC = JML_QC;
    }

    public String getJML_CY() {
        return JML_CY;
    }

    public void setJML_CY(String JML_CY) {
        this.JML_CY = JML_CY;
    }

    public String getJML_BQY() {
        return JML_BQY;
    }

    public void setJML_BQY(String JML_BQY) {
        this.JML_BQY = JML_BQY;
    }

    public String getJML_SX() {
        return JML_SX;
    }

    public void setJML_SX(String JML_SX) {
        this.JML_SX = JML_SX;
    }

    public String getJML_SHX() {
        return JML_SHX;
    }

    public void setJML_SHX(String JML_SHX) {
        this.JML_SHX = JML_SHX;
    }

    public String getJML_QHD() {
        return JML_QHD;
    }

    public void setJML_QHD(String JML_QHD) {
        this.JML_QHD = JML_QHD;
    }

    public String getJML_QT() {
        return JML_QT;
    }

    public void setJML_QT(String JML_QT) {
        this.JML_QT = JML_QT;
    }

    public String getJML_LJ() {
        return JML_LJ;
    }

    public void setJML_LJ(String JML_LJ) {
        this.JML_LJ = JML_LJ;
    }

    public String getJML_DRHY() {
        return JML_DRHY;
    }

    public void setJML_DRHY(String JML_DRHY) {
        this.JML_DRHY = JML_DRHY;
    }

    public String getJML_LJHY() {
        return JML_LJHY;
    }

    public void setJML_LJHY(String JML_LJHY) {
        this.JML_LJHY = JML_LJHY;
    }

    public String getJML_ZMKC() {
        return JML_ZMKC;
    }

    public void setJML_ZMKC(String JML_ZMKC) {
        this.JML_ZMKC = JML_ZMKC;
    }

    public String getJML_KYKC() {
        return JML_KYKC;
    }

    public void setJML_KYKC(String JML_KYKC) {
        this.JML_KYKC = JML_KYKC;
    }

    public String getJML_ZRKC() {
        return JML_ZRKC;
    }

    public void setJML_ZRKC(String JML_ZRKC) {
        this.JML_ZRKC = JML_ZRKC;
    }

    public String getJML_AVGTEN() {
        return JML_AVGTEN;
    }

    public void setJML_AVGTEN(String JML_AVGTEN) {
        this.JML_AVGTEN = JML_AVGTEN;
    }

    public String getJML_RHML80FH() {
        return JML_RHML80FH;
    }

    public void setJML_RHML80FH(String JML_RHML80FH) {
        this.JML_RHML80FH = JML_RHML80FH;
    }
}
