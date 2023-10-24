package com.iftm.consumer.models.dto;

import java.io.Serializable;
import java.util.Date;

public class MasterMessage implements Serializable {

    private String masterTitle;
    private Date masterDate;
    private ResponseDTO responseDTO;

    public MasterMessage(String masterTitle, Date masterDate, ResponseDTO responseDTO) {
        this.masterTitle = masterTitle;
        this.masterDate = masterDate;
        this.responseDTO = responseDTO;
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

    public ResponseDTO getResponseDTO() {
        return responseDTO;
    }

    public void setResponseDTO(ResponseDTO responseDTO) {
        this.responseDTO = responseDTO;
    }

    @Override
    public String toString() {
        return "MasterMessage{" +
                "masterTitle='" + masterTitle + '\'' +
                ", masterDate=" + masterDate +
                ", responseDTO=" + responseDTO +
                '}';
    }
}
