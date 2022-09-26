package com.algor.codepool.common.term;

public class Result<T>{

    private T obj;
    private String message;
    private Integer code;

    public Result() {
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String ... message) {
        StringBuilder builder = new StringBuilder();
        builder.append(message);
        this.message = builder.toString();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
