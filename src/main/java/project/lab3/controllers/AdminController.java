package project.lab3.controllers;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

    @GetMapping("/admin/add")
    public String addProductPage() {
        return "admin-add";
    }

    @PostMapping("/admin/add")
    public String addProductSubmit(@RequestParam String name,
                                   @RequestParam double price,
                                   Model model) {
        // Логіка збереження продукту
        return "redirect:/admin/add?success";
    }
}
