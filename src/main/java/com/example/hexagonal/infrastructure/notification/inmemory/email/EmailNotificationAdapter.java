package com.example.hexagonal.infrastructure.notification.inmemory.email;

import com.example.hexagonal.domain.common.emailnotification.EmailNotificationPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class EmailNotificationAdapter implements EmailNotificationPort {

    private static Logger logger = LoggerFactory.getLogger(EmailNotificationAdapter.class);

    @Override
    public void send(List<String> recipients, String message) {
        logger.info("Wysylanie wiadomosci");
    }
}
