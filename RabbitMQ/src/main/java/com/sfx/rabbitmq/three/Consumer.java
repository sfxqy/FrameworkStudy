package com.sfx.rabbitmq.three;

import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.sfx.rabbitmq.utils.ChannelUtils;

/**
 * @author sfx
 */
public class Consumer {

  public static void main(String[] args) throws Exception{
    String QUEUE_NAME="QUEUE_NAME";
    Channel channel = ChannelUtils.createChannel();
    DeliverCallback deliverCallback=(consumerTag,message)->{
      System.out.println(new String(message.getBody()));
      channel.basicAck(message.getEnvelope().getDeliveryTag(),false);
      System.out.println("消息应答");
    };
    CancelCallback cancelCallback=consumerTag->{
      System.out.println("消费中断");
    };
    /**
     * 消费者消费消息
     * 1、消费哪个队列
     * 2、消费成功之后是否要自动应答，true代表自动应答，false代表手动应答
     * 3、消费者接受消息的回调
     * 4、消费者取消消费的回调
     */
    System.out.println(Thread.currentThread().getId());
    channel.basicConsume(QUEUE_NAME,false,deliverCallback,cancelCallback);
  }

}
