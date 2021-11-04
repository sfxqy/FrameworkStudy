package com.designPatterns.flyweightPattern;

/**
 * @author sfx
 * @Description
 */
public class ConWebSite implements WebSite{

  private String type;

  public ConWebSite(String type) {
    this.type = type;
  }

  @Override
  public void use(User user) {
    System.out.println("type:"+type+"---user.name="+user.getName());
  }
}
