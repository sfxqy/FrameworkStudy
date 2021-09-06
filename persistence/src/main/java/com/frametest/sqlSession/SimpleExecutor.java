package com.frametest.sqlSession;

import com.frametest.config.BoundSql;
import com.frametest.pojo.Configuration;
import com.frametest.pojo.MappedStatement;
import com.frametest.utils.GenericTokenParser;
import com.frametest.utils.ParameterMapping;
import com.frametest.utils.ParameterMappingTokenHandler;
import com.frametest.utils.TokenHandler;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sfx
 */
public class SimpleExecutor implements Executor {


  @Override
  public <E> List<E> query(Configuration configuration, MappedStatement mappedStatement,
      Object... param) throws Exception {
    //从configuration中获取一个连接
    Connection connection = configuration.getDataSource().getConnection();
    String sql = mappedStatement.getSql();
    BoundSql boundSql = getBoundSql(sql);
    PreparedStatement preparedStatement = connection.prepareStatement(boundSql.getSqlText());
    List<ParameterMapping> parameterMappingList = boundSql.getParameterMappingList();
    String paramterClassPath = mappedStatement.getParamterType();
    Class<?> classType = getClassType(paramterClassPath);
    for (int i = 0; i < parameterMappingList.size(); i++) {
      String content = parameterMappingList.get(i).getContent();
      Field declaredField = classType.getDeclaredField(content);
      declaredField.setAccessible(true);
      Object o = declaredField.get(param[0]);
      preparedStatement.setObject(i + 1, o);
    }
    ResultSet resultSet = preparedStatement.executeQuery();
    Class<?> resultType = getClassType(mappedStatement.getResultType());
    Field[] fields = resultType.getFields();
    List<Object> list = new ArrayList<>();
    while (resultSet.next()) {
      Object o = resultType.newInstance();

      ResultSetMetaData metaData = resultSet.getMetaData();
      for (int i=1;i<metaData.getColumnCount();i++){
        String columnName = metaData.getColumnName(i);
        // 字段的值
        Object value = resultSet.getObject(columnName);

        //使用反射或者内省，根据数据库表和实体的对应关系，完成封装
        PropertyDescriptor propertyDescriptor = new PropertyDescriptor(columnName, resultType);
        Method writeMethod = propertyDescriptor.getWriteMethod();
        writeMethod.invoke(o,value);

      }
 /*     for (Field f : fields) {
        Object object = resultSet.getObject(f.getName());
        f.setAccessible(true);
        f.set(o, object);

      }*/
      list.add(o);
    }
    return (List<E>) list;
  }


  public <E> List<E> getResult(ResultSet rs, Class<E> e)
      throws SQLException, InstantiationException, IllegalAccessException {
    Field[] fields = e.getFields();
    List<E> list = new ArrayList<>();
    while (rs.next()) {
      E e1 = e.newInstance();
      for (Field f : fields) {
        Object object = rs.getObject(f.getName());
        f.setAccessible(true);
        f.set(e1, object);
      }
      list.add(e1);
    }
    return list;
  }

  public Class<?> getClassType(String paramterClassPath) throws ClassNotFoundException {
    if (null != paramterClassPath) {
      Class<?> aClass = Class.forName(paramterClassPath);
      return aClass;
    }
    return null;
  }

  private BoundSql getBoundSql(String sql) {
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
