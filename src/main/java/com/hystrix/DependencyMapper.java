package com.hystrix;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.hystrix.readers.InboundCurrencyRequestReader;
import com.hystrix.resource.CurrencyConversionResource;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

public class DependencyMapper extends AbstractBinder {
    @Override
    protected void configure() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(SerializationFeature.WRITE_NULL_MAP_VALUES);
        mapper.disable(SerializationFeature.WRITE_EMPTY_JSON_ARRAYS);
        mapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, false);

        bind(mapper).to(ObjectMapper.class);
        bindAsContract(CurrencyConversionResource.class);
        bindAsContract(InboundCurrencyRequestReader.class);
    }
}
