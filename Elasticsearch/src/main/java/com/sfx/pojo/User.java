package com.sfx.pojo;

/**
 * @author sfx
 */
public class User {


  private String name;

  private char sex;

  private int age;


  public User() {
  }

  public User(String name, char sex, int age) {
    this.name = name;
    this.sex = sex;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public char getSex() {
    return sex;
  }

  public void setSex(char sex) {
    this.sex = sex;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }
}
