package com.iskalay.controllers;

import com.iskalay.models.Books;
import com.iskalay.models.enums.Role;
import com.iskalay.models.Users;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserListCont extends Main {

    @GetMapping("/userList")
    public String userList(Model model) {
        List<Users> users = repoUsers.findAll();

        model.addAttribute("users", users);
        model.addAttribute("role", checkUserRole());
        return "userList";
    }

    @PostMapping("/userList/{id}/edit")
    public String userUpdate(
            @PathVariable(value = "id") Long id, @RequestParam String username,
            @RequestParam String password, @RequestParam Role role
    ) {
        Users temp = repoUsers.findById(id).orElseThrow();
        temp.setUsername(username);
        temp.setPassword(password);
        temp.setRole(role);
        repoUsers.save(temp);
        return "redirect:/userList";
    }

    @PostMapping("/userList/{id}/delete")
    public String userDelete(@PathVariable(value = "id") Long id) {
        repoUsers.deleteById(id);
        return "redirect:/userList";
    }
}
