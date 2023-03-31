//package main.repo;
//
//import main.model.Task;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.data.domain.Example;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//@Qualifier("taskRepo")
//public interface TaskRepo extends MainRepo, JpaRepository<Task, Integer> {
//
//
//    @Modifying
//    @Transactional
//    @Query(value = "SELECT * from prog where prog_type = 'TASK' and sprint_id= :id ORDER BY end_date", nativeQuery = true)
//    List<Task> findAllById(Integer id);
//
//}