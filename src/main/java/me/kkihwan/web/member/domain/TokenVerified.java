package me.kkihwan.web.member.domain;

import lombok.*;
import org.springframework.security.core.*;
import org.springframework.security.core.authority.*;

import java.util.*;
import java.util.stream.*;

@Getter @ToString
public class TokenVerified {

    private final boolean verified;
    private final String username;
    private Collection<GrantedAuthority> authorities;

    public TokenVerified(boolean verified, String username) {
        this.verified = verified;
        this.username = username;
    }

    private void setAuthorities(Collection<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    public static TokenVerified success(String username, String strAuthorities) {
        TokenVerified tokenVerified = new TokenVerified(true, username);
        tokenVerified.setAuthorities(
                Arrays.stream(strAuthorities.split(","))
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList()));
        return tokenVerified;
    }

    public static TokenVerified failure(String username, String strAuthorities) {
        TokenVerified tokenVerified = new TokenVerified(false, username);
        tokenVerified.setAuthorities(
                Arrays.stream(strAuthorities.split(","))
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList()));
        return tokenVerified;
    }

}