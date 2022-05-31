package com.designPatterns.decorator;

import com.sun.xml.internal.bind.v2.runtime.property.StructureLoaderBuilder;

/**
 * @author sfx
 * @Description
 */
public abstract class Drink {

  String des;

  float price=0.0f;

  public abstract float cost();


  public String getDes() {
    return des;
  }

  public void setDes(String des) {
    this.des = des;
  }

  public float getPrice() {
    return price;
  }

  public void setPrice(float price) {
    this.price = price;
  }
}
