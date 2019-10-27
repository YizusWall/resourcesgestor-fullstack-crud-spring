package com.yizuslabs.jobsfaith.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/costadmin"})
public class SimpleController {

    @Value("${spring.application.name}")
    String appName;
    @Value("${spring.application.hostname}")
    String hostName;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("appName", appName);
        return "home";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("appName", appName);
        return "login";
    }

    @GetMapping("/menu")
    public String menu(Model model) {
        model.addAttribute("hostName", hostName);
        return "menu";
    }

    @GetMapping("/mantunidadnegocio")
    public String mantunidadnegocio(Model model) {
        model.addAttribute("appName", appName);
        return "sidebar/mantunidadnegocio";
    }


}
