package au.com.scottellis.instagramclient.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.URL;

/**
 * Details for an image
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ImageResolution {
    private String url;
    private Integer width;
    private Integer height;

    @JsonCreator
    public ImageResolution(@JsonProperty("url") String url,
                           @JsonProperty("width") Integer width,
                           @JsonProperty("height") Integer height)
    {
        this.url = url;
        this.width = width;
        this.height = height;
    }

    public String getUrl() {
        return url;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }
}
