package au.com.scottellis.instagramclient.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Like info for a photo
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Likes {
    private Integer count;
    private List<UserData> data;

    @JsonCreator
    public Likes(@JsonProperty("count") Integer count,
                 @JsonProperty("data") List<UserData> data)
    {
        this.count = count;
        this.data = data;
    }

    public Integer getCount() {
        return count;
    }

    public List<UserData> getData() {
        return data;
    }
}
