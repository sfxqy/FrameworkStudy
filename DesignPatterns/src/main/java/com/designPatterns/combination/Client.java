package com.designPatterns.combination;

/**
 * @author sfx
 * @Description
 */
public class Client {


  public static void main(String[] args) {

    College college = new College("学校", "学校");
    University university1 = new University("学院1", "学院");
    University university2 = new University("学院2", "学院");
    college.add(university1);
    college.add(university2);
    Department department1 = new Department("系1", "系1");
    Department department2 = new Department("系1", "系1");
    Department department3 = new Department("系1", "系1");
    university1.add(department1);
    university1.add(department2);
    university2.add(department3);

    college.print();
  }

}
