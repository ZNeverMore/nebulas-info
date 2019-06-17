package com.bester.nebulasinfo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.bester.nebulasinfo.dao")
@SpringBootApplication
public class NebulasInfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(NebulasInfoApplication.class, args);
    }

}
