package com.cdsoft.mcm.ws.client;

import org.apache.axis2.AxisFault;

import java.math.BigDecimal;
import java.rmi.RemoteException;

public class Wsdl2JavaClientDemo {
    public static void main(String[] args) {
        try {
            String url = "http://dev03.hdpi.com.cn:8000/webservices/SOAProvider/plsql/ws_client_return_pkg";
            WS_CLIENT_RETURN_PKG_ServiceStub serviceStub = new WS_CLIENT_RETURN_PKG_ServiceStub(url);
            WS_CLIENT_RETURN_PKG_ServiceStub.InputParameters inputParameters  =  new WS_CLIENT_RETURN_PKG_ServiceStub.InputParameters();
            inputParameters.setP_USERID("iwwenbo");
            inputParameters.setP_SALARY(new BigDecimal(2000));
            WS_CLIENT_RETURN_PKG_ServiceStub.SOAHeader soaHeader = new WS_CLIENT_RETURN_PKG_ServiceStub.SOAHeader();
            try {
                serviceStub.pRO_JDBC_IN_OUT_VALUE(inputParameters,soaHeader);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } catch (AxisFault axisFault) {
            axisFault.printStackTrace();
        }
    }
}
