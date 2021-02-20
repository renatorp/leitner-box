package com.rippleofknowledge.leitnerbox.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "com.rippleofknowledge.leitnerbox.entity")
@EnableJpaRepositories(basePackages = "com.rippleofknowledge.leitnerbox.repository")
public class PersistenceConfig {
}
