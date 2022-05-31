package com.learing.atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author sfx
 * @Description
 */
public class Atomic {


  public static AtomicInteger atomicInteger=new AtomicInteger(1);


  public static AtomicReference atomicReference=new AtomicReference(new Atomic());

  public static void main(String[] args) {

    Atomic atomic = new Atomic();

    /*boolean b = atomicReference.compareAndSet();*/
    ClassLoader classLoader = Atomic.class.getClassLoader();
    new Thread(()->{
      atomic.a1();
   }).start();


   new Thread(()->{
     atomic.a2();
   }).start();


  }


  public void a1(){
    atomicInteger.compareAndSet(1,2);
  }


  public void a2(){
    atomicInteger.compareAndSet(1,2);
  }

}
