package au.com.scottellis.instagramclient.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.joda.time.DateTime;

/**
 * Photo comment
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Comment {
    private DateTime createdTime;
    private String text;
    private UserData from;
    private String id;

    @JsonCreator
    public Comment(@JsonProperty("created_time") String createdTime,
                   @JsonProperty("text") String text,
                   @JsonProperty("from") UserData from,
                   @JsonProperty("id") String id)
    {
        this.createdTime = new DateTime(Long.parseLong(createdTime) * 1000L);
        this.text = text;
        this.from = from;
        this.id = id;
    }

    public DateTime getCreatedTime() {
        return createdTime;
    }

    public String getText() {
        return text;
    }

    public UserData getFrom() {
        return from;
    }

    public String getId() {
        return id;
    }
}
