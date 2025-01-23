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
        Author author = Author.find("name", "J.R.R. Tolkien").firstResult();
        log.infof("found author : %s", author);
        var newBook = new Book();
        newBook.setIsbn("978-0395177112");
        newBook.setName("The Hobbit");
        newBook.setAuthor(author);
        newBook.persist();
    }
}
