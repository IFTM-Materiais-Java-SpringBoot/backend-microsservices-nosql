package com.iftm.producer.services;

import com.iftm.producer.models.dtos.ResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ResponseService {

    @Value("${eureka.instance.instance-id:}")
    private String instanceId;

    public ResponseEntity<ResponseDTO> getResponse() {
        var message = "The [" + instanceId + "] generated a message and sent to you!";
        var response = new ResponseDTO("Open Feign Test", message, new Date());
        return ResponseEntity.ok().body(response);
    }
}
