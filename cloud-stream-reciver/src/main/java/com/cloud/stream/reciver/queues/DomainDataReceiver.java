package com.cloud.stream.reciver.queues;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
public class DomainDataReceiver {

    @Bean
    Consumer<String> receiveDomainData() {
        return System.out::println;
    }
}
