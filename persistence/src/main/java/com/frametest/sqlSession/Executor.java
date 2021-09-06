package com.frametest.sqlSession;

import com.frametest.pojo.Configuration;
import com.frametest.pojo.MappedStatement;
import java.util.List;

/**
 * @author sfx
 */
public interface Executor {


  public <E> List<E> query(Configuration configuration, MappedStatement mappedStatement,Object... param)throws Exception;
}
