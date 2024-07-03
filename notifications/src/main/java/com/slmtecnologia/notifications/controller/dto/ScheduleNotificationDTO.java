package com.slmtecnologia.notifications.controller.dto;

import com.slmtecnologia.notifications.entity.Notification;
import com.slmtecnologia.notifications.entity.Status;
import com.slmtecnologia.notifications.enuns.ChannelEnum;
import com.slmtecnologia.notifications.enuns.StatusEnum;

import java.time.LocalDateTime;

public record ScheduleNotificationDTO(LocalDateTime dateTime,
                                      String destination,
                                      String message,
                                      ChannelEnum channelEnum) {

    public Notification toNotification(){
        return new Notification(dateTime, destination, message, StatusEnum.toStatus(StatusEnum.PENDING), ChannelEnum.toChannel(channelEnum));
    }
}
