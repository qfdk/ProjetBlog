package org.meng.blog.controller;


import org.meng.blog.entity.Article;
import org.meng.blog.respository.ArticleRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;

@Controller
public class ArticleController {

    @Autowired
    ArticleRespository articleRespository;

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

    @GetMapping(value = "/deleteArticle")
    public String deleteArticle(@RequestParam("id") Integer id, ModelMap modelMap ){

        articleRespository.deleteById(id);
        modelMap.addAttribute("articles",articleRespository.findAll());
        return "index";
    }


}
