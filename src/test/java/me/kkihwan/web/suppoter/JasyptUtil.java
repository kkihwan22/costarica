package me.kkihwan.web.suppoter;

import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

// TODO: @SpringBootTest 말고 StringEncryptor 빈만 로딩해서 테스트 할 수 있는 방법으로 변경
@SpringBootTest
class JasyptUtil {
    private final static Logger log = LoggerFactory.getLogger(JasyptUtil.class);

    @Autowired
    private StringEncryptor encryptor;


    @Test
    void jasypt() {
        String url = "";
        String username = "";
        String password = "";

        log.info("ENC URL : {}", encryptor.encrypt(url));
        log.info("ENC UserName : {}", encryptor.encrypt(username));
        log.info("ENC Password : {}", encryptor.encrypt(password));
    }
}