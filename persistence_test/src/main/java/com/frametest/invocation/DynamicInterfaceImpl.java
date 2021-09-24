package com.frametest.invocation;

/**
 * @author sfx
 */
public class DynamicInterfaceImpl implements DynamicInterface{


  @Override
  public void say(String name, int age) {
    System.out.println("name:"+name+"  age:"+age);
  }
}
