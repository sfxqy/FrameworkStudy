package com.frametest.sqlSession;

import com.frametest.config.XMLConfigBuilder;
import com.frametest.pojo.Configuration;
import java.beans.PropertyVetoException;
import java.io.InputStream;
import org.dom4j.DocumentException;

/**
 * @author sfx
 */
public class SqlSessionFactoryBuilder {


  public SqlSessionFactory build(InputStream inputStream)throws DocumentException, PropertyVetoException {
    XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder();
    Configuration configuration = xmlConfigBuilder.parseConfig(inputStream);
    DefaultSqlSessionFactory sqlSessionFactory = new DefaultSqlSessionFactory(configuration);
    return sqlSessionFactory;
  }

}
