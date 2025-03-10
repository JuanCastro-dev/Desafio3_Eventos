package io.github.juandev.mseventmanager.exception;

import lombok.Getter;

public class BadRequestException extends RuntimeException {
    private String resource;
    private String code;
    private String msg;

    public BadRequestException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public BadRequestException(String resource, String code) {
        this.resource = resource;
        this.code = code;
    }

    public String getResource() {
        return resource;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
