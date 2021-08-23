package com.sfx.rabbitmq.utils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @author sfx
 */
public class ChannelUtils {



  public static Channel createChannel()throws Exception{
    ConnectionFactory connection = new ConnectionFactory();
    connection.setHost("1.15.232.202");
    connection.setUsername("admin");
    connection.setPassword("123");
    connection.setPort(5672);
    Connection conn = connection.newConnection();
    Channel channel = conn.createChannel();
    return channel;
  }

}
