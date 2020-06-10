package com.zb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * XcEurekaServerApp: Eureka注册中心  Port:7001
 */
@SpringBootApplication
@EnableEurekaServer
public class XcEurekaServerApp {
    public static void main(String[] args) {
        SpringApplication.run(XcEurekaServerApp.class, args);
    }
}
