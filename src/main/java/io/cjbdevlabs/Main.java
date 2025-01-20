package io.cjbdevlabs;

import io.cjbdevlabs.library.Book;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.transaction.Transactional;
import lombok.extern.jbosslog.JBossLog;

@JBossLog
@QuarkusMain
public class Main {
    public static void main(String... args) {
        Quarkus.run(MyApp.class, args);
    }

    public static class MyApp implements QuarkusApplication {
        
        @Override
        @Transactional
        public int run(String... args) throws Exception {
            Book book = Book.find("isbn = ?1", "978-0358439196").firstResult();
            log.infof("found book : %s", book);

            log.info("Starting Quarkus App");
            Quarkus.waitForExit();
            return 0;
        }
    }
}