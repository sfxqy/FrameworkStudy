package com.designPatterns.bridge;

/**
 * @author sfx
 * @Description
 */
public class XiaoMi implements Brand{

  @Override
  public void open() {
    System.out.printf("xiaomi");
  }

  @Override
  public void close() {
    System.out.printf("xiaomi");
  }

  @Override
  public void play() {
    System.out.printf("xiaomi");
  }
}
