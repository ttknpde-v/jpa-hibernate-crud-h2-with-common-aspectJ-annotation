package com.ttknpdev.springbootcrudh2aopbasic.exception.entity;

import java.util.Date;

public class Warning {
    private Date timestamp;
    private String details;

    public Warning(Date timestamp, String details) {
        this.timestamp = timestamp;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
