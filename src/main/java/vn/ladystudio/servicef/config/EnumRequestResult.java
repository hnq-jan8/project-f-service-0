package vn.ladystudio.servicef.config;

import lombok.Getter;

@Getter
public enum EnumRequestResult {
    SUCCESS("SUCCESS"),
    FAILED("FAILED");

    private final String value;

    EnumRequestResult(String value) {
        this.value = value;
    }

}
