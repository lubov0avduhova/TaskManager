package main.repo;

import main.model.Aim;
import main.model.Prog;
import main.model.Sprint;
import main.model.Task;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Repository
@Qualifier("mainRepo")
public interface MainRepo extends JpaRepository<Prog, Integer>, CrudRepository<Prog, Integer> {



    @Modifying
    @Transactional
    @Query(value = "SELECT * from prog where prog_type = 'Sprint' ORDER BY end_date", nativeQuery = true)
    List<Sprint> findAllSprints();

    @Modifying
    @Transactional
    @Query(value = "SELECT * from prog where prog_type = 'Task' and sprint_id= :id ORDER BY end_date", nativeQuery = true)
    List<Task> findAllTasks(Integer id);



    @Modifying
    @Transactional
    @Query(value = "UPDATE prog SET prog_type = 'Task',  description=:desc , end_date =:end_date, " +
            "start_date=:start_date, title=:title, sprint_id =:idParent " +
            "WHERE prog.id=:id",
            nativeQuery = true)
    void saveTask(@Param("desc") String desc, @Param("end_date")LocalDate end_date,
                  @Param("start_date")LocalDate start_date, @Param("title")String title,
                  @Param("idParent") Integer idParent,@Param("id") Integer id);





}
