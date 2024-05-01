package com.gl.training.fsd.bed.restful.controller;

import com.gl.training.fsd.bed.restful.entity.Student;
import com.gl.training.fsd.bed.restful.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/students/list")
    public String listStudents(Model model) {
        List<Student> studentList = studentService.getAllStudents();
        model.addAttribute("studentList", studentList);
        return "students";
    }

    @GetMapping("/students/addform")
    public String createStudentForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "create_student";
    }

    @PostMapping("/students/save")
    public String addStudent(@ModelAttribute Student student) {
        studentService.addStudent(student);
        return "redirect:/students/list";

    }

    @GetMapping("/students/editform")
    public String updateStudentForm(@RequestParam int id, Model model) {
        Student studentById = studentService.getStudentById(id);
        model.addAttribute("student", studentById);
        return "edit_student";

    }

    @PostMapping("/students/update")
    public String update(@ModelAttribute Student student) {
        studentService.update(student);
        return "redirect:/students/list";
    }
    @GetMapping("/students/delete")
    public String delete(@RequestParam int id){
        studentService.deleteById(id);
        return "redirect:/students/list";
    }

    @PostMapping("/home")
    public String home(){
        return "home";
    }

}
