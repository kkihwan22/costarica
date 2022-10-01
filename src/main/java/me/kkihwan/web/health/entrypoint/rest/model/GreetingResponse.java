package me.kkihwan.web.health.entrypoint.rest.model;

import lombok.*;

@Getter @ToString
public class GreetingResponse {
    private String strGreeting;

    public GreetingResponse(String strGreeting) {
        this.strGreeting = strGreeting;
    }
}
