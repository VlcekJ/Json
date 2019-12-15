package org.vlcek.json.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InRates {
    @JsonProperty("super_reduced")
    private Integer super_reduced;
    @JsonProperty("reduced")
    private Integer reduced;
    @JsonProperty("standard")
    private Integer standard;
    @JsonProperty("parking")
    private Integer parking;
    @JsonProperty("reduced1")
    private Integer reduced1;
    @JsonProperty("reduced2")
    private Integer reduced2;

    @JsonProperty("super_reduced")
    public Integer getSuperReduced() {
        return super_reduced;
    }

    @JsonProperty("reduced")
    public Integer getReduced() {
        return reduced;
    }


    @JsonProperty("standard")
    public Integer getStandard() {
        return standard;
    }
}
