package kr.co.codewise.es_discover.repository;

import kr.co.codewise.es_discover.entity.ESResponse;
import org.elasticsearch.client.Response;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ESRestRepository extends JpaRepository<ESResponse, String>, ESRepository<ESResponse> {
}
