package org.hbrs.se1.ws21.uebung4.model;

public class PlanCommand implements Command {
    private final String[] parameter;

    public PlanCommand(String[] parameter) {
        this.parameter = parameter;
    }

    @Override
    public void execute() throws ContainerException {
        // TODO: 21.03.22 plan sprint weiter implementieren
        if(parameter[3].equals("-all")){
            for (Employee employee : Container.getInstance().getCurrentListEmpl()
                 ) {
                Container.getInstance().startAusgabeEmpl(Container.getInstance().getCurrentListEmpl(), "dump");
            }
            System.out.println("Die folgenden Mitarbeiter sind in der Filiale verfügbar (geeignet und nicht geeignet):");

        } else if (parameter[3].equals("none")){
            if(Container.getInstance().checkName(parameter[2])){
                System.out.println("Die folgenden Mitarbeiter sind für Ihren Sprint geeignet: \n");
            } else {
                System.out.println("Sprint mit dem Namen " + parameter[2] + " nicht vorhanden!");
            }
        } else {
            System.out.println("Unbekannter Befehl!\nMögliche Befehle:\n  plan sprint \"<Sprintname>\"" +
                    "\n  plan sprint \"<Sprintname>\" -all");
        }
    }

    @Override
    public void undo() {

    }
}
