package io.cjbdevlabs;

import java.util.List;

import io.quarkus.arc.Arc;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@ApplicationScoped
public class RoomService {

    @Inject
    EntityManager entityManager;
    
    public List<Room> getRooms() {
        Arc.container().requestContext().activate();
        var rooms = entityManager.createQuery("select r from Room r", Room.class).getResultList();
        Arc.container().requestContext().deactivate();
        return rooms;
    }
}
