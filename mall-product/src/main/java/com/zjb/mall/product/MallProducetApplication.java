package com.zjb.mall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

// 放开注册中心
@EnableDiscoveryClient
@SpringBootApplication
// 指定Mapper接口对应的路径
@MapperScan("com.zjb.mall.product.dao")
public class MallProducetApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallProducetApplication.class, args);
    }

}
