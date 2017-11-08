package com.dyh.es.client;

import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;

/**
 * @author dyh
 * @created at 2017 09 20 13:13
 */
public class EsRestClient {
    public static void main(String[] args) {
        RestClientBuilder builder = RestClient.builder(new HttpHost("localhost",9200,"http"));
        builder.setFailureListener(new RestClient.FailureListener(){
            @Override
            public void onFailure(HttpHost host) {
                super.onFailure(host);
            }
        });



        RestClient restClient = builder.build();

        RestHighLevelClient client = new RestHighLevelClient(restClient);

        //Index api start...

        IndexRequest indexRequest = new IndexRequest(
                "posts",       //index
                "doc",         //type
                "1"             //id
        );




    }
}
