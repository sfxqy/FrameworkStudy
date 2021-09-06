package com.frametest.sqlSession;

import com.frametest.config.BoundSql;
import com.frametest.pojo.Configuration;
import com.frametest.pojo.MappedStatement;
import com.frametest.utils.GenericTokenParser;
import com.frametest.utils.ParameterMapping;
import com.frametest.utils.ParameterMappingTokenHandler;
import com.frametest.utils.TokenHandler;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

/**
 * @author sfx
 */
public class SimpleExecutor implements Executor{


  @Override
  public <E> List<E> query(Configuration configuration, MappedStatement mappedStatement,
      Object... param)throws Exception {
    //从configuration中获取一个连接
    Connection connection = configuration.getDataSource().getConnection();
    String sql = mappedStatement.getSql();
    BoundSql boundSql = getBoundSql(sql);
    PreparedStatement preparedStatement = connection.prepareStatement(boundSql.getSqlText());
    List<ParameterMapping> parameterMappingList = boundSql.getParameterMappingList();
    String paramterClassPath = mappedStatement.getParamterType();
    Class<?> classType = getClassType(paramterClassPath);
    for (int i=0;i<parameterMappingList.size();i++){
      String content = parameterMappingList.get(i).getContent();
      Field declaredField = classType.getDeclaredField(content);
      declaredField.setAccessible(true);
      String name = declaredField.getName();

    }
    for (ParameterMapping p:parameterMappingList){
      parameterMappingList.set()
    }
    return null;
  }

  public Class<?> getClassType(String paramterClassPath)throws ClassNotFoundException{
    if (null==paramterClassPath){
      return;
    }
    Class<?> aClass = Class.forName(paramterClassPath);

  }

  private BoundSql getBoundSql(String sql){
    ParameterMappingTokenHandler tokenHandler = new ParameterMappingTokenHandler();
    GenericTokenParser genericTokenParser = new GenericTokenParser("#{", "}", tokenHandler);
    String parse = genericTokenParser.parse(sql);
    List<ParameterMapping> parameterMappings = tokenHandler.getParameterMappings();
    BoundSql boundSql = new BoundSql();
    boundSql.setSqlText(parse);
    boundSql.setParameterMappingList(parameterMappings);
    return boundSql;
  }
}
