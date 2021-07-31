package com.data.fetcher.model;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class Root implements Serializable {
    private List<Domain> domains;
    private int total;
    private String time;
    private Object next_page;
}
