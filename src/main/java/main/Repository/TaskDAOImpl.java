//package main.Repository;
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.PersistenceContext;
//import main.ServiceEntity.Sprints.Tasks.Task;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//@Repository
//public class TaskDAOImpl implements TaskDAO{
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Transactional
//    @Override
//    public List<Task> getTasks() {
//        System.out.println("я в TASKDAOImpl");
//        System.out.println(entityManager.isOpen());
////        TypedQuery<Task> theQuery =
////                entityManager.createQuery("from Task", Task.class);
////        List<Task> tasks = theQuery.getResultList();
////        return tasks;
//        return null;
//    }
//}