package com.spring.service.impl;

import com.spring.service.AccountDao;

/**
 * @author sfx
 * @Description
 */
public class AccountDaoImpl implements AccountDao {


  @Override
  public void transfer(String fromCardNo, String toCardNo, int money) {
    System.out.println(fromCardNo+"=="+toCardNo+"=="+money);
  }
}
