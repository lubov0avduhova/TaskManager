package main.controllers;

import main.model.Aim;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AimController {
    private List<Aim> aimList;

    public AimController(List<Aim> aimList) {
        this.aimList = aimList;
    }

    public List<Aim> getAimList() {
        return aimList;
    }
}
