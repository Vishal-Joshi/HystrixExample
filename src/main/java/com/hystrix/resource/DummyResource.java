package com.hystrix.resource;

import org.jvnet.hk2.annotations.Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Service
@Path("dummy")
public class DummyResource {

    @GET
    @Produces("application/json")
    public Response doSomething(){
        return Response.ok().build();
    }


}
