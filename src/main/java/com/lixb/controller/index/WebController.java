package com.lixb.controller.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("web")
public class WebController {

    @RequestMapping("index")
    public String index(){
        return "index";
    }
}