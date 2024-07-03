package com.slmtecnologia.notifications.service;

import com.slmtecnologia.notifications.controller.dto.ScheduleNotificationDTO;
import com.slmtecnologia.notifications.entity.Notification;
import com.slmtecnologia.notifications.enuns.StatusEnum;
import com.slmtecnologia.notifications.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NotificationService {

    private  final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public void scheduleNotification(ScheduleNotificationDTO scheduleNotificationDTO){
        notificationRepository.save(scheduleNotificationDTO.toNotification());
    }

    public Optional<Notification> findById(Long id){
        return notificationRepository.findById(id);
    }

    public void cancelNotification(Long id){
        var notification = findById(id);
        if(notification.isPresent()){
            notification.get().setStatus(StatusEnum.toStatus(StatusEnum.CANCELED));
            notificationRepository.save(notification.get());
        }
    }
}
