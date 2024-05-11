package pl.coderslab.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class ValidationController {
    private Validator validator;
    private static final Logger logger = LoggerFactory.getLogger(ValidationController.class);

    public ValidationController(Validator validator) {
        this.validator = validator;
    }

    @GetMapping("/validate")
    public String validate(Model model) {
 Book book = new Book();
//        book.setTitle("abd");
//        book.setRating(15);
//        book.setPages(1);
//        Set<ConstraintViolation<Book>> constraintViolations = validator.validate(book);

        Author author = new Author();
        author.setFirstName("Anna");
        author.setLastName("Kraj");
        author.setPesel("12345678911");
        author.setEmail("anna@mail.com");
        Set <ConstraintViolation<Author>> constraintViolations = validator.validate(author);
//        Publisher publisher = new Publisher();
//        Set <ConstraintViolation<Publisher>> constraintViolations = validator.validate(publisher);

        //rozwiązanie w loggerze
//        if (!constraintViolations.isEmpty()) {
//            for (ConstraintViolation<Book> constraintViolation : constraintViolations){
//                logger.debug(constraintViolation.getPropertyPath() + "------------->" + constraintViolation.getMessage());
//            }
//            return "są blędy";
//        } else {
//            return "brak bledów";
//        }

        if (!constraintViolations.isEmpty()){
            List<String> result = constraintViolations.stream()
                    .map(c->c.getPropertyPath()+": " + c.getMessage())
                    .collect(Collectors.toList());
            model.addAttribute("result", result);

        } else {
            model.addAttribute("result", "brak blędów");
        }
        return "book/validation";


    }

}
