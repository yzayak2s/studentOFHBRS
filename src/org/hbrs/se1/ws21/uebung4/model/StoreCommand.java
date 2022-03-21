package org.hbrs.se1.ws21.uebung4.model;

public class StoreCommand implements Command{
    private final String[] parameter;

    public StoreCommand(String[] parameter) {
        this.parameter = parameter;
    }

    final static String LOCATION = "allsprints1.ser";

    @Override
    public void execute() throws ContainerException {
        // TODO: 19.03.22 Hier die Methode erweitern, um erstellte Employees speichern zu koennen. Update: funktioniert

        switch (this.parameter[1]) {

            // Employee Speicherung
            case "employee" -> {
                Container.storeEmployee();
            }
            // Sprint Speicherung
            case "sprint" -> {
                Container.storeSprint();
            }
            default -> System.out.println("Unbekannter Befehl!\nMögliche Befehle:\n  store employee\n  store sprint");
        }
    }

    @Override
    public void undo() {

    }
}
