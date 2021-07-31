package com.cloud.streamfilter.queues;


import com.cloud.streamfilter.model.Domain;
import com.cloud.streamfilter.model.Root;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DomainDataQueue {

    private final ObjectMapper objectMapper;

    @Bean
    public Function<String, String> filterDomainData() {
        return string -> convertToJson(
                Objects.requireNonNull(getRoot(string))
                        .getDomains()
                        .parallelStream()
                        .filter(domain -> null != domain.getNS())
                        .collect(Collectors.toList())
        );
    }

    private String convertToJson(List<Domain> domainList) {
        try {
            return objectMapper.writeValueAsString(domainList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Root getRoot(String body) {
        try {
            return objectMapper.readValue(body, Root.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
