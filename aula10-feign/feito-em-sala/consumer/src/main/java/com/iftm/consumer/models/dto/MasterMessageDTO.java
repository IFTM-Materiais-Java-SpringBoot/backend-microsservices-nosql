package com.iftm.consumer.models.dto;

import java.io.Serializable;
import java.util.Date;

public class MasterMessageDTO implements Serializable {

    private String masterTitle;
    private Date masterDate = new Date();
    private ResponseDTO message;

    public MasterMessageDTO(String masterTitle, Date masterDate, ResponseDTO message) {
        this.masterTitle = masterTitle;
        this.masterDate = masterDate;
        this.message = message;
    }

    public String getMasterTitle() {
        return masterTitle;
    }

    public void setMasterTitle(String masterTitle) {
        this.masterTitle = masterTitle;
    }

    public Date getMasterDate() {
        return masterDate;
    }

    public void setMasterDate(Date masterDate) {
        this.masterDate = masterDate;
    }

    public ResponseDTO getMessage() {
        return message;
    }

    public void setMessage(ResponseDTO message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "MasterMessageDTO{" +
                "masterTitle='" + masterTitle + '\'' +
                ", masterDate=" + masterDate +
                ", message=" + message +
                '}';
    }
}
