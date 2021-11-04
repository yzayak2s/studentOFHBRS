package org.hbrs.se1.ws21.uebung4.control;

import org.hbrs.se1.ws21.uebung4.model.Container;

import static org.hbrs.se1.ws21.uebung4.control.EingabeDialog.eingabeDialog;

public class Main {
    public static void main(String[] args) throws Exception {
        Container.getInstance().startEingabe();
        //eingabeDialog();
    }
}
