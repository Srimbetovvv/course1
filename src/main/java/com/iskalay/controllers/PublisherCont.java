package com.iskalay.controllers;

import com.iskalay.models.Books;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PublisherCont extends Main {

    @GetMapping("/publisher")
    String publisher(Model model){
        model.addAttribute("role", checkUserRole());
        return "publisher";
    }

    @GetMapping("/fourquarters")
    String fourquarters(Model model){
        List<Books> books = repoBooks.findAllByPub("fourquarters");
        model.addAttribute("books", books);
        model.addAttribute("role", checkUserRole());
        return "fourquarters";
    }

    @GetMapping("/popurri")
    String popurri(Model model){
        List<Books> books = repoBooks.findAllByPub("popurri");
        model.addAttribute("books", books);
        model.addAttribute("role", checkUserRole());
        return "popurri";
    }
}
