package com.controllers;

import org.springframework.beans.factory.annotation.Autowired; // Added
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.main.model.User;
import com.DAO.UserDao; // Added - Ensure this matches your package

@Controller
public class Home {

    // --- CRITICAL ADDITION: This fixes the "userDao cannot be resolved" error ---
    @Autowired
    private UserDao userDao; 
    // -------------------------------------------------------------------------

    @GetMapping("/")
    public String toHome() {
        return "index";
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }

    @GetMapping("/aboutus")
    public String showAboutUs() {
        return "aboutus";
    }

    @PostMapping("/registerProcess")
    public String dataBindReg(User user, RedirectAttributes ra) {
        // 1. Log for debugging
        System.out.println("Registering user: " + user.getName());
        
        // 2. Save to database using your UserDao
        // This will now work because userDao is declared and @Autowired above
        userDao.saveUser(user);
        
        // 3. Use FlashAttribute so the message survives the redirect
        ra.addFlashAttribute("msgReg", "Registration successful, " + user.getName() + "! Please login here.");
        
        // 4. Redirect to the login mapping
        return "redirect:/login"; 
    }

    @PostMapping("/loginProcess")
    public String proceedLog(User user, RedirectAttributes ra) {
        // Use FlashAttribute for everything during a redirect
        ra.addFlashAttribute("msgLog", "Login success");
        ra.addFlashAttribute("Name", user.getName());
        
        return "redirect:/aboutus";
    }
}
