package com.designPatterns.builders;

/**
 * @author sfx
 * @Description
 */
public class HouseDirector {

  HouseBuilder houseBuilder=null;

  public HouseDirector(HouseBuilder houseBuilder) {
    this.houseBuilder = houseBuilder;
  }

  public House constructHouse(){
    houseBuilder.buildBaise();
    houseBuilder.buildWall();
    houseBuilder.roofed();
    return houseBuilder.buildHouse();
  }
}
