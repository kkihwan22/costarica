package me.kkihwan.web.health.entrypoint.rest;

import me.kkihwan.web.health.entrypoint.rest.model.GreetingResponse;
import me.kkihwan.web.shared.entrypoint.ResponseBody;
import me.kkihwan.web.shared.entrypoint.ResponseBodyFactory;
import me.kkihwan.web.shared.exception.BusinessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
public class HelloWorldRestController {

    @GetMapping("/samples/get")
    public ResponseEntity<ResponseBody<GreetingResponse>> greeting() {
        return ResponseEntity.ok(ResponseBodyFactory.success(new GreetingResponse("hello")));
    }

    @GetMapping("/samples/error")
    public ResponseEntity<ResponseBody<GreetingResponse>> error() {
        throw new BusinessException(1, "Error Sample.", Collections.emptyList(), null);
    }
}
