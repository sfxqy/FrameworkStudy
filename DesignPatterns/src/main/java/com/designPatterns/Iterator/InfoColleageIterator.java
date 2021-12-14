package com.designPatterns.Iterator;

import java.util.Iterator;
import java.util.List;

/**
 * @author sfx
 * @Description
 */
public class InfoColleageIterator implements Iterator {

  private List<Department> list;

  private int index=0;

  public InfoColleageIterator(List<Department> list) {
    this.list = list;
  }

  @Override
  public boolean hasNext() {
    if (index<=list.size()-1){
      return true;
    }else {
      return false;
    }
  }

  @Override
  public Object next() {
    return list.get(index);
  }
}
