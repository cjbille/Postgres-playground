package io.cjbdevlabs.room;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.quarkus.panache.mock.PanacheMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.transaction.Transactional;

@QuarkusTest
class RoomResourceTest {

    @BeforeEach
    @Transactional
    void setUp() {
        PanacheMock.mock(Room.class);
        var room = new Room();
        room.setName("Double Room");
        room.setBedInfo("One double bed");
        room.setRoomNumber("101");
        var roomList = List.of(room);
        when(Room.findAllRooms()).thenReturn(roomList);
    }

    @Test
    void testRoomsEndpoint() {
        given()
            .when().get("/rooms")
            .then()
                .statusCode(200)
                .body(
                    "name[0]", containsString("Double Room"),
                    "bedInfo[0]", containsString("One double bed"),
                    "roomNumber[0]", containsString("101")
                );
    }
}
