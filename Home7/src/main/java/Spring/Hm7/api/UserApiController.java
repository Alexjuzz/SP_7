package Spring.Hm7.api;

import Spring.Hm7.user.User;
import Spring.Hm7.user.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(value = "/api/user")
public class UserApiController {

    private final UserApiService service;

    @Autowired
    public UserApiController(UserApiService service){
        this.service = service;
    }

    @GetMapping(value = "/{id}")
    public User getUserById(@PathVariable Long id){
        return service.getUserById(id);
    }

    @PostMapping(value = "/")
    public UserDto createUser(@RequestBody UserDto user){
        return service.createUser(user);
    }
    @GetMapping(value = "/all")
    public List<User> getAllUsers(){
        return service.getAllUsers();
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable Long id){
        service.deleteUserById(id);
    }
    @PutMapping(value = "/{id}")
    public User updateUser(@PathVariable Long id,@RequestBody User user){
        return service.updateUser(id,user);
    }


}
