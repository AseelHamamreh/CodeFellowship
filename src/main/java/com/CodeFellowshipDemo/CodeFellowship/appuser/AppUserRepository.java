package com.CodeFellowshipDemo.CodeFellowship.appuser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface AppUserRepository extends JpaRepository<ApplicationUser, Long> {

    Optional<ApplicationUser> findByEmail(String email);

}