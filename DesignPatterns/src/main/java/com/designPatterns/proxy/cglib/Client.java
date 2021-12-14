package com.designPatterns.proxy.cglib;

/**
 * @author sfx
 * @Description
 */
public class Client {


  public static void main(String[] args) {

    ProxyFactory proxyFactory = new ProxyFactory(new TeacherDao());
    TeacherDao proxyInstance = (TeacherDao)proxyFactory.getProxyInstance();
    Integer teach = proxyInstance.teach();
    System.out.println(teach);

  }
}


