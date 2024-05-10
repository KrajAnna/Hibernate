package articleManager.controller;

import articleManager.dao.ArticleDao;
import articleManager.entity.Article;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
public class HomePageController {
    private final ArticleDao articleDao;

    public HomePageController(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }


    @ResponseBody
    @RequestMapping
    public String findQty(){
        List<String> resultList = articleDao.findAll().stream()
                .map(article -> {
                    StringBuilder sb = new StringBuilder();
                    sb.append(article.getTitle()).append(", ")
                            .append(article.getContent()).append(", ")
                            .append(article.getUpdated()).append("\n");
                    return sb.toString();
                })
                .collect(Collectors.toList());
        return resultList.toString();
    }


}
