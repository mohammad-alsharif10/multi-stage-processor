package com.data.fetcher.controller;

import com.data.fetcher.model.Root;
import com.data.fetcher.service.DomainDataService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@AllArgsConstructor
public class DomainDataController {

    private final DomainDataService domainDataService;

    @RequestMapping(value = "/domain/{domainName}",method = RequestMethod.GET)
    public Root domainData(@PathVariable String domainName) {
        this.domainDataService.rawData(domainName);
        return null;
    }
}
