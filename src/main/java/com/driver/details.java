package com.driver;

import java.util.Date;

public class details {
    private Date date;
    private String message;

    details(Date date, String message) {
        this.date = date;
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public String getMessage() {
        return message;
    }
}
