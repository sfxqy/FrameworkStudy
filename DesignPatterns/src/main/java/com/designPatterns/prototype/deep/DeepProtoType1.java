package com.designPatterns.prototype.deep;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author sfx
 * @Description
 */
public class DeepProtoType1 implements Cloneable, Serializable {


  private String name;

  private DeepCloneTarget deepCloneTarget;

  public DeepProtoType1(String name, DeepCloneTarget deepCloneTarget) {
    this.name = name;
    this.deepCloneTarget = deepCloneTarget;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public DeepCloneTarget getDeepCloneTarget() {
    return deepCloneTarget;
  }

  public void setDeepCloneTarget(DeepCloneTarget deepCloneTarget) {
    this.deepCloneTarget = deepCloneTarget;
  }

  @Override
  public String toString() {
    return "DeepProtoType{" +
        "name='" + name + '\'' +
        ", deepCloneTarget=" + deepCloneTarget +
        '}';
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
    DeepProtoType1 deepProtoType1=null;
    try {
      ByteArrayOutputStream out = new ByteArrayOutputStream();
      ObjectOutputStream oout = new ObjectOutputStream(out);
      oout.writeObject(this);
      ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(out.toByteArray());
      ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
      deepProtoType1 =(DeepProtoType1) objectInputStream.readObject();
    }catch (Exception e){

      e.printStackTrace();
    }
    return deepProtoType1;
  }
}
