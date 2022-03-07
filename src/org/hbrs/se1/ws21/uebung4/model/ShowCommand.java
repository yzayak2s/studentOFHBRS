package org.hbrs.se1.ws21.uebung4.model;

public class ShowCommand implements Command{
    private final String[] parameter;

    public ShowCommand(String[] parameter) {
        this.parameter = parameter;
    }

    @Override
    public void execute() {// TODO: 28.02.22 switch case zu ende machen; show command ist das Ziel
        switch (parameter[1]){
            case "employee" -> System.out.println("Employee");

            case "sprint" -> {
                try {
                    Sprint temp_sprint = Container.getInstance().getSprintFromName(parameter[2].replaceAll("^\"|\"$", ""));
                    System.out.println(temp_sprint.toString());
                    System.out.println("DUMP-Sprint: " + parameter[2]);
                } catch (IndexOutOfBoundsException e){
                    System.out.println(e.getMessage());
                }
            }

            default -> System.out.println("Unbekannter Befehl! Mögliche Befehle: show employee und show sprint");
        }
    }

    @Override
    public void undo() {

    }
}
