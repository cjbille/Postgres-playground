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
        var author = new Author();
        author.setName("JRR Tolkien");
        author.persist();
        var review = new Review();
        review.setComment("This is a great book!");
        review.persist();
        var book = new Book();
        book.setAuthor(author);
        book.setReviews(List.of(review));
        book.setName("Lord of the Rings");
        book.setIsbn("978-0358439196");
        book.persistAndFlush();
    }
}
