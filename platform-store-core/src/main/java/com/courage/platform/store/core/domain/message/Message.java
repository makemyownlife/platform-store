package com.courage.platform.store.core.domain.message;

import java.io.Serializable;
import java.util.Map;

public class Message implements Serializable {

    private static final long serialVersionUID = 8445773977080406428L;

    private Map<String, String> properties;

    private byte[] body;

    public Message() {
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }

    public byte[] getBody() {
        return body;
    }

    public void setBody(byte[] body) {
        this.body = body;
    }

}
