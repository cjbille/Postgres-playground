package io.cjbdevlabs;

import io.cjbdevlabs.library.Category;
import io.cjbdevlabs.library.CategoryService;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.extern.jbosslog.JBossLog;

@JBossLog
@QuarkusMain
public class Main {
    public static void main(String... args) {
        Quarkus.run(MyApp.class, args);
    }

    public static class MyApp implements QuarkusApplication {

        @Inject
        CategoryService categoryService;
        
        @Override
        public int run(String... args) throws Exception {
            // categoryService.createCategory();
            categoryService.retrieveCategories();
            Quarkus.waitForExit();
            return 0;
        }
    }
}