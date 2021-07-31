package com.CodeFellowshipDemo.CodeFellowship.controllers;

import com.CodeFellowshipDemo.CodeFellowship.models.AppUser;
import com.CodeFellowshipDemo.CodeFellowship.repositories.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;

@Controller
public class RegisterationController {

    @Autowired
    private AppUserRepo appUserRepo ;
    @Autowired
    private BCryptPasswordEncoder encoder ;

    @GetMapping("/")
    public String homePage(){
        return "index";
    }


    @GetMapping("/signup")
    public String getSignupPage(){
        return "signup";
    }

    @PostMapping("/signup")
    public RedirectView createAppUser(@RequestParam String username , @RequestParam String password
            , @RequestParam String firstName , @RequestParam String lastName
            , @RequestParam String bio , @RequestParam String dateOfBirth){

        AppUser applicationUser = new AppUser(username , encoder.encode(password));
        applicationUser.setFirstName(firstName);
        applicationUser.setLastName(lastName);
        applicationUser.setDateOfBirth(dateOfBirth);
        applicationUser.setBio(bio);
        applicationUser = appUserRepo.save(applicationUser);

        Authentication authentication = new UsernamePasswordAuthenticationToken(applicationUser , null , new ArrayList<>());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new RedirectView("/");
    }

    @GetMapping("/login")
    public String getLoginPage(){
        return "login" ;
    }
}
