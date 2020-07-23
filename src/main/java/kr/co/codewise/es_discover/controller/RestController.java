package kr.co.codewise.es_discover.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @GetMapping("/")
    public Object index(){
        Logger LOG = LoggerFactory.getLogger(RestController.class);

        LOG.info("index do..");

        return "test";
    }

}
