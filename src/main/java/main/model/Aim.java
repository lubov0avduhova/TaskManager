package main.model;

import jakarta.persistence.*;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("Aim")
@DynamicUpdate
public class Aim extends Prog{
    private Prog prog;

    @ManyToOne(fetch = FetchType.LAZY)
    public Prog getProg() {
        return prog;
    }

    public void setProg(Prog prog) {
        this.prog = prog;
    }

    public Aim() {

    }



}
