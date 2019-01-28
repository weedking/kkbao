package com.kk.kkbao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.kk.kkbao.dao")
@SpringBootApplication
public class KkbaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(KkbaoApplication.class, args);
    }

}

