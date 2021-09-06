package com.frametest.sqlSession;

import com.frametest.pojo.Configuration;
import com.frametest.pojo.MappedStatement;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
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
  public <E> E selectOne(String statementId, Object... params) throws Exception{
    List<Object> objects = selectList(statementId, params);
    if (objects.size()==1){
      return (E)objects;
    }else {
      throw new Exception("结果集异常");
    }
  }

  @Override
  public <E> E getMapper(Class<?> mapperClass) {
    //使用JDK动态代理为Dao接口生成代理对象

    Proxy.newProxyInstance(DefaultSqlSession.class.getClassLoader(),new Class[]{mapperClass},
    new InvocationHandler() {
      //proxy:当前代理对象的应用  method：当前被调用方法的引用  args:传递的参数
      @Override
      public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
      }
    });

    return null;
  }
}
