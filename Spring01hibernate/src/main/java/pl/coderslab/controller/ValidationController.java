package pl.coderslab.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.entity.Book;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
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
    @ResponseBody
    public String validate() {
        Book book = new Book();
        book.setTitle("abd");
        book.setRating(15);
        book.setPages(1);
        Set<ConstraintViolation<Book>> constraintViolations = validator.validate(book);

        //rozwiązanie w debuggerze
//        if (!constraintViolations.isEmpty()) {
//            for (ConstraintViolation<Book> constraintViolation : constraintViolations){
//                logger.debug(constraintViolation.getPropertyPath() + "------------->" + constraintViolation.getMessage());
//            }
//            return "są blędy";
//        } else {
//            return "brak bledów";
//        }

        if (!constraintViolations.isEmpty()){
            String result = constraintViolations.stream()
                    .map(c->c.getPropertyPath()+ "-------->" + c.getMessage())
                    .collect(Collectors.joining(", "));
            return result;
        } else {
            return "brak blędów";
        }


    }

}
