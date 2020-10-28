package com.hclg.hc_confirm_order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hclg.hc_confirm_order.dao")
public class HcConfirmOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(HcConfirmOrderApplication.class, args);
    }

}
