package com.video.controller;

public class R<T> {
    private int code;
    private String msg;
    private T body;

    public R() {
    }

    public R(int code, String msg, T body) {
        this.code = code;
        this.msg = msg;
        this.body = body;
    }

    public static R failed() {
        return new R(-1,"请求失败",null);
    }

    public  static <T> R success(T t) {
        return new R(0,"请求成功",t);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}
