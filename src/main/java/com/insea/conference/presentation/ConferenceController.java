package com.insea.conference.presentation;

import com.insea.conference.domain.Conference;
import com.insea.conference.domain.User;
import com.insea.conference.service.ConferenceService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/conference")
public class ConferenceController {

    @Autowired
    private ConferenceService conferenceService;

    @GetMapping("/form")
    public String form() {
        return "conference/form";
    }

    @PostMapping("/submit")
    public String submit(@ModelAttribute Conference conference,
                         HttpSession session) {

        User user = (User) session.getAttribute("user");

        if (user == null) {
            return "redirect:/login";
        }

        conference.setAuteur(user);
        conferenceService.save(conference);

        return "redirect:/auteur/dashboard";
    }
}