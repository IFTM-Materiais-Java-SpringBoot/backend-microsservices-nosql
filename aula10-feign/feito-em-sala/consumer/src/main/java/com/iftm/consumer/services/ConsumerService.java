package com.iftm.consumer.services;

import com.iftm.consumer.feign.ConsumerFeign;
import com.iftm.consumer.models.dto.MasterMessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ConsumerService {

    @Autowired
    private ConsumerFeign consumerFeign;

    @Value("${eureka.instance.instance-id}")
    private String instangeId;

    public ResponseEntity<MasterMessageDTO> getMasterMessage() {
        var response = consumerFeign.getResponse();
        if(response.getBody() == null)
            return ResponseEntity.internalServerError().build();

        var title = "Master Message of [ " + instangeId +  " ]";
        var masterMessage = new MasterMessageDTO(title, new Date(), response.getBody());
        return ResponseEntity.ok(masterMessage);
    }
}
