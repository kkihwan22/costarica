package me.kkihwan.web.health.entrypoint.rest;

import me.kkihwan.web.health.entrypoint.rest.model.*;
import me.kkihwan.web.shared.entrypoint.Body;
import me.kkihwan.web.shared.entrypoint.*;
import me.kkihwan.web.shared.exception.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class HelloWorldRestController {

    @GetMapping("/samples/get")
    public ResponseEntity<Body<GreetingResponse>> greeting() {
        return ResponseEntity.ok(BodyFactory.success(new GreetingResponse("hello")));
    }

    @GetMapping("/samples/error")
    public ResponseEntity<Body<GreetingResponse>> error() {
        throw new BusinessException(1, "Error Sample.", Collections.emptyList());
    }
}
