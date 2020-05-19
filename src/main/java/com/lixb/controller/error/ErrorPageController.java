package com.lixb.controller.error;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.Map;

//@Controller
//@RequestMapping("${server.error.path:${error.path:/error}}")
public class ErrorPageController extends BasicErrorController {

    @Autowired
    public ErrorPageController(ErrorAttributes errorAttributes, ServerProperties serverProperties) {
        super(errorAttributes,serverProperties.getError());
    }

    @Override
    @RequestMapping(produces = "text/html")
    public ModelAndView errorHtml(HttpServletRequest request, HttpServletResponse response) {
        HttpStatus status = getStatus(request);
        Map<String, Object> model = Collections
                .unmodifiableMap(getErrorAttributes(request, isIncludeStackTrace(request, MediaType.TEXT_HTML)));
        response.setStatus(status.value());
        ModelAndView modelAndView = resolveErrorView(request, response, status, model);
        if(modelAndView==null){
            modelAndView = new ModelAndView();
        }
        String errorCodeStr = String.valueOf(status.value());
        if(errorCodeStr.startsWith("5")){
            modelAndView.setViewName("/error/500");
        }else{
            modelAndView.setViewName("/error/404");
        }
        try {
            System.out.println("message:"+new ObjectMapper().writeValueAsString(modelAndView));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return modelAndView;
    }
}
