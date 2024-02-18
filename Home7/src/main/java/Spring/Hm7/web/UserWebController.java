package Spring.Hm7.web;

import Spring.Hm7.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserWebController {
    @Autowired
    private final UserWebService service;

    public UserWebController (UserWebService service){
        this.service = service;
    }

    @GetMapping("/createUser")
    public String createTaskForm(Model model) {
        model.addAttribute("user", new User());
        return "GetCreateUser";
    }
    @PostMapping("/createUser")
    public String postNewTask(@ModelAttribute User user, Model model) {
       User currUser = service.createUser(user.getName(), user.getEmail());
        model.addAttribute("user", currUser);
        return "PostCreateUser";
    }

}
