package com.slmtecnologia.notifications.entity;

import com.slmtecnologia.notifications.enuns.StatusEnum;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "notification")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long notificationId;

    private LocalDateTime dateTime;

    private String destination;

    private String message;

    @ManyToOne
    @JoinColumn(name = "statusId")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "channelId")
    private Channel channel;

    public Notification() {
    }

    public Notification(Long notificationId, LocalDateTime dateTime, String destination, String message, Status status, Channel channel) {
        this.notificationId = notificationId;
        this.dateTime = dateTime;
        this.destination = destination;
        this.message = message;
        this.status = status;
        this.channel = channel;
    }

    public Notification(LocalDateTime dateTime, String destination, String message, Status status, Channel channel) {
        this.dateTime = dateTime;
        this.destination = destination;
        this.message = message;
        this.status = status;
        this.channel = channel;
    }

    public Long getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(Long notificationId) {
        this.notificationId = notificationId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }
}
