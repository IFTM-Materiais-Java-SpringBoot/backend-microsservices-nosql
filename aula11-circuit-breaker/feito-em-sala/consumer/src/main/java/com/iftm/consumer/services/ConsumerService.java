package com.iftm.consumer.services;

import com.iftm.consumer.feign.FeignConsumer;
import com.iftm.consumer.models.dto.MasterMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ConsumerService {

    @Autowired
    FeignConsumer feignConsumer;

    @Value("${eureka.instance.instance-id:}")
    private String instaceId;

    public ResponseEntity<MasterMessage> getMasterMessage() {
        var response = feignConsumer.getResponse();
        if(response.getBody() == null)
            ResponseEntity.internalServerError();

        var title = "Master Message of [" + instaceId + "].";
        var masterMessage = new MasterMessage(title, new Date(), response.getBody());
        System.out.println("Retry: " + new Date());
        return ResponseEntity.ok().body(masterMessage);
    }
}
