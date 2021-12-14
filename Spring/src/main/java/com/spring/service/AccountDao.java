package com.spring.service;

/**
 * @author sfx
 * @Description
 */
public interface AccountDao {



  void transfer(String fromCardNo, String toCardNo, int money);


}
