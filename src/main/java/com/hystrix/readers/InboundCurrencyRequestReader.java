package com.hystrix.readers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.hystrix.request.CurrencyConversionRequest;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

@Service
@Provider
@Consumes("application/json")
public class InboundCurrencyRequestReader implements MessageBodyReader<CurrencyConversionRequest> {

    private ObjectReader objectReader;

    @Inject
    public InboundCurrencyRequestReader(){
        this.objectReader = new ObjectMapper().readerFor(CurrencyConversionRequest.class);
    }


    @Override
    public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return type.equals(CurrencyConversionRequest.class);
    }

    @Override
    public CurrencyConversionRequest readFrom(Class<CurrencyConversionRequest> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, String> httpHeaders, InputStream entityStream) throws IOException, WebApplicationException {
        return objectReader.readValue(entityStream);
    }
}
