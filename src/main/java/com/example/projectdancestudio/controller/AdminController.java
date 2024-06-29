package com.example.projectdancestudio.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class AdminController {


    @GetMapping
    public String adminPage(){
        return "login";
    }


    @PostMapping
    public String loginSubmit(HttpServletRequest request) {
        // Обработка логики входа пользователя

        // Получаем параметр "continue" из запроса
        String continueUrl = request.getParameter("continue");

        // Проверяем, если параметр "continue" задан и не пустой
        if (continueUrl != null && !continueUrl.isEmpty()) {
            return "redirect:" + continueUrl; // Перенаправляем на указанную страницу
        } else {
            return "redirect:/"; // Перенаправляем на главную страницу
        }
    }
}
