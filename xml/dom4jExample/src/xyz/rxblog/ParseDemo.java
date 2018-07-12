package xyz.rxblog;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.Iterator;

public class ParseDemo {
    public static void main(String[] args) {
        File inputXml = new File("D:\\wsresult.xml");
        SAXReader saxReader = new SAXReader();
        String resultCode = "";
        try {
            //解析xml字符串
            //Document document = DocumentHelper.parseText(xmlResult);
            //解析文件
            Document document = saxReader.read(inputXml);
            Element rootElement = document.getRootElement();
            Iterator rootIterator = rootElement.elementIterator("Data");
            Element rootChildElement = (Element) rootIterator.next();
            //拿到root下的BDCFKLIST元素进行遍历
            Iterator bdcfkListIt = rootChildElement.elementIterator("BDCFKLIST");
            while (bdcfkListIt.hasNext()) {
                Element bdcfkListChildElement = (Element) bdcfkListIt.next();
                //拿到BDCFKLIST下的BDCCXJG元素进行遍历
                Iterator bdccxjgIt = bdcfkListChildElement.elementIterator("BDCCXJG");
                while (bdccxjgIt.hasNext()) {
                    //各个结果集
                    Element bdccxjgChildElement = (Element) bdccxjgIt.next();
                    //resultCode
                    Iterator resultCodeIt = bdccxjgChildElement.elementIterator("RESULT");
                    while (resultCodeIt.hasNext()) {
                        Element rE = (Element) resultCodeIt.next();
                        if ("RESULT".equals(StringUtils.trimToEmpty(rE.getName()))) {
                            resultCode = StringUtils.trimToEmpty(rE.getText());
                            System.out.println(resultCode);
                        }
                    }
                    //土地所有权
                    Iterator tdsyqlistIt = bdccxjgChildElement.elementIterator("TDSYQLIST");
                    while (tdsyqlistIt.hasNext()) {
                        Element tdsyqlistChildElement = (Element) tdsyqlistIt.next();
                        Iterator tdsyqIt = tdsyqlistChildElement.elementIterator("TDSYQ");
                        //封装List集合
                        while (tdsyqIt.hasNext()) {
                            Element childElement = (Element) tdsyqIt.next();
                            Iterator tIt = childElement.elementIterator();
                            while (tIt.hasNext()) {
                                Element tdsyqAttri = (Element) tIt.next();
                                if ("BDCDYH".equals(tdsyqAttri.getName())) {
                                    System.out.println(tdsyqAttri.getText());
                                }
                            }
                        }
                    }
                }
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
