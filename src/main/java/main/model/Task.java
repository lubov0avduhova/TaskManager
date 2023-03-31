package main.model;

import jakarta.persistence.*;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("Task")
@DynamicUpdate
public class Task extends Prog{
    private Sprint sprint;

    @ManyToOne(fetch = FetchType.LAZY)
    public Sprint getSprint() {
        return sprint;
    }

    public void setSprint(Sprint sprint) {
        this.sprint = sprint;
    }

    public Task() {
        super();
    }

    @Override
    public String toString() {
        return "Задача: " + super.getTitle() + "\n\n"+"Дедлайн "+ super.getEndDate();
    }
}
