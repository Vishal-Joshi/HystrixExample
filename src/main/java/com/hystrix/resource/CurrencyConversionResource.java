package com.hystrix.resource;


import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("currency")
public class CurrencyConversionResource {

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response convertCurrency(){
        return Response.status(Response.Status.OK).build();
    }
}
