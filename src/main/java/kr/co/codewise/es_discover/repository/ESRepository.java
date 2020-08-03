package kr.co.codewise.es_discover.repository;

import kr.co.codewise.es_discover.entity.ESResponse;
import org.elasticsearch.client.Response;

import java.io.IOException;

public interface ESRepository<T> {

    ESResponse restCall() throws IOException;

}
