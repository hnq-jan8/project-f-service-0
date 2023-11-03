package vn.ladystudio.servicef.exception;

public interface ErrorCode {

    /*
     * code:
     *   FCode-10:
     *   FCode-20:
     *   FCode-30:
     *   FCode-40: auth
     *
     * */

    String SUCCESS = "FCode-40-000";
    String NULL_OR_EMPTY = "FCode-40-001";
    String EMAIL_WRONG_FORMAT = "FCode-40-002";
    String DATE_WRONG_FORMAT = "FCode-40-003";
    String INTERNAL_SERVER_ERROR = "FCode-40-500";
    String CREDENTIALS_WRONG = "FCode-40-401";
    String CREDENTIALS_INVALID = "FCode-40-402";
}
