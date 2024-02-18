package Spring.Hm7.api;

import Spring.Hm7.exceptions.EntityNotFoundException;
import Spring.Hm7.repositories.TaskRepository;
import Spring.Hm7.task.Status;
import Spring.Hm7.task.Task;
import Spring.Hm7.task.TaskDto;
import Spring.Hm7.user.User;
import org.apache.catalina.loader.ResourceEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskApiService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserApiService userApiService;

    public TaskDto createTask(TaskDto taskDto) {

        Task task = convertToEntity(taskDto);
        task = taskRepository.save(task);
        return convertToDto(task);
    }

    //region convert DTO and Entity
    private Task convertToEntity( TaskDto taskDto) {
        Task task = new Task();
        task.setName(taskDto.getName());
        task.setDate(LocalDate.now());
        task.setStatus(taskDto.getStatus());
        task.setDescription(taskDto.getDescription());
        if (taskDto.getUserList() != null) {
            for (Long userId : taskDto.getUserList()) {
                User user = userApiService.getUserById(userId);
                if (user != null) {
                    task.addUser(user);
                } else {
                    throw new EntityNotFoundException("User not found");
                }
            }
        }
        return task;
    }


    private  TaskDto convertToDto( Task task) {
        TaskDto taskDto = new TaskDto();
        taskDto.setId(task.getId());
        taskDto.setName(task.getName());
        taskDto.setDescription(task.getDescription());
        taskDto.setStatus(task.getStatus());
        if (task.getUserList() != null && !task.getUserList().isEmpty()) {
            for (User u : task.getUserList()) {
                taskDto.addIdToList(u.getId());
            }
        }
        return taskDto;
    }
//endregion

    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }

    public TaskDto getTaskById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Task not found: " + id));
        return convertToDto(task);
    }


    public TaskDto updateTask(Long id, TaskDto taskDto) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Task not found: " + id));
        task.setName(taskDto.getName());
        task.setDescription(taskDto.getDescription());
        task.setDate(LocalDate.now());
        task.setStatus(taskDto.getStatus());
        taskRepository.save(task);
        return convertToDto(task);
    }

    public TaskDto addUser(Long task_id, Long user_id) {
        Task task = taskRepository.getById(task_id);
        task.addUser(userApiService.getUserById(user_id));
        taskRepository.save(task);
        return convertToDto(task);

    }


    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public List<Task> getTaskByStatus(Status status) {
        return getAllTask().stream().filter(task -> task.getStatus() == status).collect(Collectors.toList());
    }

    public List<Task> getTaskByStats(Status status) {
        return taskRepository.findByStatus(status);
    }
}
