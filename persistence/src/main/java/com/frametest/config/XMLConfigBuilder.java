package com.frametest.config;

import com.frametest.pojo.Configuration;
import com.frametest.pojo.MappedStatement;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.beans.PropertyVetoException;
import java.util.Iterator;
import java.util.Map;
import javax.sql.DataSource;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class XMLConfigBuilder {

    private Configuration configuration;

    public XMLConfigBuilder(){
        configuration = new Configuration();
    }


    //解析xml文件
    public Configuration parseConfig(InputStream in)throws DocumentException, PropertyVetoException {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(in);
        Element el = document.getRootElement();
        List<Element> propertyList = el.selectNodes("//property");
        Properties properties = new Properties();
        for (Element e:propertyList){
            String name = e.attributeValue("name");
            String value = e.attributeValue("value");
            properties.setProperty(name,value);
        }
        List<Element> mapperList = el.selectNodes("//mapper");
        for (Element e:mapperList){
            String resourcePath = e.attributeValue("resource");
            InputStream resourceAsStream = XMLConfigBuilder.class.getClassLoader()
                .getResourceAsStream(resourcePath);
            XMLMapperBuilder xmlMapperBuilder = new XMLMapperBuilder(configuration);
            xmlMapperBuilder.parse(resourceAsStream);
        }
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setDriverClass(properties.getProperty("driverClass"));
        comboPooledDataSource.setJdbcUrl(properties.getProperty("jdbcUrl"));
        comboPooledDataSource.setUser(properties.getProperty("username"));
        comboPooledDataSource.setPassword(properties.getProperty("password"));
        configuration.setDataSource(comboPooledDataSource);
        return configuration;

    }

}
