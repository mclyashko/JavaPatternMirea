package ru.mirea.task18.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
    @SuppressWarnings("SameReturnValue")
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getTestPage() {
        return "home";
    }
}
