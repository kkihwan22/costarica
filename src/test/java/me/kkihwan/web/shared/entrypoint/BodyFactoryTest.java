package me.kkihwan.web.shared.entrypoint;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BodyFactoryTest {
    private final Logger LOG = LoggerFactory.getLogger(BodyFactoryTest.class);
    private final Map<String, String> data = Map.of("key", "value");

    @Test
    @DisplayName("성공했을 경우의 응답 모델 생성 테스트입니다.")
    void successResponseBody() {
        Body<Map<String,String>> expect = new Body<>(0, "OK", "", data);
        Body<Map<String, String>> body = BodyFactory.success(data);
        assertEquals(expect, body);
    }
}