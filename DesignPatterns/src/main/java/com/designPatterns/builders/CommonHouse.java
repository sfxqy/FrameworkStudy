package com.designPatterns.builders;

/**
 * @author sfx
 * @Description
 */
public class CommonHouse extends HouseBuilder {

  @Override
  void buildBaise() {
    house.setBaise("common baise");
  }

  @Override
  void buildWall() {
    house.setWall("common wall");
  }

  @Override
  void roofed() {
    house.setRoofed("common roored");
  }

  @Override
  public House buildHouse() {
    return super.buildHouse();
  }
}
