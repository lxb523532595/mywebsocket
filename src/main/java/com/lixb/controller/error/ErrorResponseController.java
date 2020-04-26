package com.lixb.controller.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@ControllerAdvice
public class ErrorResponseController {

    @GetMapping("404")
    public String e404(HttpServletResponse response) {
        try {
            response.sendRedirect("/error");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/page")
    public String error404(){
        return "/error/404";
    }

    @GetMapping("500")
    public String e500() {
        System.out.println("500............");
        return "这真的是一个500页面，你看看";
    }
}