package org.hbrs.se1.ws21.uebung4.prototype;

import java.util.List;

public class DumpCommand implements Command {
    @Override
    public void execute() {
        // Hier: der Container ist der Receiver
        List<Employee> liste = Container.getInstance().getCurrentList();
        // --> EmployeeView aufrufen...
    }

    @Override
    public void undo() {

    }
}
