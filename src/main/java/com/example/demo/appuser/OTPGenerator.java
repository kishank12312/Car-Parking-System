package com.example.demo.appuser;
import java.lang.Math;

public class OTPGenerator {
    int max = 9999;
    int min = 1000;
    public int generate(){
        int otp = (int)(Math.random()*(max-min+1)+min);
        return otp;
    }

}
