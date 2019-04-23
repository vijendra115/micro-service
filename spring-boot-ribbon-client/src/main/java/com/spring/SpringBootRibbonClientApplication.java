package com.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.spring.config.RibbonConfiguration;

@EnableDiscoveryClient
@RibbonClient(
    name = "ribbon client",
    configuration = RibbonConfiguration.class)
@SpringBootApplication
public class SpringBootRibbonClientApplication {

    public static void main(final String[] args) {
        SpringApplication.run(SpringBootRibbonClientApplication.class, args);
    }
}
