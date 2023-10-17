package com.iftm.pushnotification.services;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import com.iftm.pushnotification.notifications.models.NotificationMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    private FirebaseMessaging firebaseMessaging;

    public ResponseEntity<?> sendNotification(NotificationMessage notificationMessage) {
        var notification = Notification
                .builder()
                .setTitle(notificationMessage.getTitle())
                .setBody(notificationMessage.getBody())
                .setImage(notificationMessage.getImage())
                .build();

        var mensage = Message
                .builder()
                .setToken(notificationMessage.getRecipientToken())
                .setNotification(notification)
                .putAllData(notificationMessage.getData())
                .build();
        try {
            firebaseMessaging.send(mensage);
            return ResponseEntity.ok().build();

        } catch (FirebaseMessagingException ex) {
            ex.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
}
