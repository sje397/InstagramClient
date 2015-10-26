package au.com.scottellis.instagramclient.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Photo image links
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Images {
    private ImageResolution standardResolution;

    @JsonCreator
    public Images(@JsonProperty("standard_resolution") ImageResolution standardResolution) {
        this.standardResolution = standardResolution;
    }

    public ImageResolution getStandardResolution() {
        return standardResolution;
    }
}
