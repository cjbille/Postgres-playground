package io.cjbdevlabs.library;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.panache.mock.PanacheMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import lombok.extern.jbosslog.JBossLog;

@JBossLog
@QuarkusTest
class BookServiceTest {

    @Inject
    BookService bookService;

    @Test
    void getBooksShouldReturnBooks() {
        PanacheMock.mock(Book.class);
        var book = new Book();
        book.setName("foo");
        book.setIsbn("1234");
        List<PanacheEntityBase> bookList = new ArrayList<PanacheEntityBase>();
        bookList.add(book);
        Mockito.when(Book.listAll()).thenReturn(bookList);
        for (var b : bookService.getBooks()) {
            log.infof("book is : %s", b.toString());
        }
    }
}
