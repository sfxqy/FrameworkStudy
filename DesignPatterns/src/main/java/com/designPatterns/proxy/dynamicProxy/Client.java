package com.designPatterns.proxy.dynamicProxy;

import com.designPatterns.proxy.staticProxy.ProxyTeacher;

/**
 * @author sfx
 * @Description
 */
public class Client {

  public static void main(String[] args) {
    TeacherDao teacherDao = new TeacherDao();
    ProxyFactory proxyFactory = new ProxyFactory(teacherDao);
    ITeacherDao teacherDao1 = (ITeacherDao)proxyFactory.getProxyInstancne();
    teacherDao1.teach();
  }
}
