package Spring.Hm7.web;

import Spring.Hm7.repositories.UserRepository;
import Spring.Hm7.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserWebService {

    @Autowired
   private UserRepository userRepository;

   public UserWebService(UserRepository userRepository){
       this.userRepository = userRepository;
   }
    public User createUser(String name, String email) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        return userRepository.save(user);
   }

    public List<User> getAllUsers() {
        return  userRepository.findAll();
    }

    public User getUserById(Long id) {
    return userRepository.getById(id);
   }
}
