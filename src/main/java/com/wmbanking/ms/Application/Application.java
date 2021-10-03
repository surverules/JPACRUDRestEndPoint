package com.wmbanking.ms.Application;

import com.wmbanking.ms.Application.models.CollectionList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationContextFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Application implements ApplicationRunner {

    @Autowired
    ApplicationContext applicationContext;



    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        CollectionList collectionList = applicationContext.getBean(CollectionList.class);
        collectionList.printNames();
    }

}
