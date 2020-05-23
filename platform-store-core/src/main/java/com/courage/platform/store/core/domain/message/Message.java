package com.courage.platform.store.core.domain.message;

import java.io.Serializable;

public class Message implements Serializable {

    private static final long serialVersionUID = 8445773977080406428L;

    private Long startDeliverTime;

    private byte[] body;

    public byte[] getBody() {
        return body;
    }

    public void setBody(byte[] body) {
        this.body = body;
    }

    public Long getStartDeliverTime() {
        return startDeliverTime;
    }

    public void setStartDeliverTime(Long startDeliverTime) {
        this.startDeliverTime = startDeliverTime;
    }

}
