package com.slmtecnologia.notifications.enuns;

import com.slmtecnologia.notifications.entity.Channel;

public enum ChannelEnum {

    EMAIL(1L, "email"),
    SMS(2L, "sms"),
    PUSH(3L, "push"),
    WHATSAPP(4L, "whatsapp");

    private Long id;
    private String description;

    ChannelEnum(Long id, String description){
        this.id = id;
        this.description = description;
    }

    public static Channel toChannel(ChannelEnum channelEnum){
        return new Channel(channelEnum.id, channelEnum.description);
    }
}
