package com.cloud.streamfilter.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class Domain implements Serializable {
    private String domain;
    private Date create_date;
    private Date update_date;
    private String country;
    private String isDead;
    @JsonProperty("A")
    private List<String> a;
    @JsonProperty("NS")
    private List<String> nS;
    @JsonProperty("CNAME")
    private Object cNAME;
    @JsonProperty("MX")
    private List<MX> mX;
    @JsonProperty("TXT")
    private List<String> tXT;
}
