package vn.ladystudio.servicef.exception;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.camel.util.json.JsonObject;

@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {

    @JsonProperty("errorCode")
    private String errorCode;

    @JsonProperty("errorDescription")
    private String errorDescription;

    @JsonProperty("message")
    private ErrorMessage message;

    @JsonProperty("data")
    private JsonObject data;

    public ErrorResponse(String errorCode) {
        this.errorCode = errorCode;
        this.errorDescription = "";
        this.message = new ErrorMessage();
        this.data = new JsonObject();
    }


}
