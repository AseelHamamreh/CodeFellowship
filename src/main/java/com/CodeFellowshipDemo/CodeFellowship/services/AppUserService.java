package com.CodeFellowshipDemo.CodeFellowship.services;

import com.CodeFellowshipDemo.CodeFellowship.models.AppUser;
import com.CodeFellowshipDemo.CodeFellowship.repositories.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserService implements UserDetailsService {

    @Autowired
    private AppUserRepo appUserRepo ;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser applicationUser = appUserRepo.findApplicationUserByUsername(username);

        if(applicationUser == null)
            throw new UsernameNotFoundException("user name not exist");
        return applicationUser ;
    }
}
