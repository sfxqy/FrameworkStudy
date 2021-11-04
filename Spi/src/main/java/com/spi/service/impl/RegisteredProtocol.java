package com.spi.service.impl;

import com.spi.service.Protocol;

/**
 * @author sfx
 * @Description
 */
public class RegisteredProtocol implements Protocol {

  @Override
  public void describe() {
    System.out.println("registered protocol");
  }
}
