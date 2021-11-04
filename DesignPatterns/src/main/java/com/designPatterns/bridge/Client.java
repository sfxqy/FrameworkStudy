package com.designPatterns.bridge;

/**
 * @author sfx
 * @Description
 */
public class Client {


  public static void main(String[] args) {
    XiaoMi xiaoMi = new XiaoMi();
    SolidPhone solidPhone = new SolidPhone(xiaoMi);
    solidPhone.open();
    System.out.println("==========");
    HuaWei huaWei = new HuaWei();
    SolidPhone solidPhone1 = new SolidPhone(huaWei);
    solidPhone1.open();
  }

}
