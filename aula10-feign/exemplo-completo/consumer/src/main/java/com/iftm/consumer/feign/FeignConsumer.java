package com.iftm.consumer.feign;

import com.iftm.consumer.models.dto.ResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "producer")
public interface FeignConsumer {
    @GetMapping("/api/response")
    ResponseEntity<ResponseDTO> getResponse();
}
