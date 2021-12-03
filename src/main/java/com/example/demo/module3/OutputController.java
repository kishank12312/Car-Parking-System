package com.example.demo.module3;

import org.springframework.stereotype.Controller;

@Controller
public class OutputController {
    public String outputDisplay(OutputRequest outputRequest) {
        System.out.println(outputRequest.getWhichButton());
        if (outputRequest.getWhichButton() == "View") {
            //LOGIC FOR VIEW
        } else if (outputRequest.getWhichButton() == "Delete") {
            //LOGIC FOR DELETING
        }
        return "hello";
    }

}