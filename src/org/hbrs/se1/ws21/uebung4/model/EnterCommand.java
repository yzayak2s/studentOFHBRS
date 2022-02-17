package org.hbrs.se1.ws21.uebung4.model;

import org.hbrs.se1.ws21.uebung4.control.EingabeDialog;

public class EnterCommand implements Command {

    @Override
    public void execute() {
        try {
            Container.getInstance().addEmployee(EingabeDialog.eingabeDialog());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void undo() {

    }
}
