package com.designPatterns.adapter.objects;

/**
 * @author sfx
 * @Description
 */
public class Phone {

  public void charging(Voltage5V v){
    if (v.outPut5V()==5){
      System.out.printf("充电");
    }

  }

}
