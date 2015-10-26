package au.com.scottellis.instagramclient.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * List of photos
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PhotoList {
    private List<Photo> data;

    @JsonCreator
    public PhotoList(@JsonProperty("data") List<Photo> data)
    {
        this.data = data;
    }

    public List<Photo> getData() {
        return data;
    }
}
