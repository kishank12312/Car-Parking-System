package com.example.demo.module2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class SearchResultController {

    @PostMapping
    public String searchresult(Model model, @RequestBody String Location, String Hrs, String Date){

        return "abc";
    }
}
