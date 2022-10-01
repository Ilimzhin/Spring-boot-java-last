package com.example.controller;

import com.example.domain.Message;
import com.example.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

//@RestController("/b")
//@AllArgsConstructor // авто конструкторы для приват переменных и экуалс и тд
@Controller("/main")
public class GreetingController {

    @Autowired
    private MessageRepo messageRepo;

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
        Iterable<Message> messages = messageRepo.findAll();

        model.put("messages", messages);
        return "main";
    }
    @GetMapping ("/mains")
    public String mains(Map<String, Object> model) {
        Iterable<Message> messages = messageRepo.findAll();

        model.put("messages", messages);
        return "mains";
    }

    @PostMapping
    public String add(@RequestParam String text, @RequestParam String tag, Map<String, Object> model) {
        // RequestParam Берет из формы в main.mustache <form method="post">
        Message message = new Message(text, tag);

        messageRepo.save(message);

        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", messages);

        return "main";
    }

    @PostMapping("/mains")
    public String add2(@RequestParam String text, @RequestParam String tag, Map<String, Object> model) {
        // RequestParam Берет из формы в main.mustache <form method="post">
        Message message = new Message(text, tag);

        messageRepo.save(message);

        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", messages);

        return "mains";
    }

//    @PostMapping
//    public String add(@RequestParam String text, Map<String, Object> model) {
//
//        return "main";
//    }

    }

// @GetMapping("/{accountId}") // находит по id
