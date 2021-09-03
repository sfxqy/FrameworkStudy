package com.frametest.test;

import com.frametest.io.Resources;
import com.frametest.sqlSession.SqlSessionFactoryBuilder;
import java.io.InputStream;

/**
 * @author sfx
 */
public class Test {

  public static void main(String[] args) throws Exception{
    InputStream resourceAsStream = Test.class.getClassLoader()
        .getResourceAsStream("classpath://sqlMapperConfig.xml");
    InputStream reourcesAsStream = Resources.getReourcesAsStream("sqlMapperConfig.xml");
    SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
    sqlSessionFactoryBuilder.build(reourcesAsStream);

  }

}
