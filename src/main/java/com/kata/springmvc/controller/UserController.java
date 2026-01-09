package com.kata.springmvc.controller;

import com.kata.springmvc.model.User;
import com.kata.springmvc.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/new")
    public String newForm(Model model) {
        model.addAttribute("user", new User());
        return "user-form";
    }
    @GetMapping
    public String list(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users";
    }
    @PostMapping("/save")
    public String save(
            @RequestParam(required = false) Long id,
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam Integer age
    ) {
        User user = (id == null) ? new User() : userService.findById(id);
        user.setName(name);
        user.setEmail(email);
        user.setAge(age);
        userService.save(user);
        return "redirect:/users";

    }
    @GetMapping("/edit")
    public String edit(@RequestParam Long id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "user-form";
    }
    @PostMapping("/delete")
    public String delete(@RequestParam Long id) {
        userService.delete(id);
        return "redirect:/users";

    }




}
