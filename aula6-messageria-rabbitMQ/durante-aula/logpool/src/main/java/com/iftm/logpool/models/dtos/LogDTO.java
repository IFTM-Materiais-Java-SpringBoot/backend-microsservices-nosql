package com.iftm.logpool.models.dtos;

import com.iftm.logpool.models.Log;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class LogDTO<T> implements Serializable {

    private String id;
    private String action;
    private Date date = new Date();
    private String objectType;
    private T object;

    public LogDTO() {
    }

    public LogDTO(String id, String action, Date date, String objectType, T object) {
        this.id = id;
        this.action = action;
        this.date = date;
        this.objectType = objectType;
        this.object = object;
    }

    public LogDTO(String action, Date date, String objectType, T object) {
        this.action = action;
        this.date = date;
        this.objectType = objectType;
        this.object = object;
    }

    public LogDTO(Log log) {
        this.id = log.getId();
        this.action = log.getAction();
        this.date = log.getDate();
        this.object = (T) log.getObject();
        this.objectType = log.getObjectType();
    }

    public Log toLog() {
        String id;
        var log = new Log<T>();
        log.setAction(this.action);
        log.setDate(this.date);
        log.setObject(this.object);

        if(this.id != null && !this.id.isBlank())
            log.setId(this.id);

        if(this.object != null && !this.objectType.isBlank())
            log.setObjectType(this.objectType);
        return log;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        return Objects.equals(id, logDTO.id) && Objects.equals(action, logDTO.action) && Objects.equals(date, logDTO.date) && Objects.equals(objectType, logDTO.objectType) && Objects.equals(object, logDTO.object);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, action, date, objectType, object);
    }

    @Override
    public String toString() {
        return "LogDTO{" +
                "id='" + id + '\'' +
                ", action='" + action + '\'' +
                ", date=" + date +
                ", objectType='" + objectType + '\'' +
                ", object=" + object +
                '}';
    }
}
