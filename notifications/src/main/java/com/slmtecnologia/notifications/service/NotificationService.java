package com.slmtecnologia.notifications.service;

import com.slmtecnologia.notifications.controller.dto.ScheduleNotificationDTO;
import com.slmtecnologia.notifications.repository.NotificationRepository;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private  final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public void scheduleNotification(ScheduleNotificationDTO scheduleNotificationDTO){
        notificationRepository.save(scheduleNotificationDTO.toNotification());
    }
}
