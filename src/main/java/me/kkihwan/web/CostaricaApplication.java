package me.kkihwan.web;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.web.servlet.*;

@SpringBootApplication @ServletComponentScan
public class CostaricaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CostaricaApplication.class, args);
    }

}
