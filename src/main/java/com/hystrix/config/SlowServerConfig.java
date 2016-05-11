package com.hystrix.config;

public class SlowServerConfig {

    private String url;
    private int timeout;

    public String getUrl() {
        return url;
    }

    public int getTimeout() {
        return timeout;
    }
}
