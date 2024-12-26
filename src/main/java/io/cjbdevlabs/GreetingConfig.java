package io.cjbdevlabs;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApplicationScoped
public class GreetingConfig {
    String recpient = "LinkedIn Learning Students";
}
