package com.iftm.producer.services;

import com.iftm.producer.models.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ProducerService {

    @Value("${eureka.instance.instance-id:}")
    private String instanceId;

    public ResponseEntity<ResponseDTO> getResponse() {
        var messange = "The producer [ " + instanceId + " ]  created a message and sent for you!";
        var response = new ResponseDTO("Open Feign test!", messange, new Date());
        return ResponseEntity.ok().body(response);
    }
}
