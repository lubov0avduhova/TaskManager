package main.Repository;

import main.ServiceEntity.Sprints.Tasks.Task;

import java.util.List;


public interface TaskDAO {
    public List<Task> getTasks();
}
