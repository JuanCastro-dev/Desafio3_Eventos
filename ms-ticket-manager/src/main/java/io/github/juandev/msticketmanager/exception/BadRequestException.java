package io.github.juandev.msticketmanager.exception;

public class BadRequestException extends RuntimeException {

    private String msg;

    public BadRequestException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public BadRequestException() {
    }

    public String getMsg() {
        return msg;
    }
}
