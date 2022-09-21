package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

//@RestController("/b")
//@AllArgsConstructor // авто конструкторы для приват переменных и экуалс и тд
@Controller("/")
public class GreetingController {

    @GetMapping("/greetings")
    public String greetings(
            @RequestParam(name = "name", required = false, defaultValue = "World") String name,
            Model model) {
        model.addAttribute("name", name);
        return "greetings";
    }// через thymeleaf

    @GetMapping("/greeting")
    public String greeting(
            @RequestParam(name = "name", required = false, defaultValue = "World") String name,
            Map<String, Object> model) {
        model.put("name", name);
        return "greeting";
    }

    @GetMapping
    public String main(Map<String, Object> model) {
        model.put("some", "let's code");
        return "main";
    }



}

// @GetMapping("/{accountId}") // находит по id
