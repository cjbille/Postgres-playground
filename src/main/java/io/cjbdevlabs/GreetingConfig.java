package io.cjbdevlabs;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApplicationScoped
public class GreetingConfig {

    @ConfigProperty(name = "application.greeting.recipient", defaultValue = "Students")
    String recpient;
}
