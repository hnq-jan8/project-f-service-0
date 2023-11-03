package vn.ladystudio.servicef.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class LoginRequest {

    /*
     * {
     *   "usr": "user1",
     *   "pwd": "abCxyZ@123!@"
     * }
     *
     * */

    @JsonProperty("usr")
    private String usr;

    @JsonProperty("pwd")
    private String pwd;

    public void setUsr(String usr) {
        this.usr = usr;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

}
