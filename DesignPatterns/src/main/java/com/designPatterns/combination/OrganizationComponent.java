package com.designPatterns.combination;

/**
 * @author sfx
 * @Description 组合模式
 */
public abstract class OrganizationComponent {

  private String name;

  String describe;


  protected void add(OrganizationComponent organizationComponent){
    throw new UnsupportedOperationException();
  }


  protected void remove(OrganizationComponent organizationComponent){
    throw new UnsupportedOperationException();
  }

  //所有子类都需要用
  protected abstract void print();


  public OrganizationComponent(String name, String describe) {
    this.name = name;
    this.describe = describe;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescribe() {
    return describe;
  }

  public void setDescribe(String describe) {
    this.describe = describe;
  }
}
