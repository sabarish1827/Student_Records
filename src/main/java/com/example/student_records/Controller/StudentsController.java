package com.example.student_records.Controller;

import com.example.student_records.Domain.Student;
import com.example.student_records.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class StudentsController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String viewHomePage(Model model){
        List<Student> listStudents = studentService.listAll();
        model.addAttribute("listStudents", listStudents);
        return "index";
    }
    @GetMapping("/new")
    public String newStudent(Model model){
        model.addAttribute("student", new Student());
        return "new_student";
    }
    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("student") Student student){
        studentService.save(student);
        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public ModelAndView editStudent(@PathVariable("id") int id){
        ModelAndView mav = new ModelAndView("new_student");
        Student student = studentService.get(id);
        mav.addObject("student", student);
        return mav;
    }
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") int id){
        studentService.delete(id);
        return "redirect:/";
    }
}
