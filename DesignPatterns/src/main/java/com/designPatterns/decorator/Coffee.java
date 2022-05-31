package com.designPatterns.decorator;

/**
 * @author sfx
 * @Description
 */
public class Coffee extends Drink{

  @Override
  public float cost() {
    return super.getPrice();
  }
}
