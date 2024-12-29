package io.cjbdevlabs;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class RoomService {
    
    @Transactional
    public List<Room> getRooms() {
        return Room.listAll();
    }
}
