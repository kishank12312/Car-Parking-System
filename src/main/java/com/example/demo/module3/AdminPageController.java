package com.example.demo.module3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminPageController {

    @GetMapping("/adminpage")
    public String display(){
        return "list";
    }
}
