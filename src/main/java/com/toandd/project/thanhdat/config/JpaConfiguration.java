package com.toandd.project.thanhdat.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@Configuration
@EnableJpaAuditing
public class JpaConfiguration {
    @Bean
    public AuditorAware<String> auditorAware() {
        return new AuditorawareImpl();
    }
    static class AuditorawareImpl implements AuditorAware<String> {
        @Override
        public Optional<String> getCurrentAuditor() {
            return Optional.of("Thanhdat");
        }
    }
}
