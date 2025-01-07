package io.cjbdevlabs.room;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Room extends PanacheEntity {

    private String name;
    private String roomNumber;
    private String bedInfo;
}
