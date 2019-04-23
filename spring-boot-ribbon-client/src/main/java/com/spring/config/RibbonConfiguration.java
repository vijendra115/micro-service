package com.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;

/**
 * The Class RibbonConfiguration.
 *
 * @author Navneet Goyal
 */
public class RibbonConfiguration {

    /** The config. */
    @Autowired
    IClientConfig config;

    /**
     * Ribbon ping.
     *
     * @param config the config
     * @return the i ping
     */
    @Bean
    public IPing ribbonPing(final IClientConfig config) {
        return new PingUrl();
    }

    /**
     * Ribbon rule.
     *
     * @param config the config
     * @return the i rule
     */
    @Bean
    public IRule ribbonRule(final IClientConfig config) {
        return new AvailabilityFilteringRule();
    }
}
