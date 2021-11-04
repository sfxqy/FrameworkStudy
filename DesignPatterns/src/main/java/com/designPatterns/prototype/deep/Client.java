package com.designPatterns.prototype.deep;

/**
 * @author sfx
 * @Description  重写clone方法克隆
 */
public class Client {


  public static void main(String[] args)throws Exception {
    DeepProtoType deepProtoType = new DeepProtoType("test", new DeepCloneTarget("1",1,'1'));
    DeepProtoType clone =(DeepProtoType) deepProtoType.clone();
    DeepProtoType clone1 =(DeepProtoType) deepProtoType.clone();

   // deepProtoType.setDeepCloneTarget(new DeepCloneTarget("2",2,'2'));
    System.out.println(deepProtoType.toString());
    System.out.println(clone.toString());
    System.out.println(clone1.toString());
  }
}
