package com.frametest.sqlSession;

import com.frametest.pojo.Configuration;

/**
 * @author sfx
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory{

  private Configuration configuration;


  public DefaultSqlSessionFactory(Configuration configuration){
    this.configuration=configuration;
  }

  @Override
  public SqlSession openSession() {
    return new DefaultSqlSession();
  }
}
