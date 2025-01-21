package io.cjbdevlabs.library;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BookService {
    
    public List<Book> getBooks() {
        return Book.listAll();
    }
}
