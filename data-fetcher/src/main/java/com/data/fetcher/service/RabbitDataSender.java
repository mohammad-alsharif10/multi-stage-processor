package com.data.fetcher.service;

import com.data.fetcher.model.Root;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import static com.data.fetcher.util.constants.DOMAIN_DATA_EXCHANGE;
import static com.data.fetcher.util.constants.DOMAIN_DATA_ROUTING_KEY;

@AllArgsConstructor
@Service
public class RabbitDataSender {

    private final RabbitTemplate rabbitTemplate;

    public void send(String root) {

        rabbitTemplate.convertAndSend(
                DOMAIN_DATA_EXCHANGE,
                DOMAIN_DATA_ROUTING_KEY,
                root
        );

    }
}
