/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

/**
 *
 * @author admin
 */
public class AppUtils {

    public static String HashID(String articleContent) {
        return String.valueOf(articleContent.hashCode());
    }
    
    public static RestHighLevelClient restHighLevelClient() {
        return new RestHighLevelClient(
        RestClient.builder(
                new HttpHost("localhost", 9200, "http"),
                new HttpHost("localhost", 9201, "http")));
        
    }

}
