package Spring.Hm7.web;

import Spring.Hm7.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserWebController {
    @Autowired
    private final UserWebService service;

    public UserWebController (UserWebService service){
        this.service = service;
    }

    @GetMapping("/createUser")
    public String createUserForm(Model model) {
        model.addAttribute("user", new User());
        return "GetCreateUser";
    }
    @PostMapping("/createUser")
    public String postNewTask(@ModelAttribute User user, Model model) {
       User currUser = service.createUser(user.getName(), user.getEmail());
        model.addAttribute("user", currUser);
        return "PostCreateUser";
    }
    @GetMapping("/getAllUsers")
    public String getAllUsers(Model model){
        model.addAttribute("users",service.getAllUsers());
        return "GetAllUsers";
    }
    @PostMapping("/getUserById")
    public String getUserById(Model model,@RequestParam Long id){
        model.addAttribute("user",service.getUserById(id));
        return "GetUserById";
    }

}
