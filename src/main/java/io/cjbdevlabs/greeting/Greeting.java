package io.cjbdevlabs.greeting;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/greeting")
public class Greeting {

    GreetingConfig greetingConfig;

    @Inject
    public Greeting(GreetingConfig greetingConfig) {
        this.greetingConfig = greetingConfig;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello " + greetingConfig.getRecpient();
    }
}
