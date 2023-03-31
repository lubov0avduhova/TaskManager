package main.model;

import jakarta.persistence.*;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("Sprint")
@DynamicUpdate
public class Sprint extends Prog{
    private Aim aim;
    @ManyToOne(fetch = FetchType.LAZY)
    public Aim getAim() {
        return aim;
    }

    public void setAim(Aim aim) {
        this.aim = aim;
    }

    public Sprint() {
    }


}
