package com.hystrix.resource;


import com.hystrix.request.CurrencyConversionRequest;
import org.jvnet.hk2.annotations.Service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Service
@Path("currency")
public class CurrencyConversionResource {

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response convertCurrency(CurrencyConversionRequest request){
        System.out.print(request.getAmount());
        return Response.status(Response.Status.OK).build();
    }
}
