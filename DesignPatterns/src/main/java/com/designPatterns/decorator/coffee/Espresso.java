package com.designPatterns.decorator.coffee;

import com.designPatterns.decorator.Coffee;

/**
 * @author sfx
 * @Description
 */
public class Espresso extends Coffee {

  public Espresso() {
    setDes("意大利咖啡");
    setPrice(6.0f);
  }
}
