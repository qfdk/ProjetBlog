package org.meng.blog.controller;

import org.meng.blog.entity.User;
import org.meng.blog.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;


public class Controllor {

    @Autowired
    private Repository repository;

    @Value("${user.name}")
    private String name;

    @GetMapping(value = "/")
    public String hi (ModelMap model){

        model.addAttribute("users",repository.findAll());
        return "index";

    }

    @GetMapping(value = "/add")
    public String addUsers (@RequestParam("name") String name, ModelMap model){

        User newuser = new User();
        newuser.setName(name);
        repository.save(newuser);
        model.addAttribute("users", repository.findAll());
        return "index";

    }

}
