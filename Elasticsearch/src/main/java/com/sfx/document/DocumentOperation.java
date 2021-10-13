package com.sfx.document;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sfx.pojo.User;
import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.get.GetResult;

/**
 * @author sfx
 */
public class DocumentOperation {


  public static final RestHighLevelClient CLIENT;

  public static void main(String[] args) throws Exception {
    deleteDoc();
  }

  static {
    CLIENT = new RestHighLevelClient(RestClient.builder(new HttpHost("localhost", 9200, "http")));
  }


  //新增文档
  public static void crateDoc() throws Exception {
    IndexRequest request = new IndexRequest("user");
    request.id("1");
    User user = new User("sfx", '男', 25);
    String userStr = JSON.toJSONString(user);
    request.source(userStr, XContentType.JSON);
    IndexResponse response = CLIENT.index(request, RequestOptions.DEFAULT);
    System.out.println(response.getIndex());
    System.out.println(response.getId());
    System.out.printf(response.toString());
    CLIENT.close();

  }


  //批量新增
  public static void batchCreate() throws Exception{
    BulkRequest request = new BulkRequest();
    User user = new User("sfx", '男', 20);
    User user1 = new User("qy", '女', 20);
    User user2 = new User("hh", '男', 20);

    request.add(new IndexRequest("user").id("2").source(JSON.toJSONString(user)));
    request.add(new IndexRequest("user").id("3").source(JSON.toJSONString(user1)));
    request.add(new IndexRequest("user").id("4").source(JSON.toJSONString(user2)));
    BulkResponse bulk = CLIENT.bulk(request, RequestOptions.DEFAULT);
    System.out.printf(bulk.toString());
  }


  //删除文档
  public static void deleteDoc() throws Exception {
    DeleteRequest request = new DeleteRequest("user");
    request.id("1");
    DeleteResponse delete = CLIENT.delete(request, RequestOptions.DEFAULT);
    System.out.println(delete.getIndex());
    System.out.println(delete);
    CLIENT.close();
  }


  //修改文档
  public static void updateDoc() throws Exception {
    UpdateRequest request = new UpdateRequest();
    request.index("user").id("1");
    request.doc(XContentType.JSON, "age", 18);
    UpdateResponse response = CLIENT.update(request, RequestOptions.DEFAULT);
    GetResult getResult = response.getGetResult();
    System.out.println(getResult);
    CLIENT.close();
  }


  //根据id查询
  public static void query() throws Exception {
    GetRequest request = new GetRequest("user");
    request.id("1");
    GetResponse response = CLIENT.get(request, RequestOptions.DEFAULT);
    System.out.println(response.toString());
    CLIENT.close();
  }


  //高级查询


}
