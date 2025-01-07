package io.cjbdevlabs.room;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.transaction.Transactional;

@QuarkusTest
class RoomResourceTest {

    @BeforeEach
    @Transactional
    void setUp() {
        var room = new Room();
        room.setName("Double Room");
        room.setBedInfo("One double bed");
        room.setRoomNumber("101");
        room.persist();
    }

    @Test
    void testRoomsEndpoint() {
        given()
            .when().get("/rooms")
            .then()
                .statusCode(200);
    }
}
