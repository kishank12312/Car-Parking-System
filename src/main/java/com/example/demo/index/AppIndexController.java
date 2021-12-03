package com.example.demo.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppIndexController {
    @GetMapping("/index")
    public String  goHome(){
        return "register";
    }
}
