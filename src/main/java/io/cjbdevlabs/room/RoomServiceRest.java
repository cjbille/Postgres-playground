package io.cjbdevlabs.room;

import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/api/rooms")
@ApplicationScoped
@RegisterRestClient(configKey = "rooms-api")
public interface RoomServiceRest {
    
    @GET
    public List<Room> getRooms();
}
