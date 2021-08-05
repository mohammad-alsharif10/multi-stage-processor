package com.cloud.streamfilter.controller;

import com.cloud.streamfilter.model.Root;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/domainData")
@AllArgsConstructor
public class DomainDataController {

    private final StreamBridge streamBridge;
    private final ObjectMapper objectMapper;

    @SneakyThrows
    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public String sendData(@RequestBody Root root) {
        this.streamBridge.send("domainDataExchange", objectMapper.writeValueAsString(root));
        return null;
    }

}
