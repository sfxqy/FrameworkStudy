package com.designPatterns.decorator.coffee;

import com.designPatterns.decorator.Decorator;
import com.designPatterns.decorator.Drink;

/**
 * @author sfx
 * @Description
 */
public class Chocolate  extends Decorator {

  public Chocolate(Drink obj) {
    super(obj);
    setDes("Chocolate");
    setPrice(2.0f);
  }
}
