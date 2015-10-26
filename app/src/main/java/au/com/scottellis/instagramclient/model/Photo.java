package au.com.scottellis.instagramclient.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.joda.time.DateTime;

/**
 * Created by sellis on 10/25/15.
 *
 * Instagram client id: 5530a802b23648a0891aa812cbf033b4
 * URL: https://api.instagram.com/v1/media/popular?client_id=5530a802b23648a0891aa812cbf033b4
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Photo {
    private CommentList comments;
    private Images images;
    private Caption caption;
    private String type;
    private String id;
    private UserData user;
    private DateTime createdTime;
    private Likes likes;

    @JsonCreator
    public Photo(@JsonProperty("comments") CommentList comments,
                 @JsonProperty("images") Images images,
                 @JsonProperty("caption") Caption caption,
                 @JsonProperty("type") String type,
                 @JsonProperty("id") String id,
                 @JsonProperty("user") UserData user,
                 @JsonProperty("created_time") String createdTime,
                 @JsonProperty("likes") Likes likes)
    {
        this.comments = comments;
        this.images = images;
        this.caption = caption;
        this.type = type;
        this.id = id;
        this.user = user;
        this.createdTime = new DateTime(Long.parseLong(createdTime) * 1000L);
        this.likes = likes;
    }

    public CommentList getComments() {
        return comments;
    }

    public Images getImages() {
        return images;
    }

    public Caption getCaption() {
        return caption;
    }

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public UserData getUser() {
        return user;
    }

    public DateTime getCreatedTime() {
        return createdTime;
    }

    public Likes getLikes() {
        return likes;
    }
}
