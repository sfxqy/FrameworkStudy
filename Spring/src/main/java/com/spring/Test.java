package com.spring;

import com.spring.beanFactory.BeanFactory;
import com.spring.service.TransferService;

/**
 * @author sfx
 * @Description
 */
public class Test {

  public static void main(String[] args) {
    BeanFactory beanFactory = new BeanFactory();
    TransferService transferService = (TransferService) beanFactory.getBean("transferService");
    transferService.transfer("111","222",6);
  }

}
