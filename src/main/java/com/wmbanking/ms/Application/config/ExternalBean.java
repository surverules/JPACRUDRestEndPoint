package com.wmbanking.ms.Application.config;

import com.wmbanking.ms.Application.models.CollectionList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class ExternalBean {

    @Bean
    public CollectionList collectionListBean(){
        return new CollectionList();
    }

    @Bean
    public List<String> stringList()
    {
        return Arrays.asList("sachin", "surve");
    }

}
