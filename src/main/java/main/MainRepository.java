package main;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainRepository {
    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("my-persistence-unit");
    }
}
