package service;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/*
Author: Yang Zhou
Date: 2022-6-26
Description: The module for students to plan their course-schedule and enroll in courses
 */

@EnableDubbo
@SpringBootApplication
@MapperScan("dao.mapper")
@EnableAsync
public class ServiceMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(ServiceMain9001.class,args);
    }
}
