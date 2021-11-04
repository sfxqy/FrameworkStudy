package com.designPatterns.flyweightPattern;

/**
 * @author sfx
 * @Description
 */
public class Client {

  public static void main(String[] args) {
    WbeStieFactory x = new WbeStieFactory();
    WebSite x1 = x.getWbeSite("x");
    x1.use(new User("aaa1"));

    WbeStieFactory x2 = new WbeStieFactory();
    WebSite x3 = x.getWbeSite("x2");
    x3.use(new User("aaa2"));

    WbeStieFactory x4 = new WbeStieFactory();
    WebSite x5 = x.getWbeSite("x");
    x5.use(new User("aaa3"));
    System.out.println(x1);
    System.out.println(x3);
    System.out.println(x5);

  }

}
