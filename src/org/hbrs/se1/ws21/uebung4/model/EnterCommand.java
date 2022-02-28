package org.hbrs.se1.ws21.uebung4.model;

import org.hbrs.se1.ws21.uebung4.control.EingabeDialog;

public class EnterCommand implements Command {
    private final String parameter;

    public EnterCommand(String parameter) {
        this.parameter = parameter;
    }

    @Override
    public void execute() {
        switch (this.parameter){
            case "employee" -> {
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
                Sprint temp_sprint = Container.getInstance().getSprintList().get(Container.getInstance().getSprintList().size()-1);
                if (!parameter[2].equals("none")) {
                    List<Object> currentExpertises = temp_sprint.getExpertise();
                    currentExpertises.add(currentExpertises.size() +1, parameter[2]);
                    temp_sprint.setExpertise(currentExpertises);
                }
                /*if (parameter.length -1 < 4) {
                    String[] temp = new String[4];
                    for (int i = 0; i < 4; i++) {

                        if (i < parameter.length) {
                            temp[i] = parameter[i];
                        } else {
                            temp[i] = "none";
                        }

                    }
                    parameter = temp;

                 */

            }
            default -> System.out.println("Unbekannter Befehl! Mögliche Befehle: enter, enter new sprint, enter expertise, enter start, enter end");
        }
    }

    @Override
    public void undo() {

    }
}
