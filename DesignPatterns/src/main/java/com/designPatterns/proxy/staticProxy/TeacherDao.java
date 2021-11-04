package com.designPatterns.proxy.staticProxy;

/**
 * @author sfx
 * @Description
 */
public class TeacherDao implements ITeacherDao{

  @Override
  public void teach() {
    System.out.println("bei zeng qiang fang fa");
  }
}
