package com.designPatterns.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Objects;

/**
 * @author sfx
 * @Description
 */
public class ProxyFactory {


  private Object target;

  public ProxyFactory(Object target) {
    this.target = target;
  }


  public Object getProxyInstancne(){
    return Proxy.newProxyInstance(target.getClass().getClassLoader(),
        target.getClass().getInterfaces(), new InvocationHandler() {
          @Override
          public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("proxy start ...");
            Object invoke = method.invoke(target, args);
            System.out.println("proxy end   ...");
            return invoke;
          }
        });
  }



}
