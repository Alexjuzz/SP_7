package Spring.home.hm2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControllerByUserName {
    private final HelloService helloService;
    @Autowired
    public HelloControllerByUserName(HelloService helloService){
        this.helloService = helloService;

    }
    @GetMapping("/")
    public String startHTML(){
        return "Введите в строке localhost/user/СвоеИмя";
    }
    @GetMapping("/user/{name}")
    public String helloByName(@PathVariable("name") String name) {
        return helloService.getHello(name);
    }
}
