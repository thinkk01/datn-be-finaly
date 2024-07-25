package com.datn.be.service.impl;

import com.datn.be.repo.NotificationRepo;
import com.datn.be.entity.Notification;
import com.datn.be.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NotificationServiceImpl implements NotificationService {
    @Autowired
    NotificationRepo notificationRepo;

    @Override
    public List<Notification> loadNotification(Boolean read, Boolean deliver) {
        return notificationRepo.getNotificationByReadEqualsAndDeliverEquals(read, deliver);
    }

    @Override
    public Notification modifyNotification(Long id) {
        Notification notification = notificationRepo.findById(id).get();
        notification.setRead(true);
        notification.setDeliver(true);
        return notificationRepo.save(notification);
    }

    @Override
    public Notification updateNotification(Notification notification) {
        return notificationRepo.save(notification);
    }

    @Override
    public Notification createNotification(Notification notification) {
        return notificationRepo.save(notification);
    }
}
