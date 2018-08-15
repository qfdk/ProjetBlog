package org.meng.blog.controller;

import org.meng.blog.respository.ArticleRespository;
import org.meng.blog.respository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MixControllor {

    @Autowired
    UserRespository userRespository;

    @Autowired
    ArticleRespository articleRespository;

    @GetMapping(value = "/hello")
    public String welcomePage(){

        return "hello";
    }

    @GetMapping(value = "/")
    public String index(ModelMap modelMap){

        modelMap.addAttribute("users",userRespository.findAll());
        modelMap.addAttribute("articles",articleRespository.findAll());

        return "index";
    }


}
