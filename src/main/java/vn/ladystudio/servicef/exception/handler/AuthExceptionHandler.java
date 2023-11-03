//package vn.ladystudio.servicef.exception.handler;
//
//import org.springframework.core.PriorityOrdered;
//import org.springframework.core.annotation.Order;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//import vn.ladystudio.servicef.exception.AuthException;
//import vn.ladystudio.servicef.exception.ErrorCode;
//import vn.ladystudio.servicef.exception.ErrorResponse;
//
//@ControllerAdvice
//@RestController
//@Order(value = PriorityOrdered.HIGHEST_PRECEDENCE)
//public class AuthExceptionHandler extends ResponseEntityExceptionHandler {
//
//    @ExceptionHandler(value = Throwable.class)
//    public ResponseEntity<ErrorResponse> handleAuthException(Throwable e) {
//        HttpHeaders headers = new HttpHeaders();
//
//        if (e instanceof AuthException) {
//            return new ResponseEntity<>(((AuthException) e).getResponse(), headers, HttpStatus.BAD_REQUEST);
//        }
//
//        /*
//         * other exception type
//         * */
//
//        return new ResponseEntity<>(
//                new ErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR),
//                headers, HttpStatus.INTERNAL_SERVER_ERROR
//        );
//    }
//
//}
