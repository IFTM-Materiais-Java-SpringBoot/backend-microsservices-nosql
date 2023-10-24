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
    @CircuitBreaker(name = "consumer", fallbackMethod = "getResponse")  // Passa pelo pipeline do disjuntor
    //@Retry(name = "consumer", fallbackMethod = "getResponse")  // realiza tentativas porém não abre o Disjuntor
    ResponseEntity<ResponseDTO> getResponse();

    default ResponseEntity<ResponseDTO> getResponse(Throwable t) {
        var message = "Erro ao tentar acessar o microsserviço producer!";
        return ResponseEntity.internalServerError().body(new ResponseDTO("Fallback response!", message, new Date()));
    }
}
