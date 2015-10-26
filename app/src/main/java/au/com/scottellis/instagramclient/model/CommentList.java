package au.com.scottellis.instagramclient.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * List of comments on a photo
 */
public class CommentList {
    private Integer count;
    private List<Comment> data;

    @JsonCreator
    public CommentList(@JsonProperty("count") Integer count,
                       @JsonProperty("data") List<Comment> data)
    {
        this.count = count;
        this.data = data;
    }

    public Integer getCount() {
        return count;
    }

    public List<Comment> getData() {
        return data;
    }
}
