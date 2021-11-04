package com.designPatterns.builders;

/**
 * @author sfx
 * @Description
 */
public abstract class HouseBuilder {


  abstract void buildBaise();


  abstract void buildWall();


  abstract void roofed();

  protected House house=new House();

  public House buildHouse(){
    return house;
  }


}
