package com.sggw.itemsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class ItemsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItemsServiceApplication.class, args);
    }

}
