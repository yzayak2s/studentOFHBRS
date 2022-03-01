package org.hbrs.se1.ws21.uebung4.model;

import org.hbrs.se1.ws21.uebung4.control.EingabeDialog;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;

public class EnterCommand implements Command {
    private final String[] parameter;

    public EnterCommand(String[] parameter){
        this.parameter = parameter;
    }

    @Override
    public void execute() {
        switch (this.parameter[1]){
            // Mitarbeiter-Erstellung
            case "none" -> {
                try {
                    Container.getInstance().addEmployee(EingabeDialog.eingabeDialog());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            // TODO: 24.02.22 Mit dem Befehl "Enter new" gelangt man in diesem Case; Problem: mit "enter new expertise" gelangt man trotzdem noch in dem Case
            case "new" -> {
                Sprint temp_sprint = new Sprint();
                if (!parameter[3].equals("none") && parameter[2].equals("sprint")) {
                    String expertise_eingabe = parameter[3].replaceAll("^\"|\"$", "");
                    temp_sprint.setName(expertise_eingabe);

                    try {
                        Container.getInstance().addSprint(temp_sprint);
                    } catch (ContainerException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Geben Sie mit weiteren Befehlen die Expertise und das Datum ein.");
                }
                else {
                    System.out.println("Ungültiger Befehl. Beispielbefehl: enter new sprint \"SprintName\"");
                }
            }
            case "expertise" -> {// TODO: 24.02.22 Size-Erhöhung; dump Methode für Sprint implementieren; Siehe auskommentierten Code
                List<String> moegl_expertisen = Arrays.asList("Java1","Java2","Java3","Java4","Java5","Java6","Java7",
                        "Java8","Java9","Java10","Java11","Java12","Java13","Java14","Java15","Java16","Java17","HTML1","HTML2",
                        "HTML3","HTML4","HTML5", "Assembler"); // moegliche Expertisen
                String expertise_eingabe = parameter[2].replaceAll("^\"|\"$", "");
                if (moegl_expertisen.contains(expertise_eingabe)){
                    try {
                        Sprint temp_sprint = Container.getInstance().getSprintList().get(Container.getInstance().getSprintList().size()-1);
                        System.out.println(parameter[2]);
                        System.out.println(!parameter[2].equals("none"));
                        if (!parameter[2].equals("none")) {
                            List<Object> currentExpertises = temp_sprint.getExpertise();
                            currentExpertises.add(currentExpertises.size() +1, parameter[2]);
                            temp_sprint.setExpertise(currentExpertises);
                        }
                        else {
                            System.out.println("Geben sie bitte einen Namen der Expertise ein.");
                        }
                    } catch (IndexOutOfBoundsException e){
                        System.out.println("Kein Sprint vorhanden, dem die Expertise hinzugefügt werden kann.");
                    };
                } else {
                    System.out.println("Dies ist keine gültige Expertise. Geben Sie bitte eine neue ein!");
                }
            }
            default -> System.out.println("Unbekannter Befehl! Mögliche Befehle: enter, enter new sprint, enter expertise, enter start, enter end");
        }
    }

    @Override
    public void undo() {

    }
}
