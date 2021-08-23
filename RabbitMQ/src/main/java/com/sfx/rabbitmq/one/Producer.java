package com.sfx.rabbitmq.one;

import com.rabbitmq.client.AMQP.Queue.DeclareOk;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @author sfx
 * 生产者：发消息
 */
public class Producer {



  public static void main(String[] args)throws Exception{
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
    /**
     * 生成队列
     * 1、队列名称
     * 2、队列里面的消息是否持久化，默认消息是存放在内存中
     * 3、该队列是否进行消息共享，true可以多个消费者消费，false：一个消费者消费
     * 4、是否自动删除，最后一个消费者断开连接以后该队列是否自动删除，true表示自动删除，false不自动删除
     * 5、其他参数（）
     */
    channel.queueDeclare(QUEUE_NAME, false, false, false, null);
    String msg="hello world";
    /**
     * 1、发送到哪个交换机
     * 2、路由的key值是哪个，本次是队列的名称
     * 3、其他参数信息
     * 4、发送的消息的数据
     */
    channel.basicPublish("",QUEUE_NAME,null,msg.getBytes());
    System.out.println("消息发送成功");
  }

}
