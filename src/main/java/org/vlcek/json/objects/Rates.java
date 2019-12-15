package org.vlcek.json.objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.List;

@JsonPropertyOrder({
        "name",
        "code",
        "country_code",
        "periods"
})

public class Rates {
    @JsonProperty("name")
    private String name;
    @JsonProperty("code")
    private String code;
    @JsonProperty("country_code")
    private String countryCode;
    @JsonProperty("periods")
    private List<Periods> periods = new ArrayList<Periods>();


    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("code")
    public String getCode() {
        return code;
    }
    @JsonProperty("country_code")
    public String getCountryCode() {
        return countryCode;
    }

    @JsonProperty("periods")
    public List<Periods> getPeriods() {
        return periods;
    }
}

