package com.ezliv.infrastructure.controllers;

public class DefaultBody<T>{
    private T data;

    public DefaultBody() {
    }

    public DefaultBody(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
