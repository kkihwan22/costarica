package me.kkihwan.web.config;

import lombok.*;
import me.kkihwan.web.config.filter.*;
import me.kkihwan.web.config.security.*;
import org.slf4j.*;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.*;
import org.springframework.http.*;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.method.configuration.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.config.http.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.*;
import org.springframework.security.web.authentication.*;
import org.springframework.web.cors.*;

import java.util.*;
import java.util.stream.*;

@RequiredArgsConstructor
@EnableWebSecurity(debug = true)
@EnableMethodSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final Logger log = LoggerFactory.getLogger(WebSecurityConfig.class);
    private final UserDetailsService creameUserDetailsServiceImpl;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(creameUserDetailsServiceImpl).passwordEncoder(passwordEncoder());
        super.configure(auth);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CustomAuthenticationFilter authenticationFilter = new CustomAuthenticationFilter(authenticationManagerBean());
        authenticationFilter.setFilterProcessesUrl("/public/*/login");

        http.csrf().disable().httpBasic().disable().formLogin().disable().logout().disable();

        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.cors().configurationSource(corsConfigurationSource());

        http.authorizeHttpRequests(request -> {
            request.antMatchers("/_health", "/public/**").permitAll();
            request.antMatchers("/admin/**")
                    .hasRole("ADMIN");

            // TODO: 이 부분 좀 더 공부할 것!
            request.anyRequest()
                    .authenticated();

            http.addFilter(authenticationFilter);
            http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
            http.addFilterBefore(new ErrorHandleFilter(), CustomAuthorizationFilter.class);
        });

    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(List.of("*"));
        config.setAllowedHeaders(List.of("*"));
        config.setAllowedMethods(Arrays.stream(HttpMethod.values()).map(Enum::name).collect(Collectors.toList()));
        config.setMaxAge(0L);
        config.setAllowCredentials(false);

        final UrlBasedCorsConfigurationSource urlBasedCorsConfigSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigSource.registerCorsConfiguration("/**", config);
        return urlBasedCorsConfigSource;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}