package fr.diginamic.demo.controller;

import fr.diginamic.demo.entity.Article;
import fr.diginamic.demo.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    ArticleRepository articleRepository;

    /** Formulaire de création d'article (GET) */
    @GetMapping("/new")
    public String showArticleForm(Model model) {
        model.addAttribute("article", new Article());
        return "createArticle"; // correspond à createArticle.html
    }

    /** Création d'un article (POST) */
    @PostMapping("/new")
    public String registerArticle(@ModelAttribute Article article) {
        articleRepository.save(new Article(article.getTitre(), article.getContenu()));
        return "redirect:/article/list"; // après création → liste
    }

    /** Liste des articles */
    @GetMapping("/list")
    public String listArticles(Model model) {
        model.addAttribute("articles", articleRepository.findAll());
        return "articleList"; // correspond à articleList.html
    }
}