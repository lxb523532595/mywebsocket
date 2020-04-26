package com.lixb.controller.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("web")
public class WebController {

    @RequestMapping("index")
    public String index(){
        return "index";
    }

    @RequestMapping("test")
    @ResponseBody
    public String test(){
        boolean b = 3>2;
        if(b){
            throw new RuntimeException("出错啦");
        }
        return "index";
    }
}