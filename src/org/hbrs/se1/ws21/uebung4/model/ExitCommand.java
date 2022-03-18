package org.hbrs.se1.ws21.uebung4.model;

public class ExitCommand implements Command {
    private final String[] parameter;

    public ExitCommand(String[] parameter) {
        this.parameter = parameter;
    }

    @Override
    public void execute() throws ContainerException {
        System.out.println("Das Programm wird beendet!\n" +
                "Auf Wiedersehen!");
    }

    @Override
    public void undo() {

    }
}
