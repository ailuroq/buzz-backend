package com.buzz.controller;


import com.buzz.domain.Role;
import com.buzz.domain.User;
import com.buzz.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@CrossOrigin(origins="*")
@RestController
@RequestMapping(value = "/api")
public class RegistrationController {
    private final UserRepo userRepo;

    public RegistrationController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @RequestMapping(value="/login",  method = {RequestMethod.GET, RequestMethod.POST})
    public User addUser(@RequestBody User user ) {
        User userFromDb = userRepo.findByUsername(user.getUsername());

        /* if (userFromDb != null) {
            model.put("message", "User exists!");
            return "registration";
        }*/


        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        return userRepo.save(user);

    }
}
