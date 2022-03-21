package org.hbrs.se1.ws21.uebung4.model;

import javax.swing.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DumpCommand implements Command {
    @Override
    public void execute() {
        // Hier: der Container ist der Receiver
        List<Employee> listEmployee = Container.getInstance().getCurrentListEmpl();
        Container.getInstance().startAusgabeEmpl(listEmployee, "dump");
        // --> EmployeeView aufrufen...
        System.out.println("\n");

        // Hier erzeugen wir eine generische List-Variable vom Typ Sprint
        List<Sprint> listSprint = Container.getInstance().getCurrentListSpr();
        List<Sprint> sortedList = listSprint.stream()
        //listSprint = listSprint.stream().collect(Collectors.toList()); // sortieren nach Alphabet
                  .sorted(Comparator.comparing(Sprint::getName))
          		//.map(sprint -> sprint.getName())
                  .collect(Collectors.toList()); // sortieren nach Alphabet
        Container.getInstance().startAusgabeSpr(sortedList);
    }

    @Override
    public void undo() {

    }
}
