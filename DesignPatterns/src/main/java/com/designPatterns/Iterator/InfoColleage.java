package com.designPatterns.Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author sfx
 * @Description
 */
public class InfoColleage implements Colleage{

  private List<Department> departments;

  private int index=0;


  public InfoColleage() {
    departments=new ArrayList<>();
    addDepartment("","");
  }

  @Override
  public String getName() {
    return "信息";
  }

  @Override
  public void addDepartment(String name, String desc) {

  }

  @Override
  public Iterator createIterator() {
    return null;
  }
}
