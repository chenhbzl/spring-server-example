package com.meituan.service.mobile.example.view;

public class ResultView {

    private int code = ResultCode.OK;
    private String message;
    private Object response;

    public static ResultView OK = new ResultView(ResultCode.OK, "");

    public ResultView(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResultView(Object responseBody) {
        this.response = responseBody;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return message;
    }

    public Object getResponse() {
        return response;
    }
}
