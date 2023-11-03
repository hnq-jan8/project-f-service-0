package vn.ladystudio.servicef.config;

import lombok.Getter;

@Getter
public enum EnumUserRole {
    ADMIN("ADMIN"),
    USER("USER");

    private final String value;

    EnumUserRole(String value) {
        this.value = value;
    }

}
