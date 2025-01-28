package io.cjbdevlabs;

import io.cjbdevlabs.library.BookService;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;
import lombok.extern.jbosslog.JBossLog;

@JBossLog
@QuarkusMain
public class Main {
    public static void main(String... args) {
        Quarkus.run(MyApp.class, args);
    }

    public static class MyApp implements QuarkusApplication {

        @Inject
        BookService bookService;
        
        @Override
        public int run(String... args) throws Exception {
            // bookService.saveBook();
            Quarkus.waitForExit();
            return 0;
        }
    }
}