package com.meituan.service.mobile.example.exception;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * 
 * @author zhengxu
 * @created 2013-3-13
 * 
 * @version 1.0
 */
public abstract class BaseException extends RuntimeException {

    private String message;

    /**
     * 
     */
    private static final long serialVersionUID = 8002283590289218255L;

    protected BaseException() {
    }

    protected BaseException(String arg0) {
        super(arg0);
        this.message = arg0;
    }

    protected BaseException(Throwable arg0) {
        super(arg0);
        this.message = arg0.getMessage();
    }

    protected BaseException(String arg0, Throwable arg1) {
        super(arg0, arg1);
        this.message = arg0;
    }

    @Override
    public String getMessage() {
        if (StringUtils.isEmpty(message)) {
            this.message = "系统忙,请稍后再试~";// messageSourceWrapper的properties文件是通过spring装配的,这里就没办法了
        }
        return this.message;
    }

    public abstract int getErrCode();
}
