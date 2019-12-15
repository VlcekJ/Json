package org.vlcek.json.objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "effective_from",
        "rates"
})

public class Periods {
    @JsonProperty("effective_from")
    private String effective_from;
    @JsonProperty("rates")
    private InRates inRates;

    @JsonProperty("effective_from")
    public String getEffectiveFrom() {
        return effective_from;
    }

    @JsonProperty("rates")
    public InRates getRates() {
        return inRates;
    }

}

