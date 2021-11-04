package com.designPatterns.combination;

/**
 * @author sfx
 * @Description
 */
public class Department extends OrganizationComponent {


  @Override
  protected void remove(OrganizationComponent organizationComponent) {
    super.remove(organizationComponent);
  }

  public Department(String name, String describe) {
    super(name, describe);
  }

  @Override
  public String getName() {
    return super.getName();
  }

  @Override
  public void setName(String name) {
    super.setName(name);
  }

  @Override
  public String getDescribe() {
    return super.getDescribe();
  }

  @Override
  public void setDescribe(String describe) {
    super.setDescribe(describe);
  }

  @Override
  protected void print() {
    System.out.println(getName());
  }
}
