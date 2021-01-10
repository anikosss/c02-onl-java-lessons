package by.teachmeskills.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/main")
public class MainPageController {

    @GetMapping
    public ModelAndView mainPage(Model model) {
        model.addAttribute("info", "Info Message");
        return new ModelAndView("main-page", "info", "new info");
    }

    @GetMapping("/info")
    public ModelAndView mainPageWithInfo() {
        return new ModelAndView("main-page", "info", "Info Message");
    }

    @GetMapping("/error")
    public ModelAndView mainPageWithError() {
        throw new IllegalArgumentException("Error message");
    }



}
