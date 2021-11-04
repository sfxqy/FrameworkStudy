package com.designPatterns.prototype.deep;

/**
 * @author sfx
 * @Description  序列化方式克隆
 */
public class Client1 {

  public static void main(String[] args) throws Exception{

    DeepProtoType1 deepProtoType1 = new DeepProtoType1("", new DeepCloneTarget());

    DeepProtoType1 clone =(DeepProtoType1) deepProtoType1.clone();
    System.out.println(deepProtoType1.toString());
    System.out.printf(clone.toString());
  }

}
