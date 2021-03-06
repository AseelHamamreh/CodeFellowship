package com.CodeFellowshipDemo.CodeFellowship.controllers;

import com.CodeFellowshipDemo.CodeFellowship.models.AppUser;
import com.CodeFellowshipDemo.CodeFellowship.repositories.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

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
        List<AppUser> myList = appUserRepo.findAll();
        model.addAttribute("myList", myList);
        return "profile" ;
    }

    @GetMapping("/user/{userId}")
    public String getProfilePage(@PathVariable Long userId, Model model){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AppUser appUser = appUserRepo.findById(userId).orElseThrow();
        model.addAttribute("appUser" , appUser);
        model.addAttribute("posts" , appUser.getPosts());
        List<AppUser> myList = appUserRepo.findAll();
        model.addAttribute("myList", myList);
        return "user" ;
    }
}

