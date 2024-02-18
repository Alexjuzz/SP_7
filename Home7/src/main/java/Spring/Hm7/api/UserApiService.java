package Spring.Hm7.api;
import Spring.Hm7.exceptions.EntityNotFoundException;
import Spring.Hm7.repositories.TaskRepository;
import Spring.Hm7.repositories.UserRepository;
import Spring.Hm7.user.User;
import Spring.Hm7.user.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserApiService {

    private final UserRepository userRepository;
    private final TaskRepository taskRepository;

    @Autowired
    public UserApiService(UserRepository repository, TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = repository;
    }

    public UserDto createUser(UserDto userDto) {
        User user = convertEntity(userDto);
        return convertDto(user);
    }

    private User convertEntity( UserDto userDto) {
        User user = new User();
        if (userDto.getTaskId() != null) {
            user.setTask(taskRepository.getById(userDto.getTaskId()));
        }
        user.setEmail(userDto.getEmail());
        user.setName(userDto.getName());
        user.setId(userDto.getId());
        return user;
    }

    private UserDto convertDto( User user) {
        UserDto userDto = new UserDto();
        if (user.getTask() != null) {
            userDto.setTaskId(user.getTask().getId());
        }
        userDto.setEmail(user.getEmail());
        userDto.setName(user.getName());
        userDto.setId(user.getId());
        return userDto;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found: " + id));
    }

    public User updateUser(Long id,  User user) {
        User currentUser = getUserById(id);
        currentUser.setEmail(user.getEmail());
        currentUser.setName(user.getName());
        currentUser.setTask(user.getTask());
        userRepository.save(currentUser);
        return currentUser;
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }


}
