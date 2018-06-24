package com.cdsoft.mcm.sso.service.impl;

import com.cdsoft.mcm.sso.pojo.*;
import com.cdsoft.mcm.sso.service.IGhStorageReportService;
import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.transport.http.HTTPConstants;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

@Service
public class GhStorageReportServiceImpl implements IGhStorageReportService {
    private static final Logger logger = Logger.getLogger(GhStorageReportServiceImpl.class);
    private InputStream fis = null;
    private Properties config = new Properties();

    public GhStorageReportServiceImpl() {
        super();
        try {
            fis = GhStorageReportServiceImpl.class.getClassLoader().getResourceAsStream("/reportConfig.properties");
            config.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<FgsReportRow> queryFgsRkReport(String dateStr) {
        List<FgsReportRow> resultList = new ArrayList<>();
        String url = config.get("fgs.report.endPointUrl").toString();
        String securityUser = config.get("auth.user").toString();
        String securityPassword = config.get("auth.password").toString();
        try {
            Options options = new Options();
            // 指定调用WebService的URL
            EndpointReference targetEPR = new EndpointReference(url);
            options.setTimeOutInMilliSeconds(360 * 1000);
            options.setManageSession(true);
            options.setTo(targetEPR);

            ServiceClient sender = null;
            sender = new ServiceClient();
            sender.setOptions(options);
            sender.getOptions().setProperty(HTTPConstants.CHUNKED, false);
            sender.getOptions().setProperty(HTTPConstants.SO_TIMEOUT, 360 * 1000);
            sender.getOptions().setProperty(HTTPConstants.CONNECTION_TIMEOUT, 360 * 1000);
            sender.getOptions().setProperty(HTTPConstants.REUSE_HTTP_CLIENT, true);

            OMFactory fac = OMAbstractFactory.getOMFactory();

            //验证header，服务器需要验证才有这部分设置，否则无需添加
            String AUTH_PREFIX = "wsse";
            String AUTH_NS = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd";
            OMElement securityElement = fac.createOMElement("Security", AUTH_NS, AUTH_PREFIX);
            OMElement usernameTokenElement = fac.createOMElement("UsernameToken", AUTH_NS, AUTH_PREFIX);
            OMElement usernameElement = fac.createOMElement("Username", AUTH_NS, AUTH_PREFIX);
            usernameElement.setText(securityUser);
            OMElement passwordElement = fac.createOMElement("Password", AUTH_NS, AUTH_PREFIX);
            passwordElement.setText(securityPassword);
            usernameTokenElement.addChild(usernameElement);
            usernameTokenElement.addChild(passwordElement);
            securityElement.addChild(usernameTokenElement);
            sender.addHeader(securityElement);

            //调用存储过程
            String SOAP_NS = config.get("fgs.query.tns").toString();
            String VAL_AUTH_PREFIX = "quer";
            OMElement inputParametersElement = fac.createOMElement("InputParameters", SOAP_NS, VAL_AUTH_PREFIX);
            OMElement dateElement = fac.createOMElement("P_DATE_STR", SOAP_NS, VAL_AUTH_PREFIX);
            OMElement regionElement = fac.createOMElement("P_REGION_ID", SOAP_NS, VAL_AUTH_PREFIX);
            dateElement.setText(dateStr);
            regionElement.setText("8335");
            inputParametersElement.addChild(dateElement);
            inputParametersElement.addChild(regionElement);

            //根据查询参数，执行请求
            OMElement resultElement = sender.sendReceive(inputParametersElement);
            Iterator resultIterator = resultElement.getChildElements();
            List<FDL_DR> fdlDrList = new ArrayList<>();
            List<JML_DR> jmlDrList = new ArrayList<>();
            List<JML_HC> jmlHcList = new ArrayList<>();
            List<JML_QC> jmlQcList = new ArrayList<>();
            List<JML_CY> jmlCyList = new ArrayList<>();
            List<JML_BQY> jmlBqyList = new ArrayList<>();
            List<JML_SX> jmlSxList = new ArrayList<>();
            List<JML_SHX> jmlShxList = new ArrayList<>();
            List<JML_QHD> jmlQhdList = new ArrayList<>();
            List<JML_QT> jmlQtList = new ArrayList<>();
            List<JML_LJ> jmlLjList = new ArrayList<>();
            List<JML_DRHY> jmlDrhyList = new ArrayList<>();
            List<JML_LJHY> jmlLjhyList = new ArrayList<>();
            List<JML_ZMKC> jmlZmkcList = new ArrayList<>();
            List<JML_KYKC> jmlKykcList = new ArrayList<>();
            List<JML_ZRKC> jmlZrkcList = new ArrayList<>();
            List<JML_AVGTEN> jmlAvgtenList = new ArrayList<>();
            List<JML_RHML80FH> jmlRhml80FHList = new ArrayList<>();

            while (resultIterator.hasNext()) {
                OMElement element = (OMElement) resultIterator.next();
                if (element != null && "R_FDL_DR_COLUMN".equals(element.getLocalName())) {
                    FDL_DR drfdl = null;
                    Iterator fdlItemIterator = element.getChildElements();
                    while (fdlItemIterator.hasNext()) {
                        OMElement fdlElement = (OMElement) fdlItemIterator.next();
                        Iterator fdlIterator = fdlElement.getChildElements();
                        drfdl = new FDL_DR();
                        while (fdlIterator.hasNext()) {
                            OMElement e = (OMElement) fdlIterator.next();
                            if (e != null && "FDL_DR".equals(e.getLocalName())) {
                                drfdl.setFDL_DR(e.getText());
                            }
                            if (e != null && "REGION_ID".equals(e.getLocalName())) {
                                drfdl.setREGION_ID(e.getText());
                            }
                            if (e != null && "ENTITY_ORG_ID".equals(e.getLocalName())) {
                                drfdl.setENTITY_ORG_ID(e.getText());
                            }
                            if (e != null && "CMIS_COMPANY_NAME".equals(e.getLocalName())) {
                                drfdl.setCMIS_COMPANY_NAME(e.getText());
                            }
                            if (e != null && "REGION_NAME".equals(e.getLocalName())) {
                                drfdl.setREGION_NAME(e.getText());
                            }
                        }
                        fdlDrList.add(drfdl);
                    }
                } else if (element != null && ("R_JML_DR_COLUMN".equals(element.getLocalName()))) {
                    JML_DR drjml = null;
                    Iterator fdlItemIterator = element.getChildElements();
                    while (fdlItemIterator.hasNext()) {
                        OMElement fdlElement = (OMElement) fdlItemIterator.next();
                        Iterator fdlIterator = fdlElement.getChildElements();
                        drjml = new JML_DR();
                        while (fdlIterator.hasNext()) {
                            OMElement e = (OMElement) fdlIterator.next();
                            if (e != null && "JML_DR".equals(e.getLocalName())) {
                                drjml.setJML_DR(e.getText());
                            }
                            if (e != null && "REGION_ID".equals(e.getLocalName())) {
                                drjml.setREGION_ID(e.getText());
                            }
                            if (e != null && "ENTITY_ORG_ID".equals(e.getLocalName())) {
                                drjml.setENTITY_ORG_ID(e.getText());
                            }
                            if (e != null && "CMIS_COMPANY_NAME".equals(e.getLocalName())) {
                                drjml.setCMIS_COMPANY_NAME(e.getText());
                            }
                            if (e != null && "REGION_NAME".equals(e.getLocalName())) {
                                drjml.setREGION_NAME(e.getText());
                            }
                        }
                        jmlDrList.add(drjml);
                    }
                } else if (element != null && ("R_JML_DR_HC_COLUMN".equals(element.getLocalName()))) {
                    JML_HC jmlHc = null;
                    Iterator fdlItemIterator = element.getChildElements();
                    while (fdlItemIterator.hasNext()) {
                        OMElement fdlElement = (OMElement) fdlItemIterator.next();
                        Iterator fdlIterator = fdlElement.getChildElements();
                        jmlHc = new JML_HC();
                        while (fdlIterator.hasNext()) {
                            OMElement e = (OMElement) fdlIterator.next();
                            if (e != null && "JML_DR".equals(e.getLocalName())) {
                                jmlHc.setJML_HC(e.getText());
                            }
                            if (e != null && "REGION_ID".equals(e.getLocalName())) {
                                jmlHc.setREGION_ID(e.getText());
                            }
                            if (e != null && "ENTITY_ORG_ID".equals(e.getLocalName())) {
                                jmlHc.setENTITY_ORG_ID(e.getText());
                            }
                            if (e != null && "CMIS_COMPANY_NAME".equals(e.getLocalName())) {
                                jmlHc.setCMIS_COMPANY_NAME(e.getText());
                            }
                            if (e != null && "REGION_NAME".equals(e.getLocalName())) {
                                jmlHc.setREGION_NAME(e.getText());
                            }
                        }
                        jmlHcList.add(jmlHc);
                    }
                } else if (element != null && ("R_JML_DR_QC_COLUMN".equals(element.getLocalName()))) {
                    JML_QC jmlQc = null;
                    Iterator fdlItemIterator = element.getChildElements();
                    while (fdlItemIterator.hasNext()) {
                        OMElement fdlElement = (OMElement) fdlItemIterator.next();
                        Iterator fdlIterator = fdlElement.getChildElements();
                        jmlQc = new JML_QC();
                        while (fdlIterator.hasNext()) {
                            OMElement e = (OMElement) fdlIterator.next();
                            if (e != null && "JML_DR".equals(e.getLocalName())) {
                                jmlQc.setJML_QC(e.getText());
                            }
                            if (e != null && "REGION_ID".equals(e.getLocalName())) {
                                jmlQc.setREGION_ID(e.getText());
                            }
                            if (e != null && "ENTITY_ORG_ID".equals(e.getLocalName())) {
                                jmlQc.setENTITY_ORG_ID(e.getText());
                            }
                            if (e != null && "CMIS_COMPANY_NAME".equals(e.getLocalName())) {
                                jmlQc.setCMIS_COMPANY_NAME(e.getText());
                            }
                            if (e != null && "REGION_NAME".equals(e.getLocalName())) {
                                jmlQc.setREGION_NAME(e.getText());
                            }
                        }
                        jmlQcList.add(jmlQc);
                    }
                } else if (element != null && ("R_JML_DR_CY_COLUMN".equals(element.getLocalName()))) {
                    JML_CY jmlCy = null;
                    Iterator fdlItemIterator = element.getChildElements();
                    while (fdlItemIterator.hasNext()) {
                        OMElement fdlElement = (OMElement) fdlItemIterator.next();
                        Iterator fdlIterator = fdlElement.getChildElements();
                        jmlCy = new JML_CY();
                        while (fdlIterator.hasNext()) {
                            OMElement e = (OMElement) fdlIterator.next();
                            if (e != null && "JML_DR".equals(e.getLocalName())) {
                                jmlCy.setJML_CY(e.getText());
                            }
                            if (e != null && "REGION_ID".equals(e.getLocalName())) {
                                jmlCy.setREGION_ID(e.getText());
                            }
                            if (e != null && "ENTITY_ORG_ID".equals(e.getLocalName())) {
                                jmlCy.setENTITY_ORG_ID(e.getText());
                            }
                            if (e != null && "CMIS_COMPANY_NAME".equals(e.getLocalName())) {
                                jmlCy.setCMIS_COMPANY_NAME(e.getText());
                            }
                            if (e != null && "REGION_NAME".equals(e.getLocalName())) {
                                jmlCy.setREGION_NAME(e.getText());
                            }
                        }
                        jmlCyList.add(jmlCy);
                    }
                } else if (element != null && ("R_JML_DR_BQY_COLUMN".equals(element.getLocalName()))) {
                    JML_BQY jmlBqy = null;
                    Iterator fdlItemIterator = element.getChildElements();
                    while (fdlItemIterator.hasNext()) {
                        OMElement fdlElement = (OMElement) fdlItemIterator.next();
                        Iterator fdlIterator = fdlElement.getChildElements();
                        jmlBqy = new JML_BQY();
                        while (fdlIterator.hasNext()) {
                            OMElement e = (OMElement) fdlIterator.next();
                            if (e != null && "JML_DR".equals(e.getLocalName())) {
                                jmlBqy.setJML_BQY(e.getText());
                            }
                            if (e != null && "REGION_ID".equals(e.getLocalName())) {
                                jmlBqy.setREGION_ID(e.getText());
                            }
                            if (e != null && "ENTITY_ORG_ID".equals(e.getLocalName())) {
                                jmlBqy.setENTITY_ORG_ID(e.getText());
                            }
                            if (e != null && "CMIS_COMPANY_NAME".equals(e.getLocalName())) {
                                jmlBqy.setCMIS_COMPANY_NAME(e.getText());
                            }
                            if (e != null && "REGION_NAME".equals(e.getLocalName())) {
                                jmlBqy.setREGION_NAME(e.getText());
                            }
                        }
                        jmlBqyList.add(jmlBqy);
                    }
                } else if (element != null && ("R_JML_DR_SX_COLUMN".equals(element.getLocalName()))) {
                    JML_SX jmlSx = null;
                    Iterator fdlItemIterator = element.getChildElements();
                    while (fdlItemIterator.hasNext()) {
                        OMElement fdlElement = (OMElement) fdlItemIterator.next();
                        Iterator fdlIterator = fdlElement.getChildElements();
                        jmlSx = new JML_SX();
                        while (fdlIterator.hasNext()) {
                            OMElement e = (OMElement) fdlIterator.next();
                            if (e != null && "JML_DR".equals(e.getLocalName())) {
                                jmlSx.setJML_SX(e.getText());
                            }
                            if (e != null && "REGION_ID".equals(e.getLocalName())) {
                                jmlSx.setREGION_ID(e.getText());
                            }
                            if (e != null && "ENTITY_ORG_ID".equals(e.getLocalName())) {
                                jmlSx.setENTITY_ORG_ID(e.getText());
                            }
                            if (e != null && "CMIS_COMPANY_NAME".equals(e.getLocalName())) {
                                jmlSx.setCMIS_COMPANY_NAME(e.getText());
                            }
                            if (e != null && "REGION_NAME".equals(e.getLocalName())) {
                                jmlSx.setREGION_NAME(e.getText());
                            }
                        }
                        jmlSxList.add(jmlSx);
                    }
                } else if (element != null && ("R_JML_DR_SHX_COLUMN".equals(element.getLocalName()))) {
                    JML_SHX jmlShx = null;
                    Iterator fdlItemIterator = element.getChildElements();
                    while (fdlItemIterator.hasNext()) {
                        OMElement fdlElement = (OMElement) fdlItemIterator.next();
                        Iterator fdlIterator = fdlElement.getChildElements();
                        jmlShx = new JML_SHX();
                        while (fdlIterator.hasNext()) {
                            OMElement e = (OMElement) fdlIterator.next();
                            if (e != null && "JML_DR".equals(e.getLocalName())) {
                                jmlShx.setJML_SHX(e.getText());
                            }
                            if (e != null && "REGION_ID".equals(e.getLocalName())) {
                                jmlShx.setREGION_ID(e.getText());
                            }
                            if (e != null && "ENTITY_ORG_ID".equals(e.getLocalName())) {
                                jmlShx.setENTITY_ORG_ID(e.getText());
                            }
                            if (e != null && "CMIS_COMPANY_NAME".equals(e.getLocalName())) {
                                jmlShx.setCMIS_COMPANY_NAME(e.getText());
                            }
                            if (e != null && "REGION_NAME".equals(e.getLocalName())) {
                                jmlShx.setREGION_NAME(e.getText());
                            }
                        }
                        jmlShxList.add(jmlShx);
                    }
                } else if (element != null && ("R_JML_DR_QHD_COLUMN".equals(element.getLocalName()))) {
                    JML_QHD jmlQhd = null;
                    Iterator fdlItemIterator = element.getChildElements();
                    while (fdlItemIterator.hasNext()) {
                        OMElement fdlElement = (OMElement) fdlItemIterator.next();
                        Iterator fdlIterator = fdlElement.getChildElements();
                        jmlQhd = new JML_QHD();
                        while (fdlIterator.hasNext()) {
                            OMElement e = (OMElement) fdlIterator.next();
                            if (e != null && "JML_DR".equals(e.getLocalName())) {
                                jmlQhd.setJML_QHD(e.getText());
                            }
                            if (e != null && "REGION_ID".equals(e.getLocalName())) {
                                jmlQhd.setREGION_ID(e.getText());
                            }
                            if (e != null && "ENTITY_ORG_ID".equals(e.getLocalName())) {
                                jmlQhd.setENTITY_ORG_ID(e.getText());
                            }
                            if (e != null && "CMIS_COMPANY_NAME".equals(e.getLocalName())) {
                                jmlQhd.setCMIS_COMPANY_NAME(e.getText());
                            }
                            if (e != null && "REGION_NAME".equals(e.getLocalName())) {
                                jmlQhd.setREGION_NAME(e.getText());
                            }
                        }
                        jmlQhdList.add(jmlQhd);
                    }
                } else if (element != null && ("R_JML_DR_QT_COLUMN".equals(element.getLocalName()))) {
                    JML_QT jmlQt = null;
                    Iterator fdlItemIterator = element.getChildElements();
                    while (fdlItemIterator.hasNext()) {
                        OMElement fdlElement = (OMElement) fdlItemIterator.next();
                        Iterator fdlIterator = fdlElement.getChildElements();
                        jmlQt = new JML_QT();
                        while (fdlIterator.hasNext()) {
                            OMElement e = (OMElement) fdlIterator.next();
                            if (e != null && "JML_DR".equals(e.getLocalName())) {
                                jmlQt.setJML_QT(e.getText());
                            }
                            if (e != null && "REGION_ID".equals(e.getLocalName())) {
                                jmlQt.setREGION_ID(e.getText());
                            }
                            if (e != null && "ENTITY_ORG_ID".equals(e.getLocalName())) {
                                jmlQt.setENTITY_ORG_ID(e.getText());
                            }
                            if (e != null && "CMIS_COMPANY_NAME".equals(e.getLocalName())) {
                                jmlQt.setCMIS_COMPANY_NAME(e.getText());
                            }
                            if (e != null && "REGION_NAME".equals(e.getLocalName())) {
                                jmlQt.setREGION_NAME(e.getText());
                            }
                        }
                        jmlQtList.add(jmlQt);
                    }
                } else if (element != null && ("R_JML_LJ_COLUMN".equals(element.getLocalName()))) {
                    JML_LJ jmlLj = null;
                    Iterator fdlItemIterator = element.getChildElements();
                    while (fdlItemIterator.hasNext()) {
                        OMElement fdlElement = (OMElement) fdlItemIterator.next();
                        Iterator fdlIterator = fdlElement.getChildElements();
                        jmlLj = new JML_LJ();
                        while (fdlIterator.hasNext()) {
                            OMElement e = (OMElement) fdlIterator.next();
                            if (e != null && "JML_DR".equals(e.getLocalName())) {
                                jmlLj.setJML_LJ(e.getText());
                            }
                            if (e != null && "REGION_ID".equals(e.getLocalName())) {
                                jmlLj.setREGION_ID(e.getText());
                            }
                            if (e != null && "ENTITY_ORG_ID".equals(e.getLocalName())) {
                                jmlLj.setENTITY_ORG_ID(e.getText());
                            }
                            if (e != null && "CMIS_COMPANY_NAME".equals(e.getLocalName())) {
                                jmlLj.setCMIS_COMPANY_NAME(e.getText());
                            }
                            if (e != null && "REGION_NAME".equals(e.getLocalName())) {
                                jmlLj.setREGION_NAME(e.getText());
                            }
                        }
                        jmlLjList.add(jmlLj);
                    }
                } else if (element != null && ("R_JML_DRHY_COLUMN".equals(element.getLocalName()))) {
                    JML_DRHY jmlDrhy = null;
                    Iterator fdlItemIterator = element.getChildElements();
                    while (fdlItemIterator.hasNext()) {
                        OMElement fdlElement = (OMElement) fdlItemIterator.next();
                        Iterator fdlIterator = fdlElement.getChildElements();
                        jmlDrhy = new JML_DRHY();
                        while (fdlIterator.hasNext()) {
                            OMElement e = (OMElement) fdlIterator.next();
                            if (e != null && "JML_DR".equals(e.getLocalName())) {
                                jmlDrhy.setJML_DRHY(e.getText());
                            }
                            if (e != null && "REGION_ID".equals(e.getLocalName())) {
                                jmlDrhy.setREGION_ID(e.getText());
                            }
                            if (e != null && "ENTITY_ORG_ID".equals(e.getLocalName())) {
                                jmlDrhy.setENTITY_ORG_ID(e.getText());
                            }
                            if (e != null && "CMIS_COMPANY_NAME".equals(e.getLocalName())) {
                                jmlDrhy.setCMIS_COMPANY_NAME(e.getText());
                            }
                            if (e != null && "REGION_NAME".equals(e.getLocalName())) {
                                jmlDrhy.setREGION_NAME(e.getText());
                            }
                        }
                        jmlDrhyList.add(jmlDrhy);
                    }
                } else if (element != null && ("R_JML_LJHY_COLUMN".equals(element.getLocalName()))) {
                    JML_LJHY jmlLjhy = null;
                    Iterator fdlItemIterator = element.getChildElements();
                    while (fdlItemIterator.hasNext()) {
                        OMElement fdlElement = (OMElement) fdlItemIterator.next();
                        Iterator fdlIterator = fdlElement.getChildElements();
                        jmlLjhy = new JML_LJHY();
                        while (fdlIterator.hasNext()) {
                            OMElement e = (OMElement) fdlIterator.next();
                            if (e != null && "JML_DR".equals(e.getLocalName())) {
                                jmlLjhy.setJML_LJHY(e.getText());
                            }
                            if (e != null && "REGION_ID".equals(e.getLocalName())) {
                                jmlLjhy.setREGION_ID(e.getText());
                            }
                            if (e != null && "ENTITY_ORG_ID".equals(e.getLocalName())) {
                                jmlLjhy.setENTITY_ORG_ID(e.getText());
                            }
                            if (e != null && "CMIS_COMPANY_NAME".equals(e.getLocalName())) {
                                jmlLjhy.setCMIS_COMPANY_NAME(e.getText());
                            }
                            if (e != null && "REGION_NAME".equals(e.getLocalName())) {
                                jmlLjhy.setREGION_NAME(e.getText());
                            }
                        }
                        jmlLjhyList.add(jmlLjhy);
                    }
                } else if (element != null && ("R_JML_ZMKC_COLUMN".equals(element.getLocalName()))) {
                    JML_ZMKC jmlZmkc = null;
                    Iterator fdlItemIterator = element.getChildElements();
                    while (fdlItemIterator.hasNext()) {
                        OMElement fdlElement = (OMElement) fdlItemIterator.next();
                        Iterator fdlIterator = fdlElement.getChildElements();
                        jmlZmkc = new JML_ZMKC();
                        while (fdlIterator.hasNext()) {
                            OMElement e = (OMElement) fdlIterator.next();
                            if (e != null && "JML_DR".equals(e.getLocalName())) {
                                jmlZmkc.setJML_ZMKC(e.getText());
                            }
                            if (e != null && "REGION_ID".equals(e.getLocalName())) {
                                jmlZmkc.setREGION_ID(e.getText());
                            }
                            if (e != null && "ENTITY_ORG_ID".equals(e.getLocalName())) {
                                jmlZmkc.setENTITY_ORG_ID(e.getText());
                            }
                            if (e != null && "CMIS_COMPANY_NAME".equals(e.getLocalName())) {
                                jmlZmkc.setCMIS_COMPANY_NAME(e.getText());
                            }
                            if (e != null && "REGION_NAME".equals(e.getLocalName())) {
                                jmlZmkc.setREGION_NAME(e.getText());
                            }
                        }
                        jmlZmkcList.add(jmlZmkc);
                    }
                } else if (element != null && ("R_JML_KYKC_COLUMN".equals(element.getLocalName()))) {
                    JML_KYKC jmlKykc = null;
                    Iterator fdlItemIterator = element.getChildElements();
                    while (fdlItemIterator.hasNext()) {
                        OMElement fdlElement = (OMElement) fdlItemIterator.next();
                        Iterator fdlIterator = fdlElement.getChildElements();
                        jmlKykc = new JML_KYKC();
                        while (fdlIterator.hasNext()) {
                            OMElement e = (OMElement) fdlIterator.next();
                            if (e != null && "JML_DR".equals(e.getLocalName())) {
                                jmlKykc.setJML_KYKC(e.getText());
                            }
                            if (e != null && "REGION_ID".equals(e.getLocalName())) {
                                jmlKykc.setREGION_ID(e.getText());
                            }
                            if (e != null && "ENTITY_ORG_ID".equals(e.getLocalName())) {
                                jmlKykc.setENTITY_ORG_ID(e.getText());
                            }
                            if (e != null && "CMIS_COMPANY_NAME".equals(e.getLocalName())) {
                                jmlKykc.setCMIS_COMPANY_NAME(e.getText());
                            }
                            if (e != null && "REGION_NAME".equals(e.getLocalName())) {
                                jmlKykc.setREGION_NAME(e.getText());
                            }
                        }
                        jmlKykcList.add(jmlKykc);
                    }
                } else if (element != null && ("R_JML_ZRKC_COLUMN".equals(element.getLocalName()))) {
                    JML_ZRKC jmlZrkc = null;
                    Iterator fdlItemIterator = element.getChildElements();
                    while (fdlItemIterator.hasNext()) {
                        OMElement fdlElement = (OMElement) fdlItemIterator.next();
                        Iterator fdlIterator = fdlElement.getChildElements();
                        jmlZrkc = new JML_ZRKC();
                        while (fdlIterator.hasNext()) {
                            OMElement e = (OMElement) fdlIterator.next();
                            if (e != null && "JML_DR".equals(e.getLocalName())) {
                                jmlZrkc.setJML_ZRKC(e.getText());
                            }
                            if (e != null && "REGION_ID".equals(e.getLocalName())) {
                                jmlZrkc.setREGION_ID(e.getText());
                            }
                            if (e != null && "ENTITY_ORG_ID".equals(e.getLocalName())) {
                                jmlZrkc.setENTITY_ORG_ID(e.getText());
                            }
                            if (e != null && "CMIS_COMPANY_NAME".equals(e.getLocalName())) {
                                jmlZrkc.setCMIS_COMPANY_NAME(e.getText());
                            }
                            if (e != null && "REGION_NAME".equals(e.getLocalName())) {
                                jmlZrkc.setREGION_NAME(e.getText());
                            }
                        }
                        jmlZrkcList.add(jmlZrkc);
                    }
                } else if (element != null && ("R_JML_AVGTEN_COLUMN".equals(element.getLocalName()))) {
                    JML_AVGTEN jmlAvgten = null;
                    Iterator fdlItemIterator = element.getChildElements();
                    while (fdlItemIterator.hasNext()) {
                        OMElement fdlElement = (OMElement) fdlItemIterator.next();
                        Iterator fdlIterator = fdlElement.getChildElements();
                        jmlAvgten = new JML_AVGTEN();
                        while (fdlIterator.hasNext()) {
                            OMElement e = (OMElement) fdlIterator.next();
                            if (e != null && "JML_DR".equals(e.getLocalName())) {
                                jmlAvgten.setJML_AVGTEN(e.getText());
                            }
                            if (e != null && "REGION_ID".equals(e.getLocalName())) {
                                jmlAvgten.setREGION_ID(e.getText());
                            }
                            if (e != null && "ENTITY_ORG_ID".equals(e.getLocalName())) {
                                jmlAvgten.setENTITY_ORG_ID(e.getText());
                            }
                            if (e != null && "CMIS_COMPANY_NAME".equals(e.getLocalName())) {
                                jmlAvgten.setCMIS_COMPANY_NAME(e.getText());
                            }
                            if (e != null && "REGION_NAME".equals(e.getLocalName())) {
                                jmlAvgten.setREGION_NAME(e.getText());
                            }
                        }
                        jmlAvgtenList.add(jmlAvgten);
                    }
                } else if (element != null && ("R_JML_RHML80FH_COLUMN".equals(element.getLocalName()))) {
                    JML_RHML80FH jmlRhml80FH = null;
                    Iterator fdlItemIterator = element.getChildElements();
                    while (fdlItemIterator.hasNext()) {
                        OMElement fdlElement = (OMElement) fdlItemIterator.next();
                        Iterator fdlIterator = fdlElement.getChildElements();
                        jmlRhml80FH = new JML_RHML80FH();
                        while (fdlIterator.hasNext()) {
                            OMElement e = (OMElement) fdlIterator.next();
                            if (e != null && "JML_DR".equals(e.getLocalName())) {
                                jmlRhml80FH.setJML_RHML80FH(e.getText());
                            }
                            if (e != null && "REGION_ID".equals(e.getLocalName())) {
                                jmlRhml80FH.setREGION_ID(e.getText());
                            }
                            if (e != null && "ENTITY_ORG_ID".equals(e.getLocalName())) {
                                jmlRhml80FH.setENTITY_ORG_ID(e.getText());
                            }
                            if (e != null && "CMIS_COMPANY_NAME".equals(e.getLocalName())) {
                                jmlRhml80FH.setCMIS_COMPANY_NAME(e.getText());
                            }
                            if (e != null && "REGION_NAME".equals(e.getLocalName())) {
                                jmlRhml80FH.setREGION_NAME(e.getText());
                            }
                        }
                        jmlRhml80FHList.add(jmlRhml80FH);
                    }
                }
            }

            if (fdlDrList != null && fdlDrList.size() > 0) {
                FgsReportRow fgsReportRow = null;
                for (int i = 0; i < fdlDrList.size(); i++) {
                    fgsReportRow = new FgsReportRow(fdlDrList.get(i),
                            jmlDrList.get(i),
                            jmlHcList.get(i),
                            jmlQcList.get(i),
                            jmlCyList.get(i),
                            jmlBqyList.get(i),
                            jmlSxList.get(i),
                            jmlShxList.get(i),
                            jmlQhdList.get(i),
                            jmlQtList.get(i),
                            jmlLjList.get(i),
                            jmlDrhyList.get(i),
                            jmlLjhyList.get(i),
                            jmlZmkcList.get(i),
                            jmlKykcList.get(i),
                            jmlZrkcList.get(i),
                            jmlAvgtenList.get(i),
                            jmlRhml80FHList.get(i));
                    if (fgsReportRow.getCMIS_COMPANY_NAME().equals("上市口径合计") || fgsReportRow.getCMIS_COMPANY_NAME().equals("代管口径合计")
                            || fgsReportRow.getCMIS_COMPANY_NAME().equals("上市+代管合计")) {
                        fgsReportRow.setMERGE_NUM(1);
                    }
                    resultList.add(fgsReportRow);
                }
            }
        } catch (AxisFault axisFault) {
            axisFault.printStackTrace();
        }
        return resultList;
    }

    @Override
    public List<FgsReportRow> queryFgsGhReport(String dateString) {
        List<FgsReportRow> resultList = new ArrayList<>();
        String url = config.get("fgs.report.endPointUrl").toString();
        String securityUser = config.get("auth.user").toString();
        String securityPassword = config.get("auth.password").toString();
        try {
            Options options = new Options();
            // 指定调用WebService的URL
            EndpointReference targetEPR = new EndpointReference(url);
            options.setTimeOutInMilliSeconds(360 * 1000);
            options.setManageSession(true);
            options.setTo(targetEPR);

            ServiceClient sender = null;
            sender = new ServiceClient();
            sender.setOptions(options);
            sender.getOptions().setProperty(HTTPConstants.CHUNKED, false);
            sender.getOptions().setProperty(HTTPConstants.SO_TIMEOUT, 360 * 1000);
            sender.getOptions().setProperty(HTTPConstants.CONNECTION_TIMEOUT, 360 * 1000);
            sender.getOptions().setProperty(HTTPConstants.REUSE_HTTP_CLIENT, true);

            OMFactory fac = OMAbstractFactory.getOMFactory();

            //验证header，服务器需要验证才有这部分设置，否则无需添加
            String AUTH_PREFIX = "wsse";
            String AUTH_NS = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd";
            OMElement securityElement = fac.createOMElement("Security", AUTH_NS, AUTH_PREFIX);
            OMElement usernameTokenElement = fac.createOMElement("UsernameToken", AUTH_NS, AUTH_PREFIX);
            OMElement usernameElement = fac.createOMElement("Username", AUTH_NS, AUTH_PREFIX);
            usernameElement.setText(securityUser);
            OMElement passwordElement = fac.createOMElement("Password", AUTH_NS, AUTH_PREFIX);
            passwordElement.setText(securityPassword);
            usernameTokenElement.addChild(usernameElement);
            usernameTokenElement.addChild(passwordElement);
            securityElement.addChild(usernameTokenElement);
            sender.addHeader(securityElement);

            //调用存储过程
            String SOAP_NS = config.getProperty("fgs.gh.query.tns").toString();
            String VAL_AUTH_PREFIX = "quer";
            OMElement inputParametersElement = fac.createOMElement("InputParameters", SOAP_NS, VAL_AUTH_PREFIX);
            OMElement dateElement = fac.createOMElement("P_DATE_STR", SOAP_NS, VAL_AUTH_PREFIX);
            OMElement regionElement = fac.createOMElement("P_REGION_ID", SOAP_NS, VAL_AUTH_PREFIX);
            dateElement.setText(dateString);
            regionElement.setText("8335");
            inputParametersElement.addChild(dateElement);
            inputParametersElement.addChild(regionElement);

            //根据查询参数，执行请求
            OMElement resultElement = sender.sendReceive(inputParametersElement);
            Iterator resultIterator = resultElement.getChildElements();
            List<FDL_DR> fdlDrList = new ArrayList<>();
            List<JML_DR> jmlDrList = new ArrayList<>();
            List<JML_HC> jmlHcList = new ArrayList<>();
            List<JML_QC> jmlQcList = new ArrayList<>();
            List<JML_CY> jmlCyList = new ArrayList<>();
            List<JML_LJ> jmlLjList = new ArrayList<>();
            List<JML_DRHY> jmlDrhyList = new ArrayList<>();
            List<JML_LJHY> jmlLjhyList = new ArrayList<>();
            List<JML_ZMKC> jmlZmkcList = new ArrayList<>();
            List<JML_KYKC> jmlKykcList = new ArrayList<>();
            List<JML_ZRKC> jmlZrkcList = new ArrayList<>();
            List<JML_AVGTEN> jmlAvgtenList = new ArrayList<>();
            List<JML_RHML80FH> jmlRhml80FHList = new ArrayList<>();

            while (resultIterator.hasNext()) {
                OMElement element = (OMElement) resultIterator.next();
                if (element != null && "R_FDL_DR_GH_COLUMN".equals(element.getLocalName())) {
                    FDL_DR drfdl = null;
                    Iterator fdlItemIterator = element.getChildElements();
                    while (fdlItemIterator.hasNext()) {
                        OMElement fdlElement = (OMElement) fdlItemIterator.next();
                        Iterator fdlIterator = fdlElement.getChildElements();
                        drfdl = new FDL_DR();
                        while (fdlIterator.hasNext()) {
                            OMElement e = (OMElement) fdlIterator.next();
                            if (e != null && "FDL_DR".equals(e.getLocalName())) {
                                drfdl.setFDL_DR(e.getText());
                            }
                            if (e != null && "REGION_ID".equals(e.getLocalName())) {
                                drfdl.setREGION_ID(e.getText());
                            }
                            if (e != null && "ENTITY_ORG_ID".equals(e.getLocalName())) {
                                drfdl.setENTITY_ORG_ID(e.getText());
                            }
                            if (e != null && "CMIS_COMPANY_NAME".equals(e.getLocalName())) {
                                drfdl.setCMIS_COMPANY_NAME(e.getText());
                            }
                            if (e != null && "REGION_NAME".equals(e.getLocalName())) {
                                drfdl.setREGION_NAME(e.getText());
                            }
                        }
                        fdlDrList.add(drfdl);
                    }
                } else if (element != null && ("R_JML_DR_GH_COLUMN".equals(element.getLocalName()))) {
                    JML_DR drjml = null;
                    Iterator fdlItemIterator = element.getChildElements();
                    while (fdlItemIterator.hasNext()) {
                        OMElement fdlElement = (OMElement) fdlItemIterator.next();
                        Iterator fdlIterator = fdlElement.getChildElements();
                        drjml = new JML_DR();
                        while (fdlIterator.hasNext()) {
                            OMElement e = (OMElement) fdlIterator.next();
                            if (e != null && "JML_DR".equals(e.getLocalName())) {
                                drjml.setJML_DR(e.getText());
                            }
                            if (e != null && "REGION_ID".equals(e.getLocalName())) {
                                drjml.setREGION_ID(e.getText());
                            }
                            if (e != null && "ENTITY_ORG_ID".equals(e.getLocalName())) {
                                drjml.setENTITY_ORG_ID(e.getText());
                            }
                            if (e != null && "CMIS_COMPANY_NAME".equals(e.getLocalName())) {
                                drjml.setCMIS_COMPANY_NAME(e.getText());
                            }
                            if (e != null && "REGION_NAME".equals(e.getLocalName())) {
                                drjml.setREGION_NAME(e.getText());
                            }
                        }
                        jmlDrList.add(drjml);
                    }
                } else if (element != null && ("R_JML_DR_HC_GH_COLUMN".equals(element.getLocalName()))) {
                    JML_HC jmlHc = null;
                    Iterator fdlItemIterator = element.getChildElements();
                    while (fdlItemIterator.hasNext()) {
                        OMElement fdlElement = (OMElement) fdlItemIterator.next();
                        Iterator fdlIterator = fdlElement.getChildElements();
                        jmlHc = new JML_HC();
                        while (fdlIterator.hasNext()) {
                            OMElement e = (OMElement) fdlIterator.next();
                            if (e != null && "JML_DR".equals(e.getLocalName())) {
                                jmlHc.setJML_HC(e.getText());
                            }
                            if (e != null && "REGION_ID".equals(e.getLocalName())) {
                                jmlHc.setREGION_ID(e.getText());
                            }
                            if (e != null && "ENTITY_ORG_ID".equals(e.getLocalName())) {
                                jmlHc.setENTITY_ORG_ID(e.getText());
                            }
                            if (e != null && "CMIS_COMPANY_NAME".equals(e.getLocalName())) {
                                jmlHc.setCMIS_COMPANY_NAME(e.getText());
                            }
                            if (e != null && "REGION_NAME".equals(e.getLocalName())) {
                                jmlHc.setREGION_NAME(e.getText());
                            }
                        }
                        jmlHcList.add(jmlHc);
                    }
                } else if (element != null && ("R_JML_DR_QC_GH_COLUMN".equals(element.getLocalName()))) {
                    JML_QC jmlQc = null;
                    Iterator fdlItemIterator = element.getChildElements();
                    while (fdlItemIterator.hasNext()) {
                        OMElement fdlElement = (OMElement) fdlItemIterator.next();
                        Iterator fdlIterator = fdlElement.getChildElements();
                        jmlQc = new JML_QC();
                        while (fdlIterator.hasNext()) {
                            OMElement e = (OMElement) fdlIterator.next();
                            if (e != null && "JML_DR".equals(e.getLocalName())) {
                                jmlQc.setJML_QC(e.getText());
                            }
                            if (e != null && "REGION_ID".equals(e.getLocalName())) {
                                jmlQc.setREGION_ID(e.getText());
                            }
                            if (e != null && "ENTITY_ORG_ID".equals(e.getLocalName())) {
                                jmlQc.setENTITY_ORG_ID(e.getText());
                            }
                            if (e != null && "CMIS_COMPANY_NAME".equals(e.getLocalName())) {
                                jmlQc.setCMIS_COMPANY_NAME(e.getText());
                            }
                            if (e != null && "REGION_NAME".equals(e.getLocalName())) {
                                jmlQc.setREGION_NAME(e.getText());
                            }
                        }
                        jmlQcList.add(jmlQc);
                    }
                } else if (element != null && ("R_JML_DR_CY_GH_COLUMN".equals(element.getLocalName()))) {
                    JML_CY jmlCy = null;
                    Iterator fdlItemIterator = element.getChildElements();
                    while (fdlItemIterator.hasNext()) {
                        OMElement fdlElement = (OMElement) fdlItemIterator.next();
                        Iterator fdlIterator = fdlElement.getChildElements();
                        jmlCy = new JML_CY();
                        while (fdlIterator.hasNext()) {
                            OMElement e = (OMElement) fdlIterator.next();
                            if (e != null && "JML_DR".equals(e.getLocalName())) {
                                jmlCy.setJML_CY(e.getText());
                            }
                            if (e != null && "REGION_ID".equals(e.getLocalName())) {
                                jmlCy.setREGION_ID(e.getText());
                            }
                            if (e != null && "ENTITY_ORG_ID".equals(e.getLocalName())) {
                                jmlCy.setENTITY_ORG_ID(e.getText());
                            }
                            if (e != null && "CMIS_COMPANY_NAME".equals(e.getLocalName())) {
                                jmlCy.setCMIS_COMPANY_NAME(e.getText());
                            }
                            if (e != null && "REGION_NAME".equals(e.getLocalName())) {
                                jmlCy.setREGION_NAME(e.getText());
                            }
                        }
                        jmlCyList.add(jmlCy);
                    }
                } else if (element != null && ("R_JML_LJ_GH_COLUMN".equals(element.getLocalName()))) {
                    JML_LJ jmlLj = null;
                    Iterator fdlItemIterator = element.getChildElements();
                    while (fdlItemIterator.hasNext()) {
                        OMElement fdlElement = (OMElement) fdlItemIterator.next();
                        Iterator fdlIterator = fdlElement.getChildElements();
                        jmlLj = new JML_LJ();
                        while (fdlIterator.hasNext()) {
                            OMElement e = (OMElement) fdlIterator.next();
                            if (e != null && "JML_DR".equals(e.getLocalName())) {
                                jmlLj.setJML_LJ(e.getText());
                            }
                            if (e != null && "REGION_ID".equals(e.getLocalName())) {
                                jmlLj.setREGION_ID(e.getText());
                            }
                            if (e != null && "ENTITY_ORG_ID".equals(e.getLocalName())) {
                                jmlLj.setENTITY_ORG_ID(e.getText());
                            }
                            if (e != null && "CMIS_COMPANY_NAME".equals(e.getLocalName())) {
                                jmlLj.setCMIS_COMPANY_NAME(e.getText());
                            }
                            if (e != null && "REGION_NAME".equals(e.getLocalName())) {
                                jmlLj.setREGION_NAME(e.getText());
                            }
                        }
                        jmlLjList.add(jmlLj);
                    }
                } else if (element != null && ("R_JML_DRHY_GH_COLUMN".equals(element.getLocalName()))) {
                    JML_DRHY jmlDrhy = null;
                    Iterator fdlItemIterator = element.getChildElements();
                    while (fdlItemIterator.hasNext()) {
                        OMElement fdlElement = (OMElement) fdlItemIterator.next();
                        Iterator fdlIterator = fdlElement.getChildElements();
                        jmlDrhy = new JML_DRHY();
                        while (fdlIterator.hasNext()) {
                            OMElement e = (OMElement) fdlIterator.next();
                            if (e != null && "JML_DR".equals(e.getLocalName())) {
                                jmlDrhy.setJML_DRHY(e.getText());
                            }
                            if (e != null && "REGION_ID".equals(e.getLocalName())) {
                                jmlDrhy.setREGION_ID(e.getText());
                            }
                            if (e != null && "ENTITY_ORG_ID".equals(e.getLocalName())) {
                                jmlDrhy.setENTITY_ORG_ID(e.getText());
                            }
                            if (e != null && "CMIS_COMPANY_NAME".equals(e.getLocalName())) {
                                jmlDrhy.setCMIS_COMPANY_NAME(e.getText());
                            }
                            if (e != null && "REGION_NAME".equals(e.getLocalName())) {
                                jmlDrhy.setREGION_NAME(e.getText());
                            }
                        }
                        jmlDrhyList.add(jmlDrhy);
                    }
                } else if (element != null && ("R_JML_LJHY_GH_COLUMN".equals(element.getLocalName()))) {
                    JML_LJHY jmlLjhy = null;
                    Iterator fdlItemIterator = element.getChildElements();
                    while (fdlItemIterator.hasNext()) {
                        OMElement fdlElement = (OMElement) fdlItemIterator.next();
                        Iterator fdlIterator = fdlElement.getChildElements();
                        jmlLjhy = new JML_LJHY();
                        while (fdlIterator.hasNext()) {
                            OMElement e = (OMElement) fdlIterator.next();
                            if (e != null && "JML_DR".equals(e.getLocalName())) {
                                jmlLjhy.setJML_LJHY(e.getText());
                            }
                            if (e != null && "REGION_ID".equals(e.getLocalName())) {
                                jmlLjhy.setREGION_ID(e.getText());
                            }
                            if (e != null && "ENTITY_ORG_ID".equals(e.getLocalName())) {
                                jmlLjhy.setENTITY_ORG_ID(e.getText());
                            }
                            if (e != null && "CMIS_COMPANY_NAME".equals(e.getLocalName())) {
                                jmlLjhy.setCMIS_COMPANY_NAME(e.getText());
                            }
                            if (e != null && "REGION_NAME".equals(e.getLocalName())) {
                                jmlLjhy.setREGION_NAME(e.getText());
                            }
                        }
                        jmlLjhyList.add(jmlLjhy);
                    }
                } else if (element != null && ("R_JML_ZMKC_GH_COLUMN".equals(element.getLocalName()))) {
                    JML_ZMKC jmlZmkc = null;
                    Iterator fdlItemIterator = element.getChildElements();
                    while (fdlItemIterator.hasNext()) {
                        OMElement fdlElement = (OMElement) fdlItemIterator.next();
                        Iterator fdlIterator = fdlElement.getChildElements();
                        jmlZmkc = new JML_ZMKC();
                        while (fdlIterator.hasNext()) {
                            OMElement e = (OMElement) fdlIterator.next();
                            if (e != null && "JML_DR".equals(e.getLocalName())) {
                                jmlZmkc.setJML_ZMKC(e.getText());
                            }
                            if (e != null && "REGION_ID".equals(e.getLocalName())) {
                                jmlZmkc.setREGION_ID(e.getText());
                            }
                            if (e != null && "ENTITY_ORG_ID".equals(e.getLocalName())) {
                                jmlZmkc.setENTITY_ORG_ID(e.getText());
                            }
                            if (e != null && "CMIS_COMPANY_NAME".equals(e.getLocalName())) {
                                jmlZmkc.setCMIS_COMPANY_NAME(e.getText());
                            }
                            if (e != null && "REGION_NAME".equals(e.getLocalName())) {
                                jmlZmkc.setREGION_NAME(e.getText());
                            }
                        }
                        jmlZmkcList.add(jmlZmkc);
                    }
                } else if (element != null && ("R_JML_KYKC_GH_COLUMN".equals(element.getLocalName()))) {
                    JML_KYKC jmlKykc = null;
                    Iterator fdlItemIterator = element.getChildElements();
                    while (fdlItemIterator.hasNext()) {
                        OMElement fdlElement = (OMElement) fdlItemIterator.next();
                        Iterator fdlIterator = fdlElement.getChildElements();
                        jmlKykc = new JML_KYKC();
                        while (fdlIterator.hasNext()) {
                            OMElement e = (OMElement) fdlIterator.next();
                            if (e != null && "JML_DR".equals(e.getLocalName())) {
                                jmlKykc.setJML_KYKC(e.getText());
                            }
                            if (e != null && "REGION_ID".equals(e.getLocalName())) {
                                jmlKykc.setREGION_ID(e.getText());
                            }
                            if (e != null && "ENTITY_ORG_ID".equals(e.getLocalName())) {
                                jmlKykc.setENTITY_ORG_ID(e.getText());
                            }
                            if (e != null && "CMIS_COMPANY_NAME".equals(e.getLocalName())) {
                                jmlKykc.setCMIS_COMPANY_NAME(e.getText());
                            }
                            if (e != null && "REGION_NAME".equals(e.getLocalName())) {
                                jmlKykc.setREGION_NAME(e.getText());
                            }
                        }
                        jmlKykcList.add(jmlKykc);
                    }
                } else if (element != null && ("R_JML_ZRKC_GH_COLUMN".equals(element.getLocalName()))) {
                    JML_ZRKC jmlZrkc = null;
                    Iterator fdlItemIterator = element.getChildElements();
                    while (fdlItemIterator.hasNext()) {
                        OMElement fdlElement = (OMElement) fdlItemIterator.next();
                        Iterator fdlIterator = fdlElement.getChildElements();
                        jmlZrkc = new JML_ZRKC();
                        while (fdlIterator.hasNext()) {
                            OMElement e = (OMElement) fdlIterator.next();
                            if (e != null && "JML_DR".equals(e.getLocalName())) {
                                jmlZrkc.setJML_ZRKC(e.getText());
                            }
                            if (e != null && "REGION_ID".equals(e.getLocalName())) {
                                jmlZrkc.setREGION_ID(e.getText());
                            }
                            if (e != null && "ENTITY_ORG_ID".equals(e.getLocalName())) {
                                jmlZrkc.setENTITY_ORG_ID(e.getText());
                            }
                            if (e != null && "CMIS_COMPANY_NAME".equals(e.getLocalName())) {
                                jmlZrkc.setCMIS_COMPANY_NAME(e.getText());
                            }
                            if (e != null && "REGION_NAME".equals(e.getLocalName())) {
                                jmlZrkc.setREGION_NAME(e.getText());
                            }
                        }
                        jmlZrkcList.add(jmlZrkc);
                    }
                } else if (element != null && ("R_JML_AVGTEN_GH_COLUMN".equals(element.getLocalName()))) {
                    JML_AVGTEN jmlAvgten = null;
                    Iterator fdlItemIterator = element.getChildElements();
                    while (fdlItemIterator.hasNext()) {
                        OMElement fdlElement = (OMElement) fdlItemIterator.next();
                        Iterator fdlIterator = fdlElement.getChildElements();
                        jmlAvgten = new JML_AVGTEN();
                        while (fdlIterator.hasNext()) {
                            OMElement e = (OMElement) fdlIterator.next();
                            if (e != null && "JML_DR".equals(e.getLocalName())) {
                                jmlAvgten.setJML_AVGTEN(e.getText());
                            }
                            if (e != null && "REGION_ID".equals(e.getLocalName())) {
                                jmlAvgten.setREGION_ID(e.getText());
                            }
                            if (e != null && "ENTITY_ORG_ID".equals(e.getLocalName())) {
                                jmlAvgten.setENTITY_ORG_ID(e.getText());
                            }
                            if (e != null && "CMIS_COMPANY_NAME".equals(e.getLocalName())) {
                                jmlAvgten.setCMIS_COMPANY_NAME(e.getText());
                            }
                            if (e != null && "REGION_NAME".equals(e.getLocalName())) {
                                jmlAvgten.setREGION_NAME(e.getText());
                            }
                        }
                        jmlAvgtenList.add(jmlAvgten);
                    }
                } else if (element != null && ("R_JML_RHML80FH_GH_COLUMN".equals(element.getLocalName()))) {
                    JML_RHML80FH jmlRhml80FH = null;
                    Iterator fdlItemIterator = element.getChildElements();
                    while (fdlItemIterator.hasNext()) {
                        OMElement fdlElement = (OMElement) fdlItemIterator.next();
                        Iterator fdlIterator = fdlElement.getChildElements();
                        jmlRhml80FH = new JML_RHML80FH();
                        while (fdlIterator.hasNext()) {
                            OMElement e = (OMElement) fdlIterator.next();
                            if (e != null && "JML_DR".equals(e.getLocalName())) {
                                jmlRhml80FH.setJML_RHML80FH(e.getText());
                            }
                            if (e != null && "REGION_ID".equals(e.getLocalName())) {
                                jmlRhml80FH.setREGION_ID(e.getText());
                            }
                            if (e != null && "ENTITY_ORG_ID".equals(e.getLocalName())) {
                                jmlRhml80FH.setENTITY_ORG_ID(e.getText());
                            }
                            if (e != null && "CMIS_COMPANY_NAME".equals(e.getLocalName())) {
                                jmlRhml80FH.setCMIS_COMPANY_NAME(e.getText());
                            }
                            if (e != null && "REGION_NAME".equals(e.getLocalName())) {
                                jmlRhml80FH.setREGION_NAME(e.getText());
                            }
                        }
                        jmlRhml80FHList.add(jmlRhml80FH);
                    }
                }
            }

            if (fdlDrList != null && fdlDrList.size() > 0) {
                FgsReportRow fgsReportRow = null;
                for (int i = 0; i < fdlDrList.size(); i++) {
                    fgsReportRow = new FgsReportRow(fdlDrList.get(i),
                            jmlDrList.get(i),
                            jmlHcList.get(i),
                            jmlQcList.get(i),
                            jmlCyList.get(i),
                            jmlLjList.get(i),
                            jmlDrhyList.get(i),
                            jmlLjhyList.get(i),
                            jmlZmkcList.get(i),
                            jmlKykcList.get(i),
                            jmlZrkcList.get(i),
                            jmlAvgtenList.get(i),
                            jmlRhml80FHList.get(i));
                    if (fgsReportRow.getCMIS_COMPANY_NAME().equals("上市口径合计") || fgsReportRow.getCMIS_COMPANY_NAME().equals("代管口径合计")
                            || fgsReportRow.getCMIS_COMPANY_NAME().equals("上市+代管合计")) {
                        fgsReportRow.setMERGE_NUM(1);
                    }
                    resultList.add(fgsReportRow);
                }
            }
        } catch (AxisFault axisFault) {
            axisFault.printStackTrace();
        }
        return resultList;
    }
}
