package io.cjbdevlabs.library;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Book extends PanacheEntity {

    private String name;
    private String isbn;

    @OneToOne
    @JoinColumn(name = "author_id")
    private Author author;
}
