package main.repo;

import main.model.Task;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Repository
@Qualifier("taskRepo")
public interface TaskRepo extends JpaRepository<Task, Integer> {

//    @Modifying
//    @Transactional
//    @Query("UPDATE Task SET title = :title, description =:description, " +
//            "startDate=:start_date, endDate=:end_date where id = :id")
//    void updateTask(int id, String title, String description,
//                    @Param("start_date") LocalDate startDate, @Param("end_date")LocalDate endDate);
//taskRepo.updateTask(tempTask.getId(), tempTask.getTitle(), tempTask.getDescription(), tempTask.getStartDate(), tempTask.getEndDate());

}

//String description, LocalDate startDate, LocalDate endDate
//+
//            "t.description = :description, t.startDate = :start_date, t.endDate= :end_date"
