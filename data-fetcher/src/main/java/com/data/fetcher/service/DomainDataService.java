package com.data.fetcher.service;

import com.data.fetcher.model.Root;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
@AllArgsConstructor
public class DomainDataService {

    private final RabbitDataSender rabbitDataSender;


    public void rawData(String domainName) {
//        ObjectMapper objectMapper = new ObjectMapper();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create("https://api.domainsdb.info/v1/domains/search?domain=" + domainName))
                .build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(this.rabbitDataSender::send)
                .join();
    }

//    private Root getRoot(ObjectMapper objectMapper, String body) {
//        try {
//            return objectMapper.readValue(body, Root.class);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
}
