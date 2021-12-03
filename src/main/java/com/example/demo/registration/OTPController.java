package com.example.demo.registration;
import java.sql.*;
import java.util.Optional;

import com.example.demo.appuser.AppUser;
import com.example.demo.appuser.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class OTPController {

    @Autowired
    private AppUserRepository appUserRepository;

    @PostMapping("/otpVerification")
    public RedirectView Verify(Model model, @RequestBody String request, String otp, String email){
        Optional appUsers = appUserRepository.findByEmail(email);
        AppUser appUser = (AppUser) appUsers.get();
        System.out.println(appUser.getOtp());
        System.out.println(otp);
        System.out.println(email);
        if(appUser.getOtp().equals(otp)){
            appUser.setEnabled(true);
            appUserRepository.save(appUser);
            RedirectView redirectView = new RedirectView();
            redirectView.setUrl("http://localhost:8081/login");
            return redirectView;
        }
        else
            throw new IllegalStateException("OTP Incorrect");
        //return "list";
    }
}
