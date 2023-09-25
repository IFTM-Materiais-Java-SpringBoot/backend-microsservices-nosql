package com.iftm.logpool.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Document(collection = "softwarehouseLogs")
public class Log<T> implements Serializable {
    @Id
    private String id;
    private String action;
    private Date date = new Date();
    private String objectType;
    private T object;

    public Log() {
    }

    public Log(String id, String action, Date date, String objectType, T object) {
        this.id = id;
        this.action = action;
        this.date = date;
        this.objectType = objectType;
        this.object = object;
    }

    public Log(String action, Date date, String objectType, T object) {
        this.action = action;
        this.date = date;
        this.objectType = objectType;
        this.object = object;
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
        Log<?> log = (Log<?>) o;
        return Objects.equals(id, log.id) && Objects.equals(action, log.action) && Objects.equals(date, log.date) && Objects.equals(objectType, log.objectType) && Objects.equals(object, log.object);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, action, date, objectType, object);
    }

    @Override
    public String toString() {
        return "Log{" +
                "id='" + id + '\'' +
                ", action='" + action + '\'' +
                ", date=" + date +
                ", objectType='" + objectType + '\'' +
                ", object=" + object +
                '}';
    }
}
