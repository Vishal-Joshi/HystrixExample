package com.hystrix;

import com.hystrix.resource.CurrencyConversionResource;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

public class DependencyMapper extends AbstractBinder {
    @Override
    protected void configure() {
        bindAsContract(CurrencyConversionResource.class);
    }
}
