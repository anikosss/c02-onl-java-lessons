package by.teachmeskills.controller.user;

import by.teachmeskills.model.User;
import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public String getUsersPage() {
        return "user";
    }

    @ModelAttribute("user")
    public User getUser() {
        return new User();
    }

    @GetMapping("/{id}")
    public String getUsersPage(Model model, @PathVariable("id") Optional<String> userId) {
        User user = new User();
        if (userId.isPresent()) {
            System.out.println(userId.get());
        }
        user.setName("firstName");
        model.addAttribute("user", new User());
        return "user";
    }

    @PostMapping("/add")
    public ModelAndView addUser(@ModelAttribute User user, BindingResult result) {
        if (user == null) {
            throw new IllegalArgumentException("No user created");
        }
        return new ModelAndView("user", "createdUser", user);
    }

}
