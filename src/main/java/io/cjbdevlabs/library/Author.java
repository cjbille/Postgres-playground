package io.cjbdevlabs.library;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
public class Author extends PanacheEntity {

    private String name;

    @OneToOne(mappedBy = "author")
    private Book book;
}
