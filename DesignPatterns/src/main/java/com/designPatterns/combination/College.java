package com.designPatterns.combination;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sfx
 * @Description
 */
public class College extends OrganizationComponent{

  List<OrganizationComponent> organizationComponents=new ArrayList<>();

  @Override
  protected void add(OrganizationComponent organizationComponent) {
    organizationComponents.add(organizationComponent);
  }

  @Override
  protected void remove(OrganizationComponent organizationComponent) {
    organizationComponents.remove(organizationComponent);
  }

  public College(String name, String describe) {
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
    System.out.println("---------"+getName()+"---------");
    for (OrganizationComponent o:organizationComponents){
      o.print();
    }
  }
}
