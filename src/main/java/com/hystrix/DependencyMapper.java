package com.hystrix;

import com.hystrix.config.HystrixExampleConfiguration;
import com.hystrix.resource.CurrencyConversionResource;
import com.hystrix.thirdparty.SlowServerClient;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

import javax.ws.rs.client.Client;

public class DependencyMapper extends AbstractBinder {

    private final Client slowServerHttpClient;
    private final HystrixExampleConfiguration applicationConfig;

    public DependencyMapper(Client slowServerHttpClient, HystrixExampleConfiguration applicationConfig){
        this.slowServerHttpClient = slowServerHttpClient;
        this.applicationConfig = applicationConfig;
    }

    @Override
    protected void configure() {
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.disable(SerializationFeature.WRITE_NULL_MAP_VALUES);
//        mapper.disable(SerializationFeature.WRITE_EMPTY_JSON_ARRAYS);
//        mapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, false);
//
//        bind(mapper).to(ObjectMapper.class);
        bind(slowServerHttpClient).to(Client.class);
        bind(applicationConfig.getSlowServer().getUrl()).named("slowServerUrl").to(String.class);
        bindAsContract(SlowServerClient.class);
        bindAsContract(CurrencyConversionResource.class);
    }
}
