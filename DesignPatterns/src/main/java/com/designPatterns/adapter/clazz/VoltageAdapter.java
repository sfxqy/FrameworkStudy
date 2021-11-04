package com.designPatterns.adapter.clazz;

/**
 * @author sfx
 * @Description
 */
public class VoltageAdapter extends Voltage220V implements Voltage5V {

  @Override
  public Integer outPut5V() {
    Integer outPut220V = outPut220V();
    System.out.printf("输出电压");
    int i = outPut220V / 44;
    return i;
  }
}
