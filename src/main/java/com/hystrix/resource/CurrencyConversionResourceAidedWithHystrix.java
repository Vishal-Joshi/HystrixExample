package com.hystrix.resource;

import com.hystrix.requestResponse.CurrencyConversionRequest;
import com.hystrix.requestResponse.CurrencyConversionResponse;
import com.hystrix.thirdparty.CurrencyRateServiceClient;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Service
@Path("currencyWithHystrix")
public class CurrencyConversionResourceAidedWithHystrix {
    private CurrencyRateServiceClient client;

    @Inject
    public CurrencyConversionResourceAidedWithHystrix(@Named("clientWithHystrixAid") CurrencyRateServiceClient client){
        this.client = client;
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response convertCurrency(CurrencyConversionRequest request){
        CurrencyConversionResponse response;
        try{
            response = new CurrencyConversionResponse(client.getCurrentCurrencyConversionRate(request.getCurrency()).getRate()*request.getAmount(), request.getCurrency(), request.getAmount());
            return Response.status(Response.Status.OK).entity(response).build();
        } catch(Exception exception){
            if(exception instanceof NotFoundException){
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            return Response.status(Response.Status.BAD_GATEWAY).build();
        }
    }
}
