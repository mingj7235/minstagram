package com.joshua.minstagram.global.config;

import com.joshua.minstagram.global.interceptor.AuthenticationInterceptor;
import com.joshua.minstagram.global.resolver.AuthenticationArgumentResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.List;
import java.util.Locale;

@RequiredArgsConstructor
@Configuration
public class WebConfig implements WebMvcConfigurer {
//
//    private final AuthenticationInterceptor authenticationInterceptor;
//
//    private final AuthenticationArgumentResolver authenticationArgumentResolver;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(authenticationInterceptor);
//    }
//
//    @Override
//    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
//        resolvers.add(authenticationArgumentResolver);
//    }
//
//    @Bean
//    public AcceptHeaderLocaleResolver localeResolver() {
//        final AcceptHeaderLocaleResolver acceptHeaderLocaleResolver = new AcceptHeaderLocaleResolver();
//        acceptHeaderLocaleResolver.setDefaultLocale(Locale.US);
//        return acceptHeaderLocaleResolver;
//    }

}

