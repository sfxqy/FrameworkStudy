package com.designPatterns.Iterator;

import java.util.Iterator;

/**
 * @author sfx
 * @Description
 */
public interface Colleage {


  String getName();

  void addDepartment(String name,String desc);

  Iterator createIterator();

}
