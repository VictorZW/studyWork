package com.cdsoft.mcm.ws.client;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;
import org.apache.axis2.transport.http.HTTPConstants;

import javax.xml.namespace.QName;

/**
 * 使用RPC的方式对Web Service进行调用
 */

public class RpcClientDemo {
    public static void main(String[] args) {
        RPCServiceClient serviceClient = null;
        Options options = null;
        EndpointReference targetUrl = null;
        try {
            serviceClient = new RPCServiceClient();
            options = serviceClient.getOptions();
            targetUrl = new EndpointReference("http://dev03.hdpi.com.cn:8000/webservices/SOAProvider/plsql/ws_client_return_pkg/");
            options.setTo(targetUrl);// 指定调用WebService的URL
            options.setProperty(HTTPConstants.CHUNKED, false);

            //验证header 方式一
            String AUTH_PREFIX = "wsse";
            String AUTH_NS = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd";
            QName securityArgs = new QName(AUTH_NS, "Security", AUTH_PREFIX);
            QName userNameTokenArgs = new QName(AUTH_NS, "UsernameToken", AUTH_PREFIX);
            QName userNameArgs = new QName(AUTH_NS, "Username", AUTH_PREFIX);
            QName passWordArgs = new QName(AUTH_NS, "Password", AUTH_PREFIX);
            OMFactory fac = OMAbstractFactory.getOMFactory();
            OMElement securityElement = fac.createOMElement(securityArgs);
            OMElement userNameTokenElement = fac.createOMElement(userNameTokenArgs);
            OMElement usernameElement = fac.createOMElement(userNameArgs);
            OMElement passwordElement = fac.createOMElement(passWordArgs);
            usernameElement.setText("HDPI_MO");//用户名
            passwordElement.setText("1");//密码
            userNameTokenElement.addChild(usernameElement);
            userNameTokenElement.addChild(passwordElement);
            securityElement.addChild(userNameTokenElement);

            //验证header 方式二
            //由于这里调用的web service服务端需要在header里增加验证的用户信息，所以这里加了验证信息，
            // 如果服务端不需要验证信息的则不需要下列设置的参数
            /*OMFactory fac = OMAbstractFactory.getOMFactory();
            String AUTH_PREFIX = "wsse";
            String AUTH_NS = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd";
            OMElement securityElement = fac.createOMElement("Security", AUTH_NS, AUTH_PREFIX);
            OMElement userNameTokenElement = fac.createOMElement("UsernameToken", AUTH_NS, AUTH_PREFIX);
            OMElement usernameElement = fac.createOMElement("Username", AUTH_NS, AUTH_PREFIX);
            OMElement passwordElement = fac.createOMElement("Password", AUTH_NS, AUTH_PREFIX);
            usernameElement.setText("HDPI_MO");
            passwordElement.setText("1");
            userNameTokenElement.addChild(usernameElement);
            userNameTokenElement.addChild(passwordElement);
            securityElement.addChild(userNameTokenElement);*/

            //设置验证header信息
            serviceClient.addHeader(securityElement);

            //调用存储过程
            String SOAP_NS = "http://xmlns.oracle.com/apps/cux/soaprovider/plsql/ws_client_return_pkg/pro_jdbc_in_out_value/";
            String VAL_AUTH_PREFIX = "pro";
            OMElement inputParametersElement = fac.createOMElement("InputParameters", SOAP_NS, VAL_AUTH_PREFIX);
            OMElement userElement = fac.createOMElement("P_USERID", SOAP_NS, VAL_AUTH_PREFIX);
            userElement.setText("iwwenbo");
            OMElement salaryElement = fac.createOMElement("P_SALARY", SOAP_NS, VAL_AUTH_PREFIX);
            salaryElement.setText("5000");
            inputParametersElement.addChild(userElement);
            inputParametersElement.addChild(salaryElement);


            OMElement resultElement = serviceClient.sendReceive(inputParametersElement);
            String strResult = resultElement.toString();
            System.out.println(strResult);

            // 调存储过程参数
            QName opAddEntry = new QName("http://xmlns.oracle.com/apps/cux/soaprovider/plsql/ws_client_return_pkg/pro_jdbc_in_out_value/", "PRO_JDBC_IN_OUT_VALUE");
            Object[] opAddEntryArgs = new Object[]{"12李四", 10000};//存储过程的入参
            Class[] classes = new Class[]{String.class};

            //调用服务
            Object[] resultArray = serviceClient.invokeBlocking(opAddEntry, opAddEntryArgs, classes);

            System.out.println(resultArray[0]+"====");
        } catch (AxisFault axisFault) {
            axisFault.printStackTrace();
        }
    }
}
