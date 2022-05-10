package ru.mirea.task24.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.mirea.task24.entities.User;
import ru.mirea.task24.services.UserService;

@Controller
public class AuthorizationController {
    @Autowired
    private UserService userService;

    @PostMapping("/registration")
    @ResponseBody
    public String signUp(@RequestBody User user) {
        User myUser = userService.findByUsername(user.getLogin());
        if (myUser != null) {
            return String.format("user with name %s already exists", user.getLogin());
        }
        userService.create(user);
        return "ok";
    }
}
