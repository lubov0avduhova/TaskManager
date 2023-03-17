package main.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TaskDAOImpl{

    @PersistenceContext
    private EntityManager factory;

    @Autowired
    TaskDAO taskDAO;


    @Transactional
    public void getTasks() {
        System.out.println("я в TaskDao!");
//        TypedQuery<Task> theQuery =
//                factory.createQuery("from Task", Task.class);
//        List<Task> tasks = theQuery.getResultList();
//        return tasks;
    }
}
