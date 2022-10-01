package me.kkihwan.web.config;

import com.ulisesbocchio.jasyptspringboot.annotation.*;
import org.jasypt.encryption.*;
import org.jasypt.encryption.pbe.*;
import org.jasypt.encryption.pbe.config.*;
import org.springframework.context.annotation.*;

@Configuration
@EnableEncryptableProperties
public class JasyptConfig {
    private final static String ENC_KEY = "costarica-service";

    @Bean(name = "jasyptStringEncryptor")
    public StringEncryptor stringEncryptor() {
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = getSimpleStringPBEConfig();
        encryptor.setConfig(config);
        return encryptor;
    }

    private SimpleStringPBEConfig getSimpleStringPBEConfig() {
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(ENC_KEY); // 암호화할 때 사용하는 키
        config.setAlgorithm("PBEWithMD5AndDES"); // 암호화 알고리즘
        config.setKeyObtentionIterations("1000"); // 반복할 해싱 회수
        config.setPoolSize("1"); // 인스턴스 pool
        config.setProviderName("SunJCE");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator"); // salt 생성 클래스
        config.setStringOutputType("base64"); //인코딩 방식
        return config;
    }
}