package com.slmtecnologia.notifications.controller;

import com.slmtecnologia.notifications.controller.dto.ScheduleNotificationDTO;
import com.slmtecnologia.notifications.entity.Notification;
import com.slmtecnologia.notifications.service.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping
    public ResponseEntity<Void> scheduleNotifications(@RequestBody ScheduleNotificationDTO scheduleNotificationDTO){
        notificationService.scheduleNotification(scheduleNotificationDTO);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Notification> findById(@PathVariable("id") Long id){
        var notification = notificationService.findById(id);

        if(notification.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(notification.get());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelNotification(@PathVariable("id") Long id){
        notificationService.cancelNotification(id);
        return ResponseEntity.noContent().build();
    }

}
