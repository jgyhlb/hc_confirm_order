package com.hclg.student;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.hclg")
public class StudentApp {
    public static void main(String[] args) {
        SpringApplication.run(StudentApp.class,args);
    }
}
