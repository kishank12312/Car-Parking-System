package com.example.demo.appuser;


import com.example.demo.registration.MailService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG =
            "user with email %s not found";

    private final AppUserRepository appUserRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final OTPGenerator otpGenerator = new OTPGenerator();
    private final MailService mailService;

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                String.format(USER_NOT_FOUND_MSG, email)));
    }

    public String signUpUser(AppUser appUser){
        System.out.println(appUserRepository);
        boolean userExists = appUserRepository.findByEmail(appUser.getEmail()).isPresent();
        if(userExists){
            throw new IllegalStateException("Email Already Exists");
        }

        String encodedPassword = bCryptPasswordEncoder.encode((appUser.getPassword()));
        int otp = otpGenerator.generate();
        appUser.setOtp(String.valueOf(otp));
        appUser.setPassword(encodedPassword);
        String message = "Greetings. A user has requested an OTP to verify their account on Car Parking System. Please enter the OTP: \n" + String.valueOf(otp) + " \n to verify your account. Thank you.";
        mailService.sendMessage(message, appUser.getEmail());

        appUserRepository.save(appUser);
        return "index";
    }
}