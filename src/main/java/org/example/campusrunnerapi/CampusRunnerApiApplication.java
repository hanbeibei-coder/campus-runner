package org.example.campusrunnerapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.example.campusrunnerapi.mapper")
public class CampusRunnerApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(CampusRunnerApiApplication.class, args);
    }
}

