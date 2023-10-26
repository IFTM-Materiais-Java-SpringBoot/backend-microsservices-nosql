package com.iftm.consumer.feign;

import com.iftm.consumer.models.dto.ResponseDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@FeignClient(value = "producer")
public interface FeignConsumer {

    @GetMapping("/api/response")
    @Retry(name = "consumer", fallbackMethod = "getResponse")
    //@CircuitBreaker(name = "consumer", fallbackMethod = "getResponse")
    ResponseEntity<ResponseDTO> getResponse();

    default ResponseEntity<ResponseDTO> getResponse(Throwable t) {
        var title = "Feign Cliet Error - Open Circuit-Breaker!";
        var message = "An error occurend try require a message of Producer Class!";
        return ResponseEntity
                .internalServerError()
                .body(
                        new ResponseDTO(title, message, new Date()
                ));
    }
}
