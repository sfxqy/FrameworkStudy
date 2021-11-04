package com.sfx.rabbitmq.three;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.sfx.rabbitmq.utils.ChannelUtils;
import java.util.Scanner;

/**
 * @author sfx
 * @Description 消息应答
 */
public class Producer {

  final static String QUEUE_NAME = "basicAck";

  public static void main(String[] args) throws Exception{
    Channel channel = ChannelUtils.createChannel();
    channel.queueDeclare(QUEUE_NAME,true,false,false,null);
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNext()){
      String msg = scanner.next();
      channel.basicPublish("",QUEUE_NAME,null,msg.getBytes());
      System.out.println("消息发送成功");
    }

  }



}
