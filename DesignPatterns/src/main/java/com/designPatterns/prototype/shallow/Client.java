package com.designPatterns.prototype.shallow;

/**
 * @author sfx
 * @Description
 */
public class Client {


  public static void main(String[] args) {
    Sheep sheep = new Sheep("s", 1, '男',new Person());

    Sheep sheep1 =(Sheep) sheep.clone();

    Sheep sheep2 =(Sheep) sheep.clone();

    System.out.println(sheep.toString());
    System.out.println(sheep1.toString());
    System.out.println(sheep2.toString());
  }

}
