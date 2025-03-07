package com.SpringOauth2.SpringOauth2;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/profile")
    public String profile(OAuth2AuthenticationToken token, Model model){
        model.addAttribute("name",token.getPrincipal().getAttribute("name"));
        model.addAttribute("email",token.getPrincipal().getAttribute("email"));
        //model.addAttribute("profile",token.getPrincipal().getAttribute("picture"));
        String profilePicture = token.getPrincipal().getAttribute("picture");

        // Remove Google URL modifiers
        if (profilePicture != null && profilePicture.contains("=")) {
            profilePicture = profilePicture.substring(0, profilePicture.indexOf('='));
        }

        assert profilePicture != null;
        model.addAttribute("profile", profilePicture);


        return "user-profile";
    }
}
