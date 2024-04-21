package pl.coderslab.task3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Person;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @GetMapping("/form")
    public String displayStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "student/form-student";
    }

    @PostMapping("/form")
    @ResponseBody
    public String sendFromStudent(Student student) {
        return student.toString();
    }

    @ModelAttribute("countries")
    public List<String> countries() {
        return Arrays.asList("Poland", "Germany", "France", "Russia", "Denmark");
    }

    @ModelAttribute("studentSkills")
    public List<String> skills(){
        return Arrays.asList("Java", "Python", "JavaScript", "C++");
    }

    @ModelAttribute("studentHobbies")
    public List<String> hobbies(){
        return Arrays.asList("Food", "Football", "Hiking", "Swimming");
    }
}
