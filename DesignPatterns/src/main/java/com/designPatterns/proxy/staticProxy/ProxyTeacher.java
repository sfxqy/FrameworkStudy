package com.designPatterns.proxy.staticProxy;

/**
 * @author sfx
 * @Description
 */
public class ProxyTeacher implements ITeacherDao{

  private ITeacherDao target;

  public ProxyTeacher(ITeacherDao target) {
    this.target = target;
  }

  @Override
  public void teach() {
    System.out.println("增强方法---开始");
    target.teach();
    System.out.println("增强方法---开始");
  }
}
