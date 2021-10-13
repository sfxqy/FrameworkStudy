package com.sfx.pojo;

public class Student {


  private String name;

  private Integer age;

  private String clazz;

  public Student() {
  }

  public Student(String name, Integer age, String clazz) {
    this.name = name;
    this.age = age;
    this.clazz = clazz;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getClazz() {
    return clazz;
  }

  public void setClazz(String clazz) {
    this.clazz = clazz;
  }
}
