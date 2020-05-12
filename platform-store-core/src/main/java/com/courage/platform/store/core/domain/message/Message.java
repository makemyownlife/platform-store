package com.courage.platform.store.core.domain.message;

import java.io.Serializable;
import java.util.Map;

public class Message implements Serializable {

    private static final long serialVersionUID = 8445773977080406428L;

    private String topic;

    private int flag;

    private Map<String, String> properties;

    private byte[] body;

    public Message() {

    }

}
