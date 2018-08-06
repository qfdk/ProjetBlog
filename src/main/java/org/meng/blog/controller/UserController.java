package org.meng.blog.controller;

import org.meng.blog.entity.User;
import org.meng.blog.respository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    UserRespository userRespository;

    @GetMapping(value = "/")
    public String index(ModelMap modelMap){

        modelMap.addAttribute("users",userRespository.findAll());
//        System.out.println(userRespository.findAll().size());
        return "index";
    }

    @GetMapping(value = "/add")
    public String adduser(@ModelAttribute("user") User user){
        return "add";
    }

    @PostMapping(value = "/add")
    public String adduser(@ModelAttribute("user") User user, ModelMap modelMap){
        userRespository.save(user);
        modelMap.addAttribute("users",userRespository.findAll());
        return "index";
    }

/*
    @GetMapping(value = "/search")
    public String searche (@PathVariable("id") long id, Model model){

        model.addAttribute("users",userRespository.findById(id));
        return "redirect:/index";
    }

*/

    @GetMapping(value = "/edit")
    public String edit(@RequestParam("id") Integer id, ModelMap modelMap){

        modelMap.addAttribute("user",userRespository.getOne(id));
        return "edit";

    }

    @PostMapping(value = "/edit")
    public String edit(@ModelAttribute("user") User user, ModelMap modelMap){

        userRespository.save(user);
        modelMap.addAttribute("users",userRespository.findAll());
        return "index";

    }

    @GetMapping(value = "/delete")
    public String delete (@RequestParam("id") Integer id, ModelMap modelMap){

        userRespository.deleteById(id);
        modelMap.addAttribute("users",userRespository.findAll());
        return "index";
    }
}
