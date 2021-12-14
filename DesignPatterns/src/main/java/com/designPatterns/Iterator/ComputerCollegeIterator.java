package com.designPatterns.Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author sfx
 * @Description
 */
public class ComputerCollegeIterator implements Iterator {


  private List<Department> list;

  private int index = 0;

  public ComputerCollegeIterator(List<Department> list) {
    this.list = list;
  }

  @Override
  public boolean hasNext() {
    if (index <= list.size()-1) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public Object next() {
    Object o = null;
    return list.get(index);
  }
}
