package com.designPatterns.prototype.deep;

import java.io.Serializable;

/**
 * @author sfx
 * @Description
 */
public class DeepCloneTarget implements Cloneable, Serializable {

  private String name;

  private int age;

  private char sex;

  public DeepCloneTarget() {
  }

  public DeepCloneTarget(String name, int age, char sex ) {
    this.name = name;
    this.age = age;
    this.sex = sex;
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


 /* @Override
  public String toString() {
    return "DeepCloneTarget{" +
        "name='" + name + '\'' +
        ", age=" + age +
        ", sex=" + sex +
        '}';
  }
*/
  @Override
  protected Object clone() throws CloneNotSupportedException {
    return super.clone();
  }
}
