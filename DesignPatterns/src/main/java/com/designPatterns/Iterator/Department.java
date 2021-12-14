package com.designPatterns.Iterator;

/**
 * @author sfx
 * @Description
 */
public class Department {

  private String name;

  private String desc;


  public Department() {
  }

  public Department(String name, String desc) {
    this.name = name;
    this.desc = desc;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }
}
