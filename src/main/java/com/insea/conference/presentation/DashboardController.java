package com.insea.conference.presentation;

import com.insea.conference.domain.User;
import com.insea.conference.service.ConferenceService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @Autowired
    private ConferenceService conferenceService;

    @GetMapping("/auteur/dashboard")
    public String auteurDashboard(HttpSession session) {
        User user = (User) session.getAttribute("user");

        if (user == null || !user.getRole().equals("AUTEUR")) {
            return "redirect:/login";
        }

        return "conference/auteur_dashboard";
    }

    @GetMapping("/admin/dashboard")
    public String adminDashboard(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");

        if (user == null || !user.getRole().equals("ADMIN")) {
            return "redirect:/login";
        }

        model.addAttribute("conferences", conferenceService.findAll());
        return "conference/admin_dashboard";
    }
}