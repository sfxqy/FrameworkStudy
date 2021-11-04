package com.designPatterns.bridge;

/**
 * @author sfx
 * @Description
 */
public class UpRightPhone extends Phone{



  public UpRightPhone(Brand brand) {
    super(brand);
  }

  @Override
  public void open() {
    System.out.printf("up");
    super.open();
  }

  @Override
  public void close() {
    System.out.printf("up");
    super.close();
  }

  @Override
  public void play() {
    System.out.printf("up");
    super.play();
  }
}
