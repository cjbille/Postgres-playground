package io.cjbdevlabs.greeting;

import jakarta.enterprise.context.RequestScoped;
import lombok.Getter;
import lombok.Setter;

@RequestScoped
public class GreetingBean {
    
    @Getter
    @Setter
    private String name;

    public void submit() {
        setName(name);
    }
}
