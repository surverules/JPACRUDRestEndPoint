package com.wmbanking.ms.Application.models;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CollectionList {

    @Autowired
    private List<String> names;

    public void printNames() {
        System.out.println(names);
    }
}
