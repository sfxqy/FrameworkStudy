package com.designPatterns.decorator;

import com.designPatterns.decorator.coffee.Chocolate;

/**
 * @author sfx
 * @Description
 */
public class CoffeeBar {

  public static void main(String[] args) {
    LongBlack order = new LongBlack();
    System.out.println(order.getDes());
    System.out.println(order.cost());
    System.out.println("--------------------");
    Milk milk = new Milk(order);
    System.out.println(milk.getDes());
    System.out.println(milk.cost());
    System.out.println("--------------------");
    Chocolate chocolate = new Chocolate(milk);
    System.out.println(chocolate.getDes());
    System.out.println(chocolate.cost());
  }

}
