package com.CodeFellowshipDemo.CodeFellowship.repositories;

import com.CodeFellowshipDemo.CodeFellowship.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepo extends JpaRepository<AppUser, Long> {
    AppUser findApplicationUserByUsername(String username);
}