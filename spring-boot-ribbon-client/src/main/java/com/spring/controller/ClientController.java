package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * The Class ClientController.
 *
 * @author Navneet Goyal
 */
@RestController
public class ClientController {

    /** The rest template. */
    @Autowired
    RestTemplate restTemplate;

    /**
     * Echo student name.
     *
     * @param name the name
     * @return the string
     */
    @RequestMapping(
        value = "/echoStudentName/{name}")
    public String echoStudentName(@PathVariable final String name) {
        System.out.println("Getting Student details for " + name);
        return restTemplate.exchange("http://student-service/echoStudentName/{name}", HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
        }, name).getBody();
    }

    /**
     * Gets the school details.
     *
     * @param schoolname the schoolname
     * @return the school details
     */
    @RequestMapping(
        value = "/getSchoolDetails/{schoolname}")
    public String getSchoolDetails(@PathVariable final String schoolname) {
        System.out.println("Getting School details for " + schoolname);
        return restTemplate.exchange("http://school-service/getSchoolDetails/{schoolname}", HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
        }, schoolname).getBody();
    }

    /**
     * Rest template.
     *
     * @return the rest template
     */
    @LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
