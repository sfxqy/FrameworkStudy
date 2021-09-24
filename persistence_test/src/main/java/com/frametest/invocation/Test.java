package com.frametest.invocation;

import java.lang.reflect.Proxy;

/**
 * @author sfx
 */
public class Test {


  public static void main(String[] args) {

    DynamicInterfaceImpl dynamicInterface = new DynamicInterfaceImpl();
    DynamicProxy dynamicProxy = new DynamicProxy(dynamicInterface);
    DynamicInterface o =(DynamicInterface) Proxy.newProxyInstance(DynamicInterfaceImpl.class.getClassLoader(),
        DynamicInterfaceImpl.class.getInterfaces(), dynamicProxy);
      o.say("sfx",18);
  }

}
