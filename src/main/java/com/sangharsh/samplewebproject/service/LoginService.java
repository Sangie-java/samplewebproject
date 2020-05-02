package com.sangharsh.samplewebproject.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
    public boolean validateUserId(String userId, String password){
        return userId.equalsIgnoreCase("Sangharsh") &&
                password.equals("admin");
    }
}
