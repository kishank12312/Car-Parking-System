package com.example.demo.registration;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping
    public String register(Model model,
                           @RequestBody String requestbody,
                           String firstName,
                            String lastName,
                            String email,
                            String username,
                            String address,
                            String carRegistrationNum,
                            String password,
                            String otp) {
        RegistrationRequest request = new RegistrationRequest(firstName,
        lastName,
        email,
        username,
        address,
        carRegistrationNum,
        password,
        otp
        );
        model.addAttribute("email", email);
        return registrationService.register(request);
    }


}