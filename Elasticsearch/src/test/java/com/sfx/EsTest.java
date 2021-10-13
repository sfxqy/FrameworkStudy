package com.sfx;


import org.elasticsearch.client.RestHighLevelClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EsTest {

  @Autowired
  private RestHighLevelClient client;

  @Test
  public void test1(){
    System.out.printf("======================");
    System.out.printf(String.valueOf(client==null));
  }

}
