package io.cjbdevlabs;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import io.quarkus.arc.Arc;
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
        
        @Inject
        EntityManager entityManager;
        
        @Override
        public int run(String... args) throws Exception {
            log.info("Starting Quarkus App");
            Arc.container().requestContext().activate();
            var rooms = entityManager.createQuery("select r from Room r", Room.class).getResultList();
            rooms.forEach(room -> log.infof("room info: %s", room));
            Arc.container().requestContext().deactivate();
            Quarkus.waitForExit();
            return 0;
        }
    }
}