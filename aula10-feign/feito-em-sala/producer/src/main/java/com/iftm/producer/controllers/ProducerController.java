package com.iftm.producer.controllers;

import com.iftm.producer.models.dto.ResponseDTO;
import com.iftm.producer.services.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProducerController {

    @Autowired
    private ProducerService service;

    @GetMapping("/response")
    public ResponseEntity<ResponseDTO> getResponse() {
        return service.getResponse();
    }
}
