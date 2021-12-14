package com.spring.service;

/**
 * @author sfx
 * @Description
 */
public interface TransferService {


  void transfer(String fromCardNo, String toCardNo, int money);
}
