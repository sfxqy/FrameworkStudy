package com.designPatterns.proxy.staticProxy;

/**
 * @author sfx
 * @Description
 */
public class Client {

  public static void main(String[] args) {
    TeacherDao teacherDao = new TeacherDao();
    ProxyTeacher proxyTeacher = new ProxyTeacher(teacherDao);
    proxyTeacher.teach();

  }
}
