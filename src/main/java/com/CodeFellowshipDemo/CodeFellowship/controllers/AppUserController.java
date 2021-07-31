package com.CodeFellowshipDemo.CodeFellowship.controllers;

import com.CodeFellowshipDemo.CodeFellowship.models.AppUser;
import com.CodeFellowshipDemo.CodeFellowship.repositories.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppUserController {

    @Autowired
    private AppUserRepo appUserRepo ;

    @GetMapping("/profile")
    public String getProfilePage(Model model){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AppUser appUser = appUserRepo.findApplicationUserByUsername(userDetails.getUsername());
        model.addAttribute("appUser" , appUser);
        model.addAttribute("posts" , appUser.getPosts());
        return "profile" ;
    }
}

