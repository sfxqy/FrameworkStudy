package com.sfx.config;


import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RequestOptions.Builder;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

@Configurable
public class EsConfig {



  public static final RequestOptions options;

  static {
    Builder builder = RequestOptions.DEFAULT.toBuilder();
    options=builder.build();
  }


  @Bean
  public RestHighLevelClient getEsClient()throws Exception{
    RestHighLevelClient client =
        new RestHighLevelClient(RestClient.builder(new HttpHost("127.0.0.1", 9200, "http")));
    return client;
  }

}
