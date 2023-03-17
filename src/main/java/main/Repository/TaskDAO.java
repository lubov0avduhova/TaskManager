package main.Repository;

import main.ServiceEntity.Sprints.Tasks.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskDAO extends JpaRepository<Task, Integer> {
    public List<Task> getTasks();
}
