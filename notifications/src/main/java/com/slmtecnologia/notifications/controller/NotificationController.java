package com.slmtecnologia.notifications.controller;

import com.slmtecnologia.notifications.controller.dto.ScheduleNotificationDTO;
import com.slmtecnologia.notifications.service.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }


    @PostMapping
    public ResponseEntity<?> scheduleNotifications(@RequestBody ScheduleNotificationDTO scheduleNotificationDTO){
        notificationService.scheduleNotification(scheduleNotificationDTO);
        return ResponseEntity.ok().build();
    }
}
