package com.iftm.startexample.models.dtos;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class LogDTO<T> implements Serializable {
    private String action;
    private Date date = new Date();
    private String objectType;
    private T object;

    public LogDTO() {
    }

    public LogDTO(String action, T object) {
        this.action = action;
        this.objectType = object.getClass().toString();
        this.object = object;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogDTO<?> logDTO = (LogDTO<?>) o;
        return Objects.equals(action, logDTO.action) && Objects.equals(date, logDTO.date) && Objects.equals(objectType, logDTO.objectType) && Objects.equals(object, logDTO.object);
    }

    @Override
    public int hashCode() {
        return Objects.hash(action, date, objectType, object);
    }

    @Override
    public String toString() {
        return "LogDTO{" +
                "action='" + action + '\'' +
                ", date=" + date +
                ", objectType='" + objectType + '\'' +
                ", object=" + object +
                '}';
    }
}
