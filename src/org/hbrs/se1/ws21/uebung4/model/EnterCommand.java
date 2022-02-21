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
            case "sprint" -> {
                try {
                    Container.getInstance().addSprint(new Sprint());
                } catch (ContainerException e) {
                    e.printStackTrace();
                }

                System.out.println("Enter the expertises and dates with further commands");

            }
            case "expertise" -> {

            }
        }
    }

    @Override
    public void undo() {

    }
}
