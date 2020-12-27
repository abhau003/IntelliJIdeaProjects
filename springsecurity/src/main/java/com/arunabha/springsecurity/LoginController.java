package com.arunabha.springsecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @RequestMapping(method= RequestMethod.GET,value="/hello")
    public String Hello(){
        return "<h1>Welcome</h1>";
    }
}
