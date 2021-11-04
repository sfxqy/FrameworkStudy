package com.spi.service.impl;

import com.spi.service.Protocol;

/**
 * @author sfx
 * @Description
 */
public class DubboProtocol implements Protocol {

  @Override
  public void describe() {
    System.out.println("dubbo protocol");
  }
}
