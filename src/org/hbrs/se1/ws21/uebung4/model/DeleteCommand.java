package org.hbrs.se1.ws21.uebung4.model;

import java.text.ParseException;
import java.util.List;

public class DeleteCommand implements Command {

    private final String[] parameter;

    public DeleteCommand(String[] parameter) {
        this.parameter = parameter;
    }

    @Override
    public void execute() throws ContainerException, ParseException {
        // WICHTIG!: Hier weisen wir in unsere Variable sprint den letzt erstellten Sprint!!
        Sprint sprint = Container.getInstance().getSprintList().get(Container.getInstance().getSprintList().size()-1);
        if(this.parameter[1].equals("start")){
            sprint.setStartdate("");
            System.out.println("Ihr Startdatum wurde geloescht!");
        } else if(this.parameter[1].equals("end")){
            sprint.setEnddate("");
            System.out.println("Ihr Enddatum wurde geloescht!");
        }
    }

    @Override
    public void undo() {

    }
}
