package me.kkihwan.web.health.entrypoints.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.HashMap;
import java.util.Map;

@WebMvcTest(HealthRestController.class)
@AutoConfigureWebMvc
class HealthRestControllerTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @DisplayName("[ 헬스체크 ] 정상")
    @Test
    void successTest() throws Exception {
        final Map<String, String> responseBody = new HashMap<>();
        responseBody.put("result", "success");
        responseBody.put("service", "costarica-web-service");

        String json = objectMapper.writeValueAsString(responseBody);

        mockMvc.perform(
                MockMvcRequestBuilders.get("http://localhost:8881/_health")
        ).andExpect(MockMvcResultMatchers.status().isOk()
        ).andExpect(MockMvcResultMatchers.content().json(json)
        ).andDo(MockMvcResultHandlers.print());
    }

}