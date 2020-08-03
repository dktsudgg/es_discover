package kr.co.codewise.es_discover.repository;

import kr.co.codewise.es_discover.entity.ESResponse;
import org.apache.http.HttpHost;
import org.apache.http.entity.ContentType;
import org.apache.http.nio.entity.NStringEntity;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.springframework.stereotype.Repository;

import java.io.IOException;

@Repository
public class ESRepositoryImpl implements ESRepository {

    static RestClient ESClients = RestClient.builder(
            new HttpHost( "localhost", 9200, "http")
    ).build();

    @Override
    public ESResponse restCall() {
        try{
            Request request = new Request("GET", "/kibana_sample_data_ecommerce/_search");
            request.setEntity(new NStringEntity(
                    "{\n" +
                            "  \"query\": {\n" +
                            "    \"match_all\": {}\n" +
                            "  }\n" +
                            "}",
                    ContentType.APPLICATION_JSON));

            Response response = ESClients.performRequest(request);

//            response.getEntity()

            String responseBody = EntityUtils.toString(response.getEntity());

            return ESResponse.builder().hashStr(responseBody.hashCode()+"").responseBody(responseBody).build();
        } catch(Exception e){
            throw new RuntimeException("엘라스틱 서치 rest중 에러 발생..");
        }
    }

}
