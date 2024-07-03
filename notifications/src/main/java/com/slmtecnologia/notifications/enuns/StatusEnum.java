package com.slmtecnologia.notifications.enuns;

import com.slmtecnologia.notifications.entity.Status;

public enum StatusEnum {

    PENDING(1L, "pending"),
    SUCCESS(2L, "success"),
    ERROR(3L, "error"),
    CANCELED(4L, "canceled");

    private Long id;
    private String description;

    StatusEnum(Long id, String description){
        this.id = id;
        this.description = description;
    }

    public static Status toChannel(StatusEnum statusEnum){
        return new Status(statusEnum.id, statusEnum.description);
    }
}
