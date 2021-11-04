package com.designPatterns.adapter.objects;

/**
 * @author sfx
 * @Description
 */
public class VoltageAdapter implements Voltage5V{


  Voltage220V v=new Voltage220V();

  @Override
  public Integer outPut5V() {
    Integer outPut220V = v.outPut220V();
    System.out.printf("输出电压");
    int i = outPut220V / 44;
    return i;
  }
}
