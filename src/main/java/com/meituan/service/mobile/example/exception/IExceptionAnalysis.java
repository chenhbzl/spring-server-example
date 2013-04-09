package com.meituan.service.mobile.example.exception;

import javax.servlet.http.HttpServletRequest;

public interface IExceptionAnalysis {

    public void onError(HttpServletRequest requset, Exception exception);
}
