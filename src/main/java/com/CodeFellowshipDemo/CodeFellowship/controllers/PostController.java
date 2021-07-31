package com.CodeFellowshipDemo.CodeFellowship.controllers;

import com.CodeFellowshipDemo.CodeFellowship.models.Post;
import com.CodeFellowshipDemo.CodeFellowship.repositories.AppUserRepo;
import com.CodeFellowshipDemo.CodeFellowship.repositories.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class PostController {

    @Autowired
    private AppUserRepo appUserRepo ;
    @Autowired
    private PostRepo postRepo ;

    @PostMapping("/newPost")
    public RedirectView addNewPost(@RequestParam String body){
        Post post = new Post(body);
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setApplicationUser(appUserRepo.findApplicationUserByUsername(userDetails.getUsername()));
        postRepo.save(post);
        return new RedirectView("/profile");
    }
}
