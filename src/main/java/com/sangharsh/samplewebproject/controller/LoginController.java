package com.sangharsh.samplewebproject.controller;

import com.sangharsh.samplewebproject.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginPage(ModelMap modelMap) {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String showWelcomePage(ModelMap modelMap, @RequestParam String name, @RequestParam String password) {
        boolean isValidUser = loginService.validateUserId(name, password);
        if (!isValidUser) {
            modelMap.put("errorMessage", "invalid credentials");
            return "login";
        }
        modelMap.put("name", name);
        modelMap.put("password", password);
        return "welcome";
    }
}
