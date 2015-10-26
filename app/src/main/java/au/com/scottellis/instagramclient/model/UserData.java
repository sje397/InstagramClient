package au.com.scottellis.instagramclient.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.URL;

/**
 * User data from API
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserData {
    private String username;
    private String profilePic;
    private String id;
    private String fullName;

    @JsonCreator
    public UserData(@JsonProperty("username") String username,
                    @JsonProperty("profile_picture") String profilePic,
                    @JsonProperty("id") String id,
                    @JsonProperty("full_name") String fullName)
    {
        this.username = username;
        this.profilePic = profilePic;
        this.id = id;
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }
}
