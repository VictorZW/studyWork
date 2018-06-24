package com.cdsoft.mcm.ws;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.transport.http.HTTPConstants;

import java.util.Iterator;

public class WebServiceDemo {
    public static void main(String[] args) {

        String url = "http://dev03.hdpi.com.cn:8000/webservices/SOAProvider/plsql/hdpi_sh_report_pkg_8/?wsdl";
        String securityUser = "HDPI_MO";
        String securityPassword = "1";
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
            String SOAP_NS = "http://xmlns.oracle.com/apps/cux/soaprovider/plsql/hdpi_sh_report_pkg_8/query_sh_report/";
            String VAL_AUTH_PREFIX = "quer";
            OMElement inputParametersElement = fac.createOMElement("InputParameters", SOAP_NS, VAL_AUTH_PREFIX);
            OMElement dateElement = fac.createOMElement("P_DATE_STR", SOAP_NS, VAL_AUTH_PREFIX);
            OMElement regionElement = fac.createOMElement("P_REGION_ID", SOAP_NS, VAL_AUTH_PREFIX);
            dateElement.setText("20160201");
            regionElement.setText("8335");
            inputParametersElement.addChild(dateElement);
            inputParametersElement.addChild(regionElement);

            //根据查询参数，执行请求
            OMElement resultElement = sender.sendReceive(inputParametersElement);
            Iterator resultIterator = resultElement.getChildElements();

            while (resultIterator.hasNext()) {
                OMElement element = (OMElement) resultIterator.next();
                if (element != null && "R_FDL_DR_COLUMN".equals(element.getLocalName())) {
                    Iterator fdlItemIterator = element.getChildElements();
                    while (fdlItemIterator.hasNext()) {
                        OMElement fdlElement = (OMElement) fdlItemIterator.next();
                        System.out.println(fdlElement.getLocalName());
                    }
                }
            }


        } catch (AxisFault axisFault) {
            axisFault.printStackTrace();
        }
    }
}
