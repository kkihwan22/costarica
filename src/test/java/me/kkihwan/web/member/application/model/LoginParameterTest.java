package me.kkihwan.web.member.application.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolationException;

import static org.junit.jupiter.api.Assertions.*;

class LoginParameterTest {
    @DisplayName("LoginParameter 의 유효성 검증 테스트")
    @Test
    void violationTest() {
        Assertions.assertThrows(ConstraintViolationException.class, () -> new LoginParameter("",""));
        Assertions.assertThrows(ConstraintViolationException.class, () -> new LoginParameter("","TEST1234"));
        Assertions.assertThrows(ConstraintViolationException.class, () -> new LoginParameter("TEST1234",""));
    }

    @Test
    void violation2Test() {
        Throwable throwable = assertThrows(ConstraintViolationException.class, () -> new LoginParameter("",""));
        //assertEquals();
    }
}