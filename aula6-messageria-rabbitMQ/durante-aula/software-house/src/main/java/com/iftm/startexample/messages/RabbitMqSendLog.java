package com.iftm.startexample.messages;

import com.iftm.startexample.models.dtos.LogDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqSendLog {

    @Value("${softwareHouse.rabbitmq.exchange}") //softwareHouse.exchange
    private String exchange;

    @Value("${softwareHouse.rabbitmq.routingKey}") //softwareHouse.employee.routingKey
    private String routingKey;

    @Value("${softwareHouse.rabbitmq.queue}") //softwareHouse.queue
    private String queue;

    public final RabbitTemplate rabbitTemplate;

    @Autowired
    public RabbitMqSendLog(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    // metodo de envio
    public void sendLog(LogDTO logDTO) {
        rabbitTemplate.execute(channel -> {
           channel.exchangeDeclare(exchange, "direct", true);
           channel.queueDeclare(queue, true, false, false, null);
           channel.queueBind(queue, exchange, routingKey);
           return null;
        });
        rabbitTemplate.convertAndSend(exchange, routingKey, logDTO);
    }
}
