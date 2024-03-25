package com.example.demo.temp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @GetMapping("/demo")
    @ResponseBody
    public String index() {
        return  "demo";
    }

    @GetMapping("/")
    public String root(){
        return "redirect:/question/list";
    }
}
