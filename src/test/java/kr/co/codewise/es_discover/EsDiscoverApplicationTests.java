package kr.co.codewise.es_discover;

import kr.co.codewise.es_discover.repository.ESRestRepository;
import kr.co.codewise.es_discover.util.Dummy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

//@RunWith(SpringRunner.class)
//@DataJpaTest
@SpringBootTest
class EsDiscoverApplicationTests {

    @Autowired
    ESRestRepository esRestRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void customEsJpaTest() throws IOException {
        String responseBody = esRestRepository.restCall().getResponseBody();
        System.out.println("responseBody::" + responseBody);
        System.out.println("~~~");

        Dummy dummy = new Dummy();
        dummy.runDummy(()->{
            System.out.println("ddddd");
        });
    }

}
