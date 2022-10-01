package me.kkihwan.web.config.security;

import lombok.*;
import me.kkihwan.web.member.domain.*;
import org.slf4j.*;
import org.springframework.security.core.authority.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.*;
import org.springframework.stereotype.*;

import javax.transaction.*;
import java.util.*;
import java.util.stream.*;

@RequiredArgsConstructor
@Component
public class CustomUserDetailsServiceImpl implements UserDetailsService {
    private final Logger log = LoggerFactory.getLogger(CustomUserDetailsServiceImpl.class);
    private final MemberJpaRepository memberJpaRepository;
    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member findMember = memberJpaRepository
                .findByUserDetails(username)
                .orElseThrow(() -> {
                    log.info("{} is Not found.", username);
                    throw new UsernameNotFoundException(username + "is not found.");
                });

        log.debug("find member: {}", findMember);
        log.debug("roles: {}", findMember.getRoles());

        Collection<SimpleGrantedAuthority> authorities = findMember.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getCodeName().name()))
                .collect(Collectors.toList());

        return new User(findMember.getEmail(), new BCryptPasswordEncoder().encode(findMember.getPassword()), authorities);
    }
}