package org.hbrs.se1.ws21.uebung4.model;

import org.hbrs.se1.ws21.uebung4.control.EingabeDialog;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;

public class EnterCommand implements Command {
    private final String[] parameter;

    // Konstruktor mit Parameter vom Typ String-Array
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
            case "new" -> {
                // TODO: 20.03.22 Fehler bei der Anwendungslogik, wenn Sprint mit bereits vorhandenen Sprint-Namen erstellt wird.
                Sprint temp_sprint = new Sprint();
                if (!parameter[3].equals("none") && parameter[2].equals("sprint")) {
                    String expertise_eingabe = parameter[3].replaceAll("^\"|\"$", "");
                    temp_sprint.setName(expertise_eingabe);

                    try {
                        Container.getInstance().addSprint(temp_sprint);
                        System.out.println("Geben Sie mit weiteren Befehlen die Expertise und das Datum ein.");
                    } catch (ContainerException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    System.out.println("Ungültiger Befehl. Beispielbefehl: enter new sprint \"SprintName\"");
                }
            }
            case "expertise" -> {
                // TODO: 31.03.22 Eventuell Array-List refaktorisieren, damit die Expertisen der Employees auch ueber die Liste geprueft werden koennen
                //  Hier nur fuer die Sprints verwendet
                List<String> moegl_expertisen = Arrays.asList("Java1","Java2","Java3","Java4","Java5","Java6","Java7",
                        "Java8","Java9","Java10","Java11","Java12","Java13","Java14","Java15","Java16","Java17",
                        "HTML1","HTML2", "HTML3","HTML4","HTML5", "Assembler"); // moegliche Expertisen
                String expertise_eingabe = parameter[2].replaceAll("^\"|\"$", "");
                if (moegl_expertisen.contains(expertise_eingabe)){
                    try {
                        Sprint temp_sprint = Container.getInstance().getSprintList().get(Container.getInstance().getSprintList().size()-1);
                        if (!parameter[2].equals("none")) {
                            List<Object> currentExpertises = temp_sprint.getExpertise();
                            // TODO: 19.03.22 Expertisenliste ist in der Lage Duplikate aufzunehmen 
                        //    if(currentExpertises.contains(expertise_eingabe)){
                        //        System.out.println(currentExpertises);
                        //    }else{
                            currentExpertises.add(currentExpertises.size(), expertise_eingabe);
                            temp_sprint.setExpertise(currentExpertises);
                        //    }
                            System.out.println(currentExpertises);
                        }
                        else {
                            System.out.println("Geben sie bitte einen Namen der Expertise ein.");
                        }
                    } catch (IndexOutOfBoundsException e){
                        System.out.println("Kein Sprint vorhanden, dem die Expertise hinzugefügt werden kann.");
                    }
                } else {
                    System.out.println("Dies ist keine gültige Expertise. Geben Sie bitte eine neue ein!");
                }
            }
            //TODO: 05.03.22  Prüfung auf gültiges Datum, bislang "XYZ" gültig
            case "start" -> {
                try {
                    Sprint temp_sprint = Container.getInstance().getSprintList().get(Container.getInstance().getSprintList().size()-1);
                    if (!parameter[2].equals("none")) {
                        temp_sprint.setStartdate(parameter[2]);
                    }
                    else {
                        System.out.println("Geben sie bitte ein gültiges Datum ein.");
                    }
                } catch (IndexOutOfBoundsException e){
                    System.out.println("Kein Sprint vorhanden, dem die Expertise hinzugefügt werden kann.");
                }
            }
            case "end" -> {
                try {
                    Sprint temp_sprint = Container.getInstance().getSprintList().get(Container.getInstance().getSprintList().size()-1);
                    if (!parameter[2].equals("none")) {
                        temp_sprint.setEnddate(parameter[2]);
                    }
                    else {
                        System.out.println("Geben sie bitte ein gültiges Datum ein.");
                    }
                } catch (IndexOutOfBoundsException e){
                    System.out.println("Kein Sprint vorhanden, dem die Expertise hinzugefügt werden kann.");
                }
            }

            default -> System.out.println("Unbekannter Befehl! Mögliche Befehle: enter, enter new sprint, enter expertise, enter start, enter end");
        }
    }

    @Override
    public void undo() {

    }
}