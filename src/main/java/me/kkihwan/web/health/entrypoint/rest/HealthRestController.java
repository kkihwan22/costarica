package me.kkihwan.web.health.entrypoint.rest;

import org.slf4j.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class HealthRestController {
    private final Logger LOG = LoggerFactory.getLogger(HealthRestController.class);

    @GetMapping("/_health")
    public ResponseEntity<Map<String,String>> checkHealth() {
        LOG.info("[health] check.");
        final Map<String, String> responseBody = new HashMap<>();
        responseBody.put("result", "success");
        responseBody.put("service", "costarica-web-service");
        return ResponseEntity.ok(responseBody);
    }
}