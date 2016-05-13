package com.hystrix.resource;


import com.hystrix.requestResponse.CurrencyConversionRequest;
import com.hystrix.thirdparty.SlowServerClient;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Service
@Path("currency")
public class CurrencyConversionResource {

    private SlowServerClient client;

    @Inject
    public CurrencyConversionResource(SlowServerClient client){
        this.client = client;
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response convertCurrency(CurrencyConversionRequest request){
        System.out.print(client.getCurrentCurrencyConversionRate(request.getCurrency()).getRate()*request.getAmount());
        return Response.status(Response.Status.OK).build();
    }
}
