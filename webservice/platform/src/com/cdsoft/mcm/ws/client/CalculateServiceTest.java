package com.cdsoft.mcm.ws.client;

import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;

import javax.xml.namespace.QName;

public class CalculateServiceTest {
    /**
     * @param args * @throws AxisFault
     */
    public static void main(String[] args) {
        try {
            new CalculateServiceTest().testVote();
        } catch (AxisFault axisFault) {
            axisFault.printStackTrace();
        }
    }

    public void testVote() throws AxisFault{
        // 使用RPC方式调用WebService
        RPCServiceClient serviceClient = new RPCServiceClient();
        Options options = serviceClient.getOptions();        // 指定调用WebService的URL
        EndpointReference targetEPR = new EndpointReference("http://192.168.1.116:8080/platform/ws/SurveyWebService");
        options.setTo(targetEPR);
        // 指定要调用的计算机器中的方法及WSDL文件的命名空间：edu.sjtu.webservice。
        QName opAddEntry = new QName("http://server.ws.sso.mcm.cdsoft.com/", "vote");//加法
        // 指定vote方法的参数值为两个，分别是加数和被加数
        Object[] opAddEntryArgs = new Object[]{"Jack", 2};
        // 指定vote方法返回值的数据类型的Class对象
        Class[] classes = new Class[]{String.class};
        // 调用vote方法并输出该方法的返回值
        System.out.println(serviceClient.invokeBlocking(opAddEntry, opAddEntryArgs, classes)[0]);
    }

    public void myTest() throws AxisFault{

    }
}