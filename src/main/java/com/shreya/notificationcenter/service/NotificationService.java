package com.shreya.notificationcenter.service;

import com.shreya.notificationcenter.model.Notification;
import com.shreya.notificationcenter.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository repository;

    // Create a new notification
    public Notification createNotification(Notification notification) {
        notification.setRead(false);
        notification.setCreatedAt(LocalDateTime.now());
        return repository.save(notification);
    }

    // Get all notifications
    public List<Notification> getAllNotifications() {
        return repository.findAll();
    }

    // Mark a notification as read
    public Notification markAsRead(Long id) {

        Notification notification = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notification not found"));

        notification.setRead(true);

        return repository.save(notification);
    }
}
