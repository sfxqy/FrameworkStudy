package com.frametest.sqlSession;

import com.frametest.pojo.Configuration;
import com.frametest.pojo.MappedStatement;
import java.util.List;

/**
 * @author sfx
 */
public class DefaultSqlSession implements SqlSession {


  private Configuration configuration;

  public DefaultSqlSession(Configuration configuration){
    this.configuration=configuration;
  }

  @Override
  public <E> List<E> selectList(String statementId, Object... params)throws Exception {
    SimpleExecutor simpleExecutor = new SimpleExecutor();
    MappedStatement mappedStatement = configuration.getMappedStatementMap().get(statementId);
    List<E> result = simpleExecutor.query(configuration, mappedStatement, params);
    return result;
  }

  @Override
  public <E> E selectOne(String statementId, Object... params) {
    return null;
  }
}
