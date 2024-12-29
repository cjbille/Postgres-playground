package io.cjbdevlabs;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class RoomService {
    
    @Transactional
    public List<Room> getRooms() {
        List<Room> rooms = Room.findAll().list();
        return rooms;
    }
}
