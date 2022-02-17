package org.hbrs.se1.ws21.uebung4.model;

import java.util.List;

public class DumpCommand implements Command {
    @Override
    public void execute() {
        // Hier: der Container ist der Receiver
        List<Employee> liste = Container.getInstance().getCurrentList();
        Container.getInstance().startAusgabe(liste, "dump");
        // --> EmployeeView aufrufen...
    }

    @Override
    public void undo() {

    }
}
