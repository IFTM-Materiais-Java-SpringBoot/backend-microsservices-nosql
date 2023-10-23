package com.iftm.producer.models.dtos;

import java.io.Serializable;
import java.util.Date;

public class ResponseDTO implements Serializable {

    private String title;
    private String message;
    private Date date = new Date();

    public ResponseDTO(String title, String message, Date date) {
        this.title = title;
        this.message = message;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ResponseDTO{" +
                "title='" + title + '\'' +
                ", message='" + message + '\'' +
                ", date=" + date +
                '}';
    }
}
