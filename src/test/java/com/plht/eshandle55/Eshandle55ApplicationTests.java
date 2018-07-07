package com.plht.eshandle55;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Eshandle55ApplicationTests {


    @Autowired
    private ExpSearchRepository expSearchRepository;

    @Test
    public void contextLoads() {
        Exp exp = new Exp();
    }

}
