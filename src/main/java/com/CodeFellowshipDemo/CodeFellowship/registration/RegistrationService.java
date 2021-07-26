package com.CodeFellowshipDemo.CodeFellowship.registration;

import com.CodeFellowshipDemo.CodeFellowship.appuser.ApplicationUser;
import com.CodeFellowshipDemo.CodeFellowship.appuser.AppUserRole;
import com.CodeFellowshipDemo.CodeFellowship.appuser.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private AppUserService appUserService;
    private EmailValidator emailValidator;

    public String register(RegistrationRequest request) {
        Boolean isValidEmail = emailValidator.test(request.getEmail());
        if(!isValidEmail){
            throw new IllegalStateException("email not valid");
        }

        return appUserService.signUpUser(
                new ApplicationUser(
                        request.getFirstName(),
                        request.getLastName(),
                        request.getPassword(),
                        request.getEmail(),
                        request.getDateOfBirth(),
                        request.getBio(),
                        AppUserRole.USER

                )
        );
    }
}
