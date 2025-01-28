package io.cjbdevlabs.library;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Review extends PanacheEntity {

    private String comment;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
}
