package com.volerde.myweb.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * The type Controller exception handler.
 *
 * @author Volerde
 * @date 2021 /8/15 13:00
 */
@ControllerAdvice
public class ControllerExceptionHandler {
    //错误全局处理

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Exception handler model and view.
     *
     * @param request   the request
     * @param exception the exception
     * @return the model and view
     * @throws Exception the exception
     */
    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHandler(HttpServletRequest request,Exception exception) throws Exception {
        logger.error("Request URL : {},Exception : {}",request.getRequestURL(),exception);

        if(AnnotationUtils.findAnnotation(exception.getClass(), ResponseStatus.class) != null) {
            throw exception;
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("url",request.getRequestURL());
        modelAndView.addObject("exception",exception);
        modelAndView.setViewName("error/error");

        return modelAndView;
    }
}
