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
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.get.GetResult;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortOrder;

/**
 * @author sfx
 */
public class DocumentOperation {


  public static final RestHighLevelClient CLIENT;


  static {
    CLIENT = new RestHighLevelClient(RestClient.builder(new HttpHost("localhost", 9200, "http")));
  }


  //新增文档
  public static void crateDoc() throws Exception {
    IndexRequest request = new IndexRequest("user");
    request.id("3");
    User user = new User("宋飞翔", '男', 20);
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
  public static void main(String[] args) throws Exception {
    queryPage();
  }

  //查询所有
  public static void queryAll()throws Exception{
    SearchRequest request = new SearchRequest("user");
    SearchSourceBuilder builder = new SearchSourceBuilder();
    builder.query(QueryBuilders.matchAllQuery());
    request.source(builder);
    SearchResponse response = CLIENT.search(request, RequestOptions.DEFAULT);
    System.out.printf("------------------------------------");
    show(response);
    CLIENT.close();
  }

  //term查找
  public static void queryTerm()throws Exception{
    SearchRequest request = new SearchRequest("user");
    SearchSourceBuilder builder = new SearchSourceBuilder();
    builder.query(QueryBuilders.termQuery("age","20"));
    request.source(builder);
    SearchResponse response = CLIENT.search(request,RequestOptions.DEFAULT);
    System.out.printf("------------------------------------");
    show(response);
    CLIENT.close();
  }


  //match查找
  public static void queryMatch()throws Exception{
    SearchRequest request = new SearchRequest("user");
    SearchSourceBuilder builder = new SearchSourceBuilder();
    builder.query(QueryBuilders.matchQuery("name","飞"));
    request.source(builder);
    SearchResponse response = CLIENT.search(request, RequestOptions.DEFAULT);
    System.out.printf("------------------------------------");
    show(response);
    CLIENT.close();
  }


  //match查找
  public static void queryPage()throws Exception{
    SearchRequest request = new SearchRequest("user");
    SearchSourceBuilder builder = new SearchSourceBuilder();
    builder.query(QueryBuilders.matchQuery("name","飞"));
    builder.from(1);
    builder.size(1);
    request.source(builder);
    SearchResponse response = CLIENT.search(request, RequestOptions.DEFAULT);
    System.out.printf("------------------------------------");
    show(response);
    CLIENT.close();
  }

  //排序查找
  public static void sort()throws Exception{
    SearchRequest request = new SearchRequest("user");
    SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
    searchSourceBuilder.query(QueryBuilders.matchAllQuery());
    searchSourceBuilder.sort("age", SortOrder.DESC);
    request.source(searchSourceBuilder);
    CLIENT.search(request,RequestOptions.DEFAULT);
  }


  //bool查询
  public static void bool()throws Exception{
    SearchRequest request = new SearchRequest();
    SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
    BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
    boolQueryBuilder.must(QueryBuilders.matchQuery("name","fx"));
    boolQueryBuilder.mustNot(QueryBuilders.termQuery("age",20));
    searchSourceBuilder.query(boolQueryBuilder);
    request.source(searchSourceBuilder);
    CLIENT.search(request,RequestOptions.DEFAULT);

  }


  //范围查询
  public static void rangeQuery()throws Exception{
    SearchRequest request = new SearchRequest("user");
    SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
    RangeQueryBuilder range = QueryBuilders.rangeQuery("age");
    range.gte(18);
    range.lte(35);
    request.source(searchSourceBuilder);
    CLIENT.search(request,RequestOptions.DEFAULT);
  }


  public static void hightLight(){
    SearchRequest request = new SearchRequest("user");
    SearchSourceBuilder builder = new SearchSourceBuilder();
    builder.query(QueryBuilders.matchAllQuery());
    HighlightBuilder highlightBuilder = new HighlightBuilder();
    highlightBuilder.postTags("</>")
  }

  public static void show(SearchResponse response ){
    SearchHit[] hits = response.getHits().getHits();
    for (int i=0;i<hits.length;i++){
      System.out.println(hits[i]);
    }
  }





  public static void create()throws Exception{
    IndexRequest request = new IndexRequest("user");
    User user = new User("sfx", '男', 20);
    request.source(JSON.toJSONString(user));
    CLIENT.index(request,RequestOptions.DEFAULT);

  }
  public static void delete()throws Exception{
    DeleteRequest request = new DeleteRequest("user");
    request.id("1");
    CLIENT.delete(request,RequestOptions.DEFAULT);
  }

  public static void update1()throws Exception{
    UpdateRequest request = new UpdateRequest();
    request.index("user");
    request.doc("name","songfeixiang");
    CLIENT.update(request,RequestOptions.DEFAULT);
  }

  public static void get()throws Exception{
    GetRequest request = new GetRequest("user");
    request.id("1");
    CLIENT.get(request,RequestOptions.DEFAULT);
  }


  public static void queryAll1()throws Exception{
    SearchRequest request = new SearchRequest("user");
    SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
    searchSourceBuilder.query(QueryBuilders.matchAllQuery());
    request.source(searchSourceBuilder);
    CLIENT.search(request,RequestOptions.DEFAULT);
  }

  public static void match

}
