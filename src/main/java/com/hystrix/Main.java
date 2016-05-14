package com.hystrix;

import com.hystrix.config.HystrixExampleConfiguration;
import io.dropwizard.Application;
import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.jersey.setup.JerseyEnvironment;
import io.dropwizard.setup.Environment;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.utilities.ServiceLocatorUtilities;

import javax.ws.rs.client.Client;
import java.util.Objects;
import java.util.Set;

public class Main extends Application<HystrixExampleConfiguration> {

    public static void main(String[] args) throws Exception {
        new Main().run(args);
    }

    @Override
    public void run(HystrixExampleConfiguration configuration, Environment environment) throws Exception {
        Client client = new JerseyClientBuilder(environment).using(configuration.getHttpClient()).build("slowServerClient");
        ServiceLocator serviceLocator = ServiceLocatorUtilities.bind(new DependencyMapper(client, configuration));
        JerseyEnvironment jersey = environment.jersey();
        jersey.packages("com.hystrix");
        Set<Class<?>> classes = jersey.getResourceConfig().getClasses();
        classes.stream().map(p -> serviceLocator.getService(p))
                .filter(Objects::nonNull)
                .forEach(jersey::register);
    }
}
