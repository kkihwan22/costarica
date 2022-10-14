package me.kkihwan.web.config.security;

import lombok.RequiredArgsConstructor;
import me.kkihwan.web.member.domain.Member;
import me.kkihwan.web.member.domain.MemberJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.*;

@RequiredArgsConstructor
@Component
public class CustomUserDetailsServiceImpl implements UserDetailsService {
    private final Logger log = LoggerFactory.getLogger(CustomUserDetailsServiceImpl.class);
    private final MemberJpaRepository memberJpaRepository;
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member findMember = memberJpaRepository
                .findByUserDetails(username)
                .orElseThrow(() -> {
                    log.info("{} is Not found.", username);
                    throw new UsernameNotFoundException(username + "is not found.");
                });

        log.debug("find member: {}", findMember);
        log.debug("roles: {}", findMember.getRoles());

        Set<SimpleGrantedAuthority> authorities = findMember.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getCodeName().name()))
                .collect(Collectors.toSet());

        return new CustomUserDetails(findMember.getId(), findMember.getNickname(), findMember.getEmail(), new BCryptPasswordEncoder().encode(findMember.getPassword()), authorities);
    }
}