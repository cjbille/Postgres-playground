package io.cjbdevlabs;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import lombok.extern.jbosslog.JBossLog;

@JBossLog
@QuarkusMain
public class Main {
    public static void main(String... args) {
        Quarkus.run(MyApp.class, args);
    }

    public static class MyApp implements QuarkusApplication {

        // @Inject
        // @RestClient
        // RoomServiceRest roomServiceRest;

        @Inject
        EntityManager entityManager;
        
        @Override
        public int run(String... args) throws Exception {
            log.info("Starting Quarkus App");
            Quarkus.waitForExit();
            return 0;
        }
    }
}