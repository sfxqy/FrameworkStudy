package com.designPatterns.bridge;

/**
 * @author sfx
 * @Description
 */
public abstract class Phone {

  private Brand brand;

  public Phone(Brand brand) {
    this.brand = brand;
  }

  public void open(){
    this.brand.open();
  }

  public void close(){
    this.brand.close();
  }

  public void play(){
    this.brand.play();
  }
}
