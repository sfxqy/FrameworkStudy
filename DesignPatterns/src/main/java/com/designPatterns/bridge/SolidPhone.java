package com.designPatterns.bridge;

/**
 * @author sfx
 * @Description
 */
public class SolidPhone extends Phone{

  public SolidPhone(Brand brand) {
    super(brand);
  }

  @Override
  public void open() {
    System.out.printf("solid");
    super.open();
  }

  @Override
  public void close() {
    System.out.printf("solid");
    super.close();
  }

  @Override
  public void play() {
    System.out.printf("solid");
    super.play();
  }
}
