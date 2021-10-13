package com.sfx.controller;


import com.alibaba.fastjson.JSON;
import com.sfx.config.EsConfig;
import com.sfx.pojo.Student;
import javax.annotation.Resource;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EsController {


  @Resource
  private RestHighLevelClient client;


  @RequestMapping("/create")
  public IndexResponse createDoc()throws Exception{
    IndexRequest request = new IndexRequest("student");
    request.id("1");
    Student student = new Student("宋飞翔", 20, "一班");
    String stu = JSON.toJSONString(student);
    request.source(stu);
    IndexResponse index = client.index(request, EsConfig.options);
    return index;
  }
}
