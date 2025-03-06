package com.SpringOauth2.SpringOauth2;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class HelloController {

    @GetMapping
    public String Hello(){
        return "Hi, This is Home";
    }

    @GetMapping("/user")
    public Principal user(Principal user){
        return user;
    }
}
