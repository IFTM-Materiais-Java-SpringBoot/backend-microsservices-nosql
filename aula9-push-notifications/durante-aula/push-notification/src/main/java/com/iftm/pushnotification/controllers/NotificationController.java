package com.iftm.pushnotification.controllers;

import com.iftm.pushnotification.notifications.models.NotificationMessage;
import com.iftm.pushnotification.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping
    public ResponseEntity<?> sendNotification(@RequestBody NotificationMessage notificationMessage) {
        return notificationService.sendNotification(notificationMessage);
    }
}
