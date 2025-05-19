package io.cjbdevlabs.view;

import java.util.List;

import io.cjbdevlabs.library.Book;
import io.cjbdevlabs.library.BookService;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.extern.jbosslog.JBossLog;

@ViewScoped
@Named
@JBossLog
public class IndexBean {

    @Inject
    BookService bookService;

    public void saveBook() {
        bookService.saveBook();
    }

    public List<Book> getBooks() {
        return bookService.getBooks();
    }
}
