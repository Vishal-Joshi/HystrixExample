package com.hystrix.config;

import io.dropwizard.Configuration;

public class HystrixExampleConfiguration extends Configuration {

    private SlowServerConfig slowServer;

    public SlowServerConfig getSlowServer() {
        return slowServer;
    }
}
