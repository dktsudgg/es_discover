package kr.co.codewise.es_discover.controller;

import org.apache.http.HttpHost;
import org.apache.http.entity.ContentType;
import org.apache.http.nio.entity.NStringEntity;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @GetMapping("/test")
    public Object test() throws IOException {
        Logger LOG = LoggerFactory.getLogger(RestController.class);

        RestClient ESClients = RestClient.builder(
                new HttpHost( "localhost", 9200, "http")
        ).build();

        Request request = new Request("GET", "/kibana_sample_data_ecommerce/_search");
        request.setEntity(new NStringEntity(
                "{\n" +
                        "  \"query\": {\n" +
                        "    \"match_all\": {}\n" +
                        "  }\n" +
                        "}",
                ContentType.APPLICATION_JSON));

        Response response = null;
        try {
            response = ESClients.performRequest(request);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String responseBody = EntityUtils.toString(response.getEntity());

        return responseBody;
    }

    @GetMapping("/test222")
    public Object test222(){
        return "test222";
    }


}
