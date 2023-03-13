package com.qirara.rest.nekoservice.nekoservice.payload.response;

public class WebResponse <T>{

    private Integer code;

    private String status;

    private  T data;
}
