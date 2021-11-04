package com.designPatterns.builders;

/**
 * @author sfx
 * @Description
 */
public class House {


  private String baise;

  private String wall;

  private String roofed;

  public House() {
  }

  public House(String baise, String wall, String roofed) {
    this.baise = baise;
    this.wall = wall;
    this.roofed = roofed;
  }

  public String getBaise() {
    return baise;
  }

  public void setBaise(String baise) {
    this.baise = baise;
  }

  public String getWall() {
    return wall;
  }

  public void setWall(String wall) {
    this.wall = wall;
  }

  public String getRoofed() {
    return roofed;
  }

  public void setRoofed(String roofed) {
    this.roofed = roofed;
  }
}
