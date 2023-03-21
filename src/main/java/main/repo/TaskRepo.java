package main.repo;

import main.model.Task;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("clientRepo")
public interface TaskRepo extends JpaRepository<Task, Integer> {


}
