package com.example.sweater.controller;

import com.example.sweater.model.Role;
import com.example.sweater.model.User;
import com.example.sweater.repository.UserRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;

@Controller
public class RegistrationController {

    private final UserRepository repository;

    public RegistrationController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model) {
        User userFromDb = repository.findByUsername(user.getUsername());
        if (userFromDb != null) {
            model.put("message", "User exist");
            return "registration";
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        repository.save(user);
        return "redirect:/login";
    }
}
