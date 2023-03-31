package main.repo;

import main.model.Sprint;
import main.model.Task;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@Repository
//@Qualifier("sprintRepo")
//public interface SprintRepo extends MainRepo, JpaRepository<Sprint, Integer> {


//
//    @Modifying
//    @Transactional
//    @Query(value = "DELETE from sprint where = :id", nativeQuery = true)
//    @Override
//    void deleteById(Integer integer);
//}
