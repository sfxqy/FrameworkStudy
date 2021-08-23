package com.sfx.rabbitmq.one;

import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

/**
 * @author sfx
 */
public class Consumer {


  public static void main(String[] args) throws Exception{
    String QUEUE_NAME="QUEUE_NAME";
    // 创建一个连接工厂
    ConnectionFactory connectionFactory = new ConnectionFactory();
    connectionFactory.setHost("1.15.232.202");
    connectionFactory.setUsername("admin");
    connectionFactory.setPassword("123");
    connectionFactory.setPort(5672);

    //创建一个连接
    Connection connection = connectionFactory.newConnection();
    //创建一个信道
    Channel channel = connection.createChannel();
    DeliverCallback deliverCallback=(consumerTag,message)->{
      System.out.println(new String(message.getBody()));
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
    channel.basicConsume(QUEUE_NAME,true,deliverCallback,cancelCallback);
  }

}
