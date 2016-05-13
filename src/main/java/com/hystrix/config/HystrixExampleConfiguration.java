package com.hystrix.config;

import io.dropwizard.Configuration;
import io.dropwizard.client.JerseyClientConfiguration;

public class HystrixExampleConfiguration extends Configuration {

    private SlowServerConfig slowServer;
    private JerseyClientConfiguration httpClient;

    public SlowServerConfig getSlowServer() {
        return slowServer;
    }

    public JerseyClientConfiguration getHttpClient() {
        return httpClient;
    }
}
