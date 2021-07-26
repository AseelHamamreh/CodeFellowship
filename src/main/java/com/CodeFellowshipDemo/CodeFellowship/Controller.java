package com.CodeFellowshipDemo.CodeFellowship;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping("/home")
    public String HomePage(){
        return "index";
    }

}
