package com.sfx.indexes;

import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;

/**
 * @author sfx
 */
public class IndexesOperation {


  public static void main(String[] args)throws Exception {
    create();
 // get();
//      delete();
  }



  //创建索引
  public static void create()throws Exception{
    RestHighLevelClient client = new RestHighLevelClient(
        RestClient.builder(new HttpHost("127.0.0.1", 9200, "http")));
    CreateIndexRequest request = new CreateIndexRequest("user");
    CreateIndexResponse response = client.indices()
        .create(request, RequestOptions.DEFAULT);
    boolean acknowledged = response.isAcknowledged();
    System.out.println(acknowledged);
    client.close();
  }

  //查看索引
  public static void get()throws Exception{
    RestHighLevelClient client = new RestHighLevelClient(
        RestClient.builder(new HttpHost("127.0.0.1", 9200, "http")));
    GetIndexRequest request = new GetIndexRequest("user");
    GetIndexResponse response = client.indices().get(request, RequestOptions.DEFAULT);
    System.out.println(response.getAliases());
    System.out.println(response);
    client.close();
  }


  //删除索引
  public static void delete()throws Exception{
    RestHighLevelClient client = new RestHighLevelClient(
        RestClient.builder(new HttpHost("localhost", 9200, "http")));
    DeleteIndexRequest request = new DeleteIndexRequest("user");
    AcknowledgedResponse delete = client.indices().delete(request, RequestOptions.DEFAULT);
    System.out.println(delete.isAcknowledged());
    System.out.println(delete);
    client.close();
  }


}
