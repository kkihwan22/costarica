package me.kkihwan.web.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.server.i18n.AcceptHeaderLocaleContextResolver;
import org.springframework.web.server.i18n.LocaleContextResolver;

import java.util.Locale;

@Configuration
public class MessageSourceConfig {

    @Bean
    public MessageSource messageSource() {
        final ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("i18n/message");
        messageSource.setCacheSeconds(5);
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setDefaultLocale(Locale.KOREA);
        return messageSource;
    }

    /**
     * [ 설명 ]
     * Webflux 에서 locale 설정 시 사용되는 Bean
     * @return LocaleContextResolver
     */
    @Bean
    public LocaleContextResolver localeContextResolver() {
        final AcceptHeaderLocaleContextResolver localeContextResolver = new AcceptHeaderLocaleContextResolver();
        localeContextResolver.setDefaultLocale(Locale.KOREA);
        return localeContextResolver;
    }
}
