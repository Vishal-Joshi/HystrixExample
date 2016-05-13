package com.hystrix;

import com.hystrix.config.HystrixExampleConfiguration;
import io.dropwizard.Application;
import io.dropwizard.jersey.setup.JerseyEnvironment;
import io.dropwizard.setup.Environment;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.utilities.ServiceLocatorUtilities;

import java.util.Objects;
import java.util.Set;

public class Main extends Application<HystrixExampleConfiguration> {

    public static void main(String[] args) throws Exception {
        new Main().run(args);
    }

    @Override
    public void run(HystrixExampleConfiguration configuration, Environment environment) throws Exception {
        System.out.println(String.format("timeout: %d", configuration.getSlowServer().getTimeout()));
        System.out.println(String.format("url: %s", configuration.getSlowServer().getUrl()));
        ServiceLocator serviceLocator = ServiceLocatorUtilities.bind(new DependencyMapper());
        JerseyEnvironment jersey = environment.jersey();
        jersey.packages("com.hystrix.resource");
    }
}
