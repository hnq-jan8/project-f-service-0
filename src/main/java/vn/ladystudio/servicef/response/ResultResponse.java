package vn.ladystudio.servicef.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import vn.ladystudio.servicef.config.EnumRequestResult;

@Getter
public class ResultResponse {

    /*
     * {
     *   "status": "SUCCESS";
     *   "message": "Login successfully"
     * }
     *
     * */

    @JsonProperty("status")
    private String status;

    @JsonProperty("message")
    private String message;

    public ResultResponse(EnumRequestResult status, String message) {
        this.status = status.getValue();
        this.message = message == null ? "" : message;
    }

}
