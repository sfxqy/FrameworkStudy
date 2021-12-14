package com.designPatterns.Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author sfx
 * @Description
 */
public class ComputerColleage implements Colleage{

  private List<Department> departments;

  private int index=0;

  public ComputerColleage() {
    this.departments = new ArrayList<>();
    addDepartment("java专业","java专业");
    addDepartment("PHP专业","PHP专业");
    addDepartment("大数据专业","大数据专业");
  }

  @Override
  public String getName() {
    return "计算机学院";
  }

  @Override
  public void addDepartment(String name, String desc) {
    Department department = new Department(name,desc);
    departments.add(department);
  }

  @Override
  public Iterator createIterator() {
    return new ComputerCollegeIterator(departments);
  }
}
