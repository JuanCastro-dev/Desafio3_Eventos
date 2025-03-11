package io.github.juandev.msticketmanager.exception;

public class NotFoundException extends RuntimeException {

    private String resource;
    private String code;

    public NotFoundException(String msg) {
        super(msg);
    }

    public NotFoundException(String resource, String code) {
        this.resource = resource;
        this.code = code;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}