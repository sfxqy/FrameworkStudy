package com.designPatterns.prototype.shallow;

/**
 * @author sfx
 * @Description
 */
public class Sheep implements Cloneable{

  private String name;

  private int age;

  private char sex;

  private Person person;


  public Sheep() {
  }

  public Sheep(String name, int age, char sex) {
    this.name = name;
    this.age = age;
    this.sex = sex;
  }


  public Sheep(String name, int age, char sex, Person person) {
    this.name = name;
    this.age = age;
    this.sex = sex;
    this.person = person;
  }

  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public char getSex() {
    return sex;
  }

  public void setSex(char sex) {
    this.sex = sex;
  }

  @Override
  public String toString() {
    return "Sheep{" +
        "name='" + name + '\'' +
        ", age=" + age +
        ", sex=" + sex +
        ", person=" + person +
        '}';
  }

  @Override
  protected Object clone() {
    Sheep sheep=null;
    try {
      sheep=(Sheep) super.clone();
    }catch (CloneNotSupportedException e){
      e.printStackTrace();
    }
    return sheep;
  }
}
