package com.sfx.document;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sfx.pojo.User;
import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
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


  public static void main(String[] args) throws Exception{
    deleteDoc();
  }


  public static void crateDoc()throws Exception{
    RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("localhost", 9200, "http")));
    IndexRequest request = new IndexRequest();
    request.index("user").id("1");
    User user = new User("sfx", '男', 25);
    ObjectMapper objectMapper = new ObjectMapper();
    String userStr = objectMapper.writeValueAsString(user);
    request.source(userStr, XContentType.JSON);
    IndexResponse response = client.index(request, RequestOptions.DEFAULT);
    System.out.println(response.getIndex());
    System.out.println(response.getId());
    client.close();

  }

  public static void batchCreate(){
    BulkRequest request = new BulkRequest();
  }


  public static void deleteDoc()throws Exception{
    RestHighLevelClient client = new RestHighLevelClient(
        RestClient.builder(new HttpHost("localhost", 9200, "http")));
    DeleteRequest request = new DeleteRequest().index("user").id("1");
    DeleteResponse delete = client.delete(request, RequestOptions.DEFAULT);
    System.out.println(delete.getIndex());
    System.out.println(delete);
    client.close();
  }

  public static void updateDoc()throws Exception{
    RestHighLevelClient client = new RestHighLevelClient(
        RestClient.builder(new HttpHost("localhost", 9200, "http")));
    UpdateRequest request = new UpdateRequest();
    request.index("user").id("1");
    request.doc(XContentType.JSON,"age",18);
    UpdateResponse response = client.update(request, RequestOptions.DEFAULT);
    GetResult getResult = response.getGetResult();
    System.out.println(getResult);
    client.close();
  }


  public static void query()throws Exception{
    RestHighLevelClient client = new RestHighLevelClient(
        RestClient.builder(new HttpHost("localhost", 9200, "http")));
    GetRequest request = new GetRequest().index("user").id("1");
    GetResponse response = client.get(request, RequestOptions.DEFAULT);
    System.out.println(response.toString());
    client.close();
  }

}
