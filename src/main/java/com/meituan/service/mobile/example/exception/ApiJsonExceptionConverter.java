/**
 * 
 */
package com.meituan.service.mobile.example.exception;

import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.servlet.ModelAndView;

import com.meituan.service.mobile.example.utils.ObjectMapperUtils;
import com.meituan.service.mobile.example.view.ResultView;

/**
 * 
 * 
 * @author zhengxu
 * @created 2013-3-13
 * 
 * @version 1.0
 */
@Component("apiJsonExceptionConverter")
public class ApiJsonExceptionConverter implements ExceptionConverter {

    private final Logger logger = Logger.getLogger(getClass());

    static Pattern pattern = Pattern
            .compile("Required (.+) parameter ('.+') is not present");

    // static Pattern urlInvalidPattern = Pattern
    // .compile("Invalid uri '.+(\\{.+?\\}).*': escaped absolute path not valid");
    static Pattern urlInvalidPatternA = Pattern
            .compile("Invalid uri '.+(\\{.+?\\}).*': escaped absolute path not valid");

    static Pattern urlInvalidPatternB = Pattern
            .compile("Invalid uri '.+(\\[.+?\\]).*': escaped absolute path not valid");

    static Pattern methodPattern = Pattern
            .compile("Request method ('.+') not supported");

    @Override
    public ModelAndView convert(HttpServletRequest request,
            HttpServletResponse response, Object handler, Exception exception) {
        response.setContentType("application/json;charset=utf-8");
        response.setStatus(200);
        int errCode = 500;
        if (exception instanceof BaseException) {
            errCode = ((BaseException) exception).getErrCode();

            // 服务器错误的时候就设置response为500
            if (errCode >= 500000 || (errCode >= 500 && errCode < 600)) {
                response.setStatus(500);
            }

            logger.info("SpringCatchedException-- " + errCode, exception);
        } else {
            response.setStatus(500);
            logger.info("SpringCatchedException** ", exception);
        }
        try {
            PrintWriter pw = response.getWriter();

            if (logger.isDebugEnabled()) {
                logger.debug(exception.getClass());
                logger.debug(exception instanceof java.lang.IllegalArgumentException);
            }
            if (StringUtils.isNotEmpty(exception.getMessage())) {
                String packageName = "com.diandian";
                if (exception instanceof BaseException) {
                    logger.debug("BaseException");
                    pw.print(ObjectMapperUtils.toJSON(new ResultView(errCode,
                            exception.getMessage())));
                } else if (exception.getClass().getPackage().getName()
                        .startsWith(packageName)) {
                    pw.print(ObjectMapperUtils.toJSON(new ResultView(errCode,
                            "服务器出错了,请稍后重试^o^")));
                } else if (exception instanceof MissingServletRequestParameterException) {
                    String message = null;
                    Matcher matcher = pattern.matcher(exception.getMessage());
                    if (matcher.find()) {
                        message = "缺少类型为" + matcher.group(1) + "的"
                                + matcher.group(2) + "参数";
                    } else {
                        message = "服务器出错了,请稍后重试^O^";
                    }
                    pw.print(ObjectMapperUtils.toJSON(new ResultView(errCode,
                            message)));
                } else if (exception instanceof HttpRequestMethodNotSupportedException) {
                    String message = null;
                    Matcher matcher = methodPattern.matcher(exception
                            .getMessage());
                    if (matcher.find()) {
                        message = matcher.group(1) + "请求方法不支持";
                    } else {
                        message = "服务器出错了,请稍后重试^O^";
                    }
                    pw.print(ObjectMapperUtils.toJSON(new ResultView(errCode,
                            message)));
                } else if (exception instanceof IllegalArgumentException) {
                    // String message =
                    // "Invalid uri 'http://test.c.diandian.com/v1/tag/watch/[/type]': escaped absolute path not valid";
                    logger.debug("IllegalArgumentException");
                    String message = null;
                    Matcher matcherA = urlInvalidPatternA.matcher(exception
                            .getMessage());
                    if (matcherA.find()) {
                        message = "请替换url中'" + matcherA.group(1) + "'的内容";
                    } else {
                        Matcher matcherB = urlInvalidPatternB.matcher(exception
                                .getMessage());
                        if (matcherB.find()) {
                            message = "请参考文档替换或去除url中'" + matcherB.group(1)
                                    + "'的内容";
                        } else {
                            message = "服务器出错了,请稍后重试^O^";
                        }
                    }
                    pw.print(ObjectMapperUtils.toJSON(new ResultView(errCode,
                            message)));
                } else if (exception instanceof RuntimeException) {
                    pw.print(ObjectMapperUtils.toJSON(new ResultView(errCode,
                            "服务器出错了,请稍后重试^_^")));
                } else {
                    pw.print(ObjectMapperUtils.toJSON(new ResultView(errCode,
                            "服务器出错了,请稍后重试^.^")));
                }
            } else {
                pw.print(ObjectMapperUtils.toJSON(new ResultView(errCode,
                        "服务器出错了,请稍后重试^-^")));
            }
            pw.flush();
            pw.close();
        } catch (Exception e) {
            logger.debug("Ops.", e);
        }
        return new ModelAndView();
    }

    public static void main(String[] args) {
        Pattern pattern = Pattern
                .compile("Required (.+) parameter ('.+') is not present");
        String s = "Required String parameter 'tag' is not present";
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()) {
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
        }
    }
}
