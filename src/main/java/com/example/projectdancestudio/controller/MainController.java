package com.example.projectdancestudio.controller;

import com.example.projectdancestudio.model.Teacher;
import com.example.projectdancestudio.service.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class MainController {

    private final TeacherService teacherService ;


    @GetMapping()
    public String homePage(Model model){
        model.addAttribute("teachers",teacherService.findAllTeachers());
        return "homePage";
    }

    @GetMapping("/teachers/new")
    public String showAddTeacherForm(Model model) {
        model.addAttribute("teacher", new Teacher());
        return "addTeacher";
    }

    @PostMapping("/teachers")
    public String addTeacher(@ModelAttribute Teacher teacher) {
        teacherService.save(teacher);
        return "redirect:/teachers";
    }

    @GetMapping("/teachers/edit/{id}")
    public String showUpdateTeacherForm(@PathVariable  Long id, Model model) {
        Teacher teacher = teacherService.findById(id);
        model.addAttribute("teacher", teacher);
        return "updateTeacher";
    }

    @PostMapping("/teachers/update")
    public String updateTeacher(@ModelAttribute Teacher teacher) {
        teacherService.save(teacher);
        return "redirect:/teachers";
    }

    @GetMapping("/teachers")
    public String listTeachers(Model model) {
        model.addAttribute("teachers", teacherService.findAllTeachers());
        return "listTeachers";
    }

    @PostMapping("/teachers/delete/{id}")
    public String deleteTeacher(@PathVariable Long id) {
        teacherService.deleteById(id);
        return "redirect:/teachers";
    }

}


//С Max нет ничего невозможного. Все о женственности и грации. Основное направление - VOGUE FEMME
//Мастер баланса и контроля над телом Vadim. Именно он погрузит тебя в удивительный мир RUN WAY
//Богиня RUN WAY. Научит тебя самым стильным проходкам и избавит от страха в первых VOGUE балов