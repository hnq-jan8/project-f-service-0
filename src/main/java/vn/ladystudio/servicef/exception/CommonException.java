package vn.ladystudio.servicef.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
public class CommonException extends RuntimeException {

    @Setter
    private ErrorResponse response;

    public CommonException() {
        super();
        setResponse(new ErrorResponse());
    }

    public CommonException(String errorCode) {
        super(errorCode);
        setResponse(new ErrorResponse(errorCode));
    }

}
