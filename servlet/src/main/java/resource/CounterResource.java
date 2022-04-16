package resource;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/counter")
public class CounterResource {

    @GET
    public Response getCounter(){
        return Response
                .status(Response.Status.OK)
                .entity("The counter is: " + Counter.getCounter())
                .build();
    }

    @POST
    public Response postCounter(){
        Counter.setCounter();
        return Response
                .status(Response.Status.OK)
                .entity("The counter is: " + Counter.getCounter())
                .build();
    }

    @POST
    @Path("/clear")
    public Response clearCounter(
            @CookieParam(value = "hh-auth")
            String hhAuth
    ){
        if (hhAuth != null && hhAuth.length() > 10){
            Counter.nullCounter();
        }
        return Response
                .status(Response.Status.OK)
                .entity("The counter is: " + Counter.getCounter())
                .build();
    }

    @DELETE
    public Response delCounter(
            @QueryParam("Subtraction-Value")
            Integer subValue
    ){
        Counter.delCounter(subValue);
        return Response
                .status(Response.Status.OK)
                .entity("The counter is: " + Counter.getCounter())
                .build();
    }

}
