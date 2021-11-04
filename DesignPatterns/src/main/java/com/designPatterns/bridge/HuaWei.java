package com.designPatterns.bridge;

/**
 * @author sfx
 * @Description
 */
public class HuaWei implements Brand{

  @Override
  public void open() {
    System.out.printf("HuaWei");
  }

  @Override
  public void close() {
    System.out.printf("HuaWei");
  }

  @Override
  public void play() {
    System.out.printf("HuaWei");
  }
}
