package com.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
class MessageRestController {

    @Value("${msg:Hello world - Config Server is not working..please check}")
    private String msg;

    @RequestMapping("/msg")
    String getMsg() {
        return msg;
    }
}

/**
 * The Class SpringBootConfigClientApplication.
 *
 * @author Navneet Goyal
 */
@SpringBootApplication
public class SpringBootConfigClientApplication {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {
        SpringApplication.run(SpringBootConfigClientApplication.class, args);
    }
}
