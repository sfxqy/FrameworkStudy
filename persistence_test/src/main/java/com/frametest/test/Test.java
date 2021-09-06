package com.frametest.test;

import com.frametest.io.Resources;
import com.frametest.sqlSession.SqlSession;
import com.frametest.sqlSession.SqlSessionFactory;
import com.frametest.sqlSession.SqlSessionFactoryBuilder;
import java.io.InputStream;

/**
 * @author sfx
 */
public class Test {

  public static void main(String[] args) throws Exception{
    InputStream reourcesAsStream = Resources.getReourcesAsStream("sqlMapperConfig.xml");
    SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
    SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(reourcesAsStream);
    SqlSession sqlSession1 = sqlSessionFactory.openSession();


  }

}
