package com.example.user_spring_boot.controller;

import com.example.user_spring_boot.model.User;
import com.example.user_spring_boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Controller
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/users")
    public String printUsers(ModelMap modelMap) {
        modelMap.addAttribute("usersList", userService.getAllUsers());
        return "/users";
    }

    @GetMapping(value = "create")
    public String create(ModelMap modelMap) {
        modelMap.addAttribute("user", new User());
        return "create";
    }

    @PostMapping("create")
    public String addUser(@ModelAttribute(value = "user") User user) {
        userService.add(user);
        return "redirect:/users";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam(value = "id", required = false) Integer id, ModelMap modelMap) {
        modelMap.addAttribute("user", userService.findUserById(id));
        return "/edit";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute(value = "user") User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }

    @PostMapping("users")
    public String delete(@RequestParam(value = "id", required = false) Integer id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }
}

