package main.controllers.Sprint;

import main.model.Sprint;


public class AddSprint extends SprintWindowController {


    public void addSprint() {
        Sprint temp = new Sprint();
        temp.setTitle(title.getText());
        temp.setStartDate(startDate.getValue());
        temp.setEndDate(endDate.getValue());

        sprintListView.getItems().add(temp);
        sprintRepo.save(temp);
    }
}
