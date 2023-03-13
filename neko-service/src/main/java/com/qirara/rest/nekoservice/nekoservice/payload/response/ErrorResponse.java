package com.qirara.rest.nekoservice.nekoservice.payload.response;

public class ErrorResponse <T>{

    public ErrorResponse(Integer code, String status, T error) {
        this.code = code;
        this.status = status;
        this.error = error;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public T getError() {
        return error;
    }

    public void setError(T error) {
        this.error = error;
    }

    private Integer code;

    private String status;

    private T error;

}
