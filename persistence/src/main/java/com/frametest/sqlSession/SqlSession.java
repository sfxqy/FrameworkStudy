package com.frametest.sqlSession;

import java.util.List;

/**
 * @author sfx
 */
public interface SqlSession {

  public <E> List<E> selectList(String statementId,Object... params )throws Exception;


  public <E> E selectOne(String statementId,Object... params);


}
