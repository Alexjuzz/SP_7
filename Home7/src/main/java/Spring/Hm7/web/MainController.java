package Spring.Hm7.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping()
    public String getIndex(){
        return "Index";
    }

    @GetMapping("/login")
    public String getLogin(){
        return "Login";
    }
}
