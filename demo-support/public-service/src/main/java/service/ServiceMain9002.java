package service;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class ServiceMain9002 {
    public static void main(String[] args) {
        SpringApplication.run(ServiceMain9002.class, args);
    }
}
