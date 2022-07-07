package me.kkihwan.web.shared.entrypoints;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResponseBodyFactoryTest {
    private final Logger LOG = LoggerFactory.getLogger(ResponseBodyFactoryTest.class);
    private final Map<String, String> data = Map.of("key", "value");

    @Test
    @DisplayName("성공했을 경우의 응답 모델 생성 테스트입니다.")
    void successResponseBody() {
        ResponseBody<Map<String,String>> expect = new ResponseBody<>(0, "OK", "", data);
        ResponseBody<Map<String, String>> body = ResponseBodyFactory.success(data);
        assertEquals(expect, body);
    }
}