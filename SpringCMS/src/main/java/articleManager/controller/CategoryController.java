package articleManager.controller;

import articleManager.dao.CategoryDao;
import articleManager.entity.Category;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/category")
public class CategoryController {
    private final CategoryDao categoryDao;

    public CategoryController(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @GetMapping("/form")
    public String displayForm(){
        return "cat-form";
    }

    @PostMapping("/form")
    @ResponseBody
    public String sendForm(@RequestParam String nameCat, @RequestParam String description){
        Category category = new Category();
        category.setDescription(description);
        category.setName(nameCat);
        categoryDao.add(category);
        return category.toString() + "Kategoria została dodana pod ID: " + category.getId();
    }


}
