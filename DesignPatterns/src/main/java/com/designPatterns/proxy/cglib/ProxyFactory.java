package com.designPatterns.proxy.cglib;

import java.lang.reflect.Method;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @author sfx
 * @Description
 */
public class ProxyFactory implements MethodInterceptor {

  private Object target;

  public ProxyFactory(Object target) {
    this.target = target;
  }


  public Object getProxyInstance(){
    Enhancer enhancer = new Enhancer();

    enhancer.setSuperclass(target.getClass());

    enhancer.setCallback(this);

    return enhancer.create();
  }

  @Override
  public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy)
      throws Throwable {
    System.out.println("cglib proxy start ...");
    Object invoke = method.invoke(target, objects);
    System.out.println("cglib proxy end   ...");
    return invoke;
  }
}
