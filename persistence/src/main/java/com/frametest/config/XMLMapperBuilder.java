package com.frametest.config;

import com.frametest.pojo.Configuration;
import com.frametest.pojo.MappedStatement;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * @author sfx
 */
public class XMLMapperBuilder {


  private Configuration configuration;


  public XMLMapperBuilder(Configuration configuration){
    this.configuration=configuration;
  }


  public void parse(InputStream in)throws DocumentException {
    SAXReader saxReader = new SAXReader();
    Document document = saxReader.read(in);
    Element rootElement = document.getRootElement();
    String namespace = rootElement.attributeValue("namespace");
    Iterator<Element> element = rootElement.elementIterator();
    Map<String, MappedStatement> mappedStatementMap = configuration.getMappedStatementMap();
    while (element.hasNext()){
      MappedStatement mappedStatement = new MappedStatement();
      Element e = element.next();
      String name = e.getName();
      String id = e.attributeValue("id");
      String paramType = e.attributeValue("paramType");
      String resultType = e.attributeValue("resultType");
      String sql = e.getTextTrim();
      mappedStatement.setId(namespace+"."+id);
      mappedStatement.setParamterType(paramType);
      mappedStatement.setResultType(resultType);
      mappedStatement.setSql(sql);
      mappedStatementMap.put(namespace+"."+id,mappedStatement);
    }
  }



}
