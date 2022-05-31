package com.learing.thread;

import java.util.concurrent.Callable;

/**
 * @author sfx
 * @Description
 */
public class ThreadTest {


  public static void main(String[] args) {

    B b = new B();

    b.start();
    C c = new C();
    Thread thread1 = new Thread(c);
    Thread thread2 = new Thread(c);
    thread1.start();
    thread2.start();

  }

}


class B extends Thread{

  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName());
  }
}

class C implements Runnable{

  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName());
  }
}

class D implements Callable<Integer>{

  @Override
  public Integer call() throws Exception {
    return null;
  }
}
