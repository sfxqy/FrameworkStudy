package com.frametest.config;

import com.frametest.pojo.Configuration;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class XMLConfigBuilder {


    public Configuration parseConfig(InputStream in)throws DocumentException {
        SAXReader saxReader = new SAXReader();

        Document document = saxReader.read(in);
        Element el = document.getRootElement();
        List<Element> list = el.selectNodes("//property");
        Properties properties = new Properties();
        for (Element e:list){
            
        }
        return null;

    }
}
