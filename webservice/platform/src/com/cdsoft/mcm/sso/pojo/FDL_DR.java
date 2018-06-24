package com.cdsoft.mcm.sso.pojo;

/**
 * 当日发电量
 */
public class FDL_DR {
    private String FDL_DR;//当日发电量
    private String REGION_ID;//区域ID ，如山东分公司 8335
    private String ENTITY_ORG_ID;//组织ID 如邹县电厂 130
    private String CMIS_COMPANY_NAME;//电厂名称，如邹县电厂
    private String REGION_NAME;//分公司名称，如山东

    public FDL_DR() {
    }

    public String getFDL_DR() {
        return FDL_DR;
    }

    public void setFDL_DR(String FDL_DR) {
        this.FDL_DR = FDL_DR;
    }

    public String getREGION_ID() {
        return REGION_ID;
    }

    public void setREGION_ID(String REGION_ID) {
        this.REGION_ID = REGION_ID;
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

    public String getREGION_NAME() {
        return REGION_NAME;
    }

    public void setREGION_NAME(String REGION_NAME) {
        this.REGION_NAME = REGION_NAME;
    }
}
