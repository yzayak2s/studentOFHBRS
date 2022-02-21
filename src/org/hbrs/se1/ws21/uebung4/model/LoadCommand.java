package org.hbrs.se1.ws21.uebung4.model;

import java.util.List;
import java.util.Scanner;

public class LoadCommand implements Command {
    private final String parameter;

    public LoadCommand(String parameter) {
        this.parameter= parameter;
    }

    @Override
    public void execute() {
        switch (this.parameter) {
            case "force" -> {
                Container.getInstance().setListe(null);
                Container.getInstance().load();
            }
            case "merge" -> {
                List<Employee> tmp = Container.getInstance().getCurrentList();    // zwischenzeitliches speichern der aktuellen Liste im Container
                Container.getInstance().load();                                    // ersetzen der liste durch die liste im File
                for (Employee employee : tmp) {
                    int counter = 0;
                    int tempID = employee.getPid();
                    for (Employee e : Container.getInstance().getCurrentList()) {
                        if (e.getPid() != tempID) {
                            counter++;
                        }
                    }
                    if (counter == Container.getInstance().getCurrentList().size()) {
                        Container.getInstance().getCurrentList().add(employee);   // hinzufügen der temporär gespeicherten Mitarbeiter sofern noch nicht im Speicher
                    } else {
                        System.out.println("ID: " + tempID + " bereits vergeben! Wollen sie die ID überschreiben?");
                        Scanner sc = new Scanner(System.in);
                        if (sc.next().equalsIgnoreCase("JA")) {
                            for (Employee e : Container.getInstance().getCurrentList()) {
                                if (e.getPid() == tempID) {
                                    Container.getInstance().getCurrentList().remove(e);        // Element mit derselben Nummer löschen
                                    Container.getInstance().getCurrentList().add(employee);    // Das Element aus dem File hinzufügen
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            case "none" -> System.out.println("Geben Sie bitte die Variante des Ladens als 2. Parameter an (load force oder load merge).");
            default -> System.out.println("Unbekannter Befehl! Mögliche Befehle: load force, load merge");
        }
    }

    @Override
    public void undo() {

    }
}
