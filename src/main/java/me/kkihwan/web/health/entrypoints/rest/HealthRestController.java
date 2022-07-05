package me.kkihwan.web.health.entrypoints.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HealthRestController {
    private final Logger LOG = LoggerFactory.getLogger(HealthRestController.class);

    @GetMapping("/_health")
    public ResponseEntity<Map<String,String>> checkHealth() {
        final HashMap<String, String> responseBody = new HashMap<>();
        responseBody.put("result", "success");
        responseBody.put("service", "costarica-web-service");

        return ResponseEntity.ok(responseBody);
    }
}