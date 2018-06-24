package com.cdsoft.mcm.ws.client;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.transport.http.HTTPConstants;

import java.util.Iterator;

public class ReportServiceTest {
    public static void main(String[] args) {
        String url = "http://dev03.hdpi.com.cn:8000/webservices/SOAProvider/plsql/hdpi_gh_report_test_pkg/?wsdl";
        String securityUser = "HDPI_MO";
        String securityPassword = "1";

        try {
            Options options = new Options();
            // 指定调用WebService的URL
            EndpointReference targetEPR = new EndpointReference(url);
            options.setTo(targetEPR);

            ServiceClient sender = new ServiceClient();
            sender.setOptions(options);
            sender.getOptions().setProperty(HTTPConstants.CHUNKED, false);

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
            String SOAP_NS = "http://xmlns.oracle.com/apps/cux/soaprovider/plsql/hdpi_gh_report_test_pkg/query_fdl_column/";
            String VAL_AUTH_PREFIX = "quer";
            OMElement inputParametersElement = fac.createOMElement("InputParameters", SOAP_NS, VAL_AUTH_PREFIX);
            OMElement dateElement = fac.createOMElement("P_DATE_STR", SOAP_NS, VAL_AUTH_PREFIX);
            dateElement.setText("20160201");
            inputParametersElement.addChild(dateElement);

            //根据查询参数，执行请求
            OMElement resultElement = sender.sendReceive(inputParametersElement);
            String strResult = resultElement.toString();
            System.out.println(strResult);
            Iterator resultIterator = resultElement.getChildElements();
            while (resultIterator.hasNext()) {
                OMElement element = (OMElement) resultIterator.next();
                if (element != null && "R_FDL_DR_COLUMN".equals(element.getLocalName())) {
                    Iterator fdlItemIterator = element.getChildElements();
                    while (fdlItemIterator.hasNext()) {
                        OMElement fdlElement = (OMElement) fdlItemIterator.next();
                        Iterator fdlIterator = fdlElement.getChildElements();
                        while (fdlIterator.hasNext()) {
                            OMElement e = (OMElement) fdlIterator.next();
                            if (e != null && "FDL_DR".equals(e.getLocalName())) {
                                System.out.println("返回值==" + e.getText());
                            }
                        }
                    }

                }
            }
        } catch (AxisFault e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
