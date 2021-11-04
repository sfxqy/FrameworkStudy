package com.designPatterns.prototype.deep;

import java.io.Serializable;

/**
 * @author sfx
 * @Description
 */
public class DeepProtoType implements Cloneable, Serializable {


  private String name;

  private DeepCloneTarget deepCloneTarget;

  public DeepProtoType(String name, DeepCloneTarget deepCloneTarget) {
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
    DeepProtoType clone =(DeepProtoType) super.clone();
    clone.setDeepCloneTarget((DeepCloneTarget) deepCloneTarget.clone());
    return clone;
  }
}
