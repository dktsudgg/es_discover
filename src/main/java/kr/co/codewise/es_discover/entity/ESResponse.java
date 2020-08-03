package kr.co.codewise.es_discover.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class ESResponse {

    @Id
    String hashStr;

    String responseBody;

    @Builder
    public ESResponse(String hashStr, String responseBody){
        this.hashStr = hashStr;
        this.responseBody = responseBody;
    }

}
