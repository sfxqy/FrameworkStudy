package com.designPatterns.adapter.objects;

/**
 * @author sfx
 * @Description
 */
public class Voltage220V {

  private Integer voltage=220;


  public Integer outPut220V(){
    System.out.printf("输出电压:"+voltage);
    return voltage;
  }

}
