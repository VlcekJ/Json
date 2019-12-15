package org.vlcek.json.objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.List;

@JsonPropertyOrder({
        "details",
        "version",
        "rates"
})
public class Root {



    @JsonProperty("details")
    private String details;
    @JsonProperty("version")
    private Object version;
    @JsonProperty("rates")
    private List<Rates> rates = new ArrayList<Rates>();

    @JsonProperty("details")
    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Object getVersion() {
        return version;
    }

    public void setVersion(Object version) {
        this.version = version;
    }

    @JsonProperty("rates")
    public List<Rates> getRates() {
        return rates;
    }

}
