package com.spring.service.impl;

import com.spring.service.AccountDao;
import com.spring.service.TransferService;

/**
 * @author sfx
 * @Description
 */
public class TransferServiceImpl implements TransferService {

  private AccountDao accountDao;

  public AccountDao getAccountDao() {
    return accountDao;
  }

  public void setAccountDao(AccountDao accountDao) {
    this.accountDao = accountDao;
  }


  @Override
  public void transfer(String fromCardNo, String toCardNo, int money) {
    accountDao.transfer(fromCardNo, toCardNo, money);
  }
}
