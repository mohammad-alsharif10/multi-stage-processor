package com.cloud.streamfilter;


import com.cloud.streamfilter.model.Domain;
import com.cloud.streamfilter.model.Root;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.function.Function;

@SpringBootApplication
public class CloudStreamFilterApplication {


    public static void main(String[] args) {
        SpringApplication.run(CloudStreamFilterApplication.class, args);
    }

}
