package org.meng.blog.controller;

import org.meng.blog.entity.User;
import org.meng.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserControllor {

    @Autowired
    private UserRepository userepository;

    @Value("${user.name}")
    private String name;

    @GetMapping(value = "/")
    public String hello (ModelMap model){

        model.addAttribute("users", userepository.findAll());
        return "index";

    }

    @GetMapping(value = "/add")
    public String addUsers (@RequestParam("name") String name, ModelMap model){

        User newuser = new User();
        newuser.setName(name);
        userepository.save(newuser);
        model.addAttribute("users", userepository.findAll());
        return "index";

    }

}
