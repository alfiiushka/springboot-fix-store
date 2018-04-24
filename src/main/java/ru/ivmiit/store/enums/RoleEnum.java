package ru.ivmiit.store.enums;

public enum RoleEnum {
    USER("1");

    private String code;

    RoleEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
