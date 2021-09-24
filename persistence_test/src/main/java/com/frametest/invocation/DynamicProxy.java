package com.frametest.invocation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author sfx
 */
public class DynamicProxy implements InvocationHandler {

  private Object object;

  public DynamicProxy(Object object) {
    this.object = object;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    Object o=null;
    System.out.println("say方法增强之前");
    o=method.invoke(object,args);
    System.out.println("say方法增强之后");
    return null;
  }
}
