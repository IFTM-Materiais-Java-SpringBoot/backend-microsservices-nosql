package com.iftm.pushnotification.services;

import com.iftm.pushnotification.notifications.models.NotificationMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class OrderService {

    @Autowired
    private NotificationService notificationService;

    private void findAll(Object obj) {
        // persistencia no DB
    }

    private void save(Object obj) {
        // persistencia no DB

        notificationService.sendNotification(new NotificationMessage(
                "token",
                "titulo",
                "Corpo",
                "imagem",
                new HashMap<>()
        ));
    }

}
