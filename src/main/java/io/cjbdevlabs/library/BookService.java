package io.cjbdevlabs.library;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import lombok.extern.jbosslog.JBossLog;

@JBossLog
@ApplicationScoped
public class BookService {
    
    public List<Book> getBooks() {
        return Book.listAll();
    }

    @Transactional
    public void saveBook() {
        Book book = Book.find("name", "The Hobbit").firstResult();
        var review = new Review();
        review.setBook(book);
        review.setComment("A great look into how LOTR began!");
        review.persist();
    }
}
