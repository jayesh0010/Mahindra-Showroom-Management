package com.mahindrashowrooms.controller;

import com.mahindrashowrooms.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/submit-register")
    public String submitRegister(@RequestParam String name, @RequestParam String email,
                                 @RequestParam String password, @RequestParam String confirmPassword,
                                 Model model) {
        if (!password.equals(confirmPassword)) {
            model.addAttribute("message", "Passwords do not match");
            return "register";
        }
        userService.saveUser(name, email, password);
        model.addAttribute("message", "Registration successful");
        return "redirect:/login"; 
    }

    @PostMapping("/submit-login")
    public String submitLogin(@RequestParam String email, @RequestParam String password, Model model) {
        if (userService.validateUser(email, password)) {
            model.addAttribute("message", "Login successful");
            return "main"; 
        } else {
            model.addAttribute("message", "Invalid credentials");
            return "login";
        }
    }
    
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        
        HttpSession session = request.getSession(false); 
        if (session != null) {
            session.invalidate(); 
        }
        return "redirect:/";
    }
}
