package org.meng.blog.controller;


import org.meng.blog.entity.Article;
import org.meng.blog.respository.ArticleRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;

import javax.persistence.Id;

@Controller
public class ArticleOnctroller {

    @Autowired
    ArticleRespository articleRespository;

    /*@GetMapping(value = "/")
    public String article (ModelMap modelMap){

        modelMap.addAttribute("articles",articleRespository.findAll());
        return "index";
    }*/

    @GetMapping(value = "/addarticle")
    public String addTitreArticle (@ModelAttribute("article") Article article){
        return "addarticle";
    }

    @PostMapping(value = "/addarticle")
    public String addTitreArticle (@ModelAttribute("article") Article article, ModelMap modelMap){

        articleRespository.save(article);
        modelMap.addAttribute("articles",articleRespository.findAll());

        return "index";
    }

}
