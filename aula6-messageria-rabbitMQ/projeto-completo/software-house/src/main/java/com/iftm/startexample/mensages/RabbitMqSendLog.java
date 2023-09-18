package com.iftm.startexample.mensages;

import com.iftm.startexample.models.dtos.EmployeeDTO;
import com.iftm.startexample.models.dtos.LogDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqSendLog {

    @Value("${softwareHouse.rabbitmq.exchange}")
    private String exchange;

    @Value("${softwareHouse.rabbitmq.rountingkey}")
    private String routingKey;

    @Value("${softwareHouse.rabbitmq.queue}")
    private String queue;

    public final RabbitTemplate rabbitTemplate;

    @Autowired
    public RabbitMqSendLog(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

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
