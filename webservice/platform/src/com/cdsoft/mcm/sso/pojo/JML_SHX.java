package com.cdsoft.mcm.sso.pojo;

/**
 * 区域结构-陕西
 */
public class JML_SHX {
    private String REGION_ID;//区域ID ，如山东分公司 8335
    private String REGION_NAME;//分公司名称，如山东
    private String ENTITY_ORG_ID;//组织ID 如邹县电厂 130
    private String CMIS_COMPANY_NAME;//电厂名称，如邹县电厂
    private String JML_SHX;//区域结构-陕西

    public JML_SHX() {
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

    public String getJML_SHX() {
        return JML_SHX;
    }

    public void setJML_SHX(String JML_SHX) {
        this.JML_SHX = JML_SHX;
    }
}
