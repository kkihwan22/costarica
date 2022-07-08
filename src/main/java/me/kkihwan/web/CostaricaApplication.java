package me.kkihwan.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication @ServletComponentScan
public class CostaricaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CostaricaApplication.class, args);
    }

}
