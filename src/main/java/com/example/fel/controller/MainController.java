package com.example.fel.controller;

import com.example.fel.model.Role;
import com.example.fel.model.User;
import com.example.fel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collections;

@Controller
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @PersistenceContext
    private EntityManager entityManager;

        //everyone
    @GetMapping
    public String home(){
        return "home";
    }

        //logged people
    @GetMapping("/logged")
    public String auth() {
        return "redirect:/";
    }

        //only admins
    @GetMapping("/admin")
    public String adminPage() {
        return "admin";
    }

        //admins and users
    @GetMapping("/user")
    public String userPage() {
        return "user";
    }

        // registration
    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String registerUser(User user) {
        User userFromDB = userRepository.findUserByUsername(user.getUsername());
        if (userFromDB != null) {
            return "redirect:/";
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepository.save(user);
        //entityManager.persist(user);
        return "redirect:/user";
    }




}
