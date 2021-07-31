package com.cloud.streamfilter.model;


import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class MX implements Serializable {
    private String exchange;
    private int priority;
}
