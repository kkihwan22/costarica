package me.kkihwan.web.member.domain;

import lombok.*;
import org.springframework.security.core.*;
import org.springframework.security.core.authority.*;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;
import java.util.stream.*;

@Getter @ToString
public class TokenVerified {

    private final boolean verified;
    private UserDetails userDetails;

    public TokenVerified(boolean verified, UserDetails userDetails) {
        this.verified = verified;
        this.userDetails = userDetails;
    }

    public static TokenVerified success(UserDetails userDetails) {
        return new TokenVerified(true, userDetails);
    }

    public static TokenVerified failure(UserDetails userDetails) {
        return new TokenVerified(false, userDetails);
    }

}