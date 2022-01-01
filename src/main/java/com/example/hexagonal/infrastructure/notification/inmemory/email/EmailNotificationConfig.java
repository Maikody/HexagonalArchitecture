package com.example.hexagonal.infrastructure.notification.inmemory.email;

import com.example.hexagonal.domain.common.emailnotification.EmailNotificationPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmailNotificationConfig {

    @Bean
    public EmailNotificationPort emailNotificationPort() {
        return new EmailNotificationAdapter();
    }

}

