package com.acat.common;

public enum  ResponseCode {
    ;

    private final int code;

    ResponseCode(int code){
        this.code=code;
    }

    public int getCode() {
        return code;
    }


}
