package com.designPatterns.builders;

/**
 * @author sfx
 * @Description
 */
public class HightHouse extends HouseBuilder{


  @Override
  void buildBaise() {
    house.setBaise("高楼打桩");
  }

  @Override
  void buildWall() {

    house.setWall("hight wall");
  }

  @Override
  void roofed() {

    house.setRoofed("roofed");
  }

  @Override
  public House buildHouse() {
    return super.buildHouse();
  }
}
