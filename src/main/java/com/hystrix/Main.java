package com.hystrix;

import com.hystrix.config.HystrixExampleConfiguration;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class Main extends Application<HystrixExampleConfiguration> {

    public static void main(String[] args) throws Exception {
        new Main().run(args);
    }

    @Override
    public void run(HystrixExampleConfiguration configuration, Environment environment) throws Exception {
        System.out.println(String.format("timeout: %d", configuration.getSlowServer().getTimeout()));
        System.out.println(String.format("url: %s", configuration.getSlowServer().getUrl()));
    }
}
