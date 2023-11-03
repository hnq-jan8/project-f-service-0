package vn.ladystudio.servicef.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class RegisterRequest {

    /*
     * {
     *   "username": "user1",
     *   "password": "abCxyZ@123!@",
     *   "email": "abc1@email.com"
     * }
     *
     * */

    @JsonProperty("username")
    private String username;

    @JsonProperty("password")
    private String password;

    @JsonProperty("email")
    private String email;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
