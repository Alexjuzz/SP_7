package Spring.Hm7.repositories;

import Spring.Hm7.task.Status;
import Spring.Hm7.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByStatus(Status status);
     Task getById(Long id);
}
