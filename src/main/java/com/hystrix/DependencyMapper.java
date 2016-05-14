package com.hystrix;

import com.hystrix.config.HystrixExampleConfiguration;
import com.hystrix.resource.CurrencyConversionResource;
import com.hystrix.resource.CurrencyConversionResourceAidedWithHystrix;
import com.hystrix.thirdparty.CurrencyRateServiceClient;
import com.hystrix.thirdparty.CurrencyRateServiceClientWithoutHystrix;
import com.hystrix.thirdparty.CurrencyRateServiceClientAidedWithHystrix;
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
        bind(slowServerHttpClient).to(Client.class);
        bind(applicationConfig.getSlowServer().getUrl()).named("slowServerUrl").to(String.class);
        bind(CurrencyRateServiceClientWithoutHystrix.class).to(CurrencyRateServiceClient.class).named("clientWithNoHystrixAid");
        bind(CurrencyRateServiceClientAidedWithHystrix.class).to(CurrencyRateServiceClient.class).named("clientWithHystrixAid");
        bindAsContract(CurrencyConversionResource.class);
        bindAsContract(CurrencyConversionResourceAidedWithHystrix.class);
    }
}
