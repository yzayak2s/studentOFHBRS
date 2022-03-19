package org.hbrs.se1.ws21.uebung4.model;

public class ShowCommand implements Command{
    private final String[] parameter;

    public ShowCommand(String[] parameter) {
        this.parameter = parameter;
    }

    @Override
    public void execute() {// TODO: 28.02.22 switch case zu ende machen; show command ist das Ziel
        switch (parameter[1]){
            case "employee" -> {
                try {
                    Employee employee = Container.getSpecEmployee(Integer.parseInt(parameter[2]));
                    System.out.println(employee.toString());
                    //System.out.println("DUMP-Employee: " + parameter[2]);
                } catch (IndexOutOfBoundsException e){
                    System.out.println(e.getMessage());
                } catch (NumberFormatException numberFormatException){
                    System.out.println("Geben Sie bitte eine gültige ID!");
                }
            }

            case "sprint" -> {
                try {
                    Sprint temp_sprint = Container.getInstance().getSprintFromName(parameter[2].replaceAll("^\"|\"$", ""));
                    System.out.println(temp_sprint.toString());
                    //System.out.println("DUMP-Sprint: " + parameter[2]);
                } catch (IndexOutOfBoundsException e){
                    System.out.println(e.getMessage());
                }
            }

            default -> System.out.println("Unbekannter Befehl!\nMögliche Befehle:\n  show employee" +
                    "\n  show sprint");
        }
    }

    @Override
    public void undo() {

    }
}
