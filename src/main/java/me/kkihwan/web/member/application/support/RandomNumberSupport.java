package me.kkihwan.web.member.application.support;

import java.util.concurrent.*;

public class RandomNumberSupport {

    public static int random6Digit() {
        return ThreadLocalRandom.current().nextInt(100000, 1000000);
    }
}
