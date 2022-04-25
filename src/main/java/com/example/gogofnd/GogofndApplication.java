package com.example.gogofnd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SpringBootApplication
public class GogofndApplication {

    @PersistenceContext
    @Autowired
    private EntityManager entityManager;

    public static void main(String[] args) {
        SpringApplication.run(GogofndApplication.class, args);
    }

}
