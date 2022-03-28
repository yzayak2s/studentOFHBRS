package org.hbrs.se1.ws21.uebung4.model;

import org.hbrs.se1.ws21.uebung4.model.persistence.PersistenceStrategy;
import org.hbrs.se1.ws21.uebung4.model.persistence.PersistenceStrategyStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class StoreCommand implements Command{
    private final String[] parameter;

    public StoreCommand(String[] parameter) {
        this.parameter = parameter;
    }

    final static String LOCATION = "allemployees2.ser";
    final static String LOCATION2 = "allsprints2.ser";

    @Override
    public void execute() throws ContainerException {
        if(parameter[1].equals("sprint")){
            // Speichern der Employees siehe Methode storeEmpl()
            storeSpr();
        } else if(parameter[1].equals("employee")){
            // Speichern der Sprints
            storeEmpl();
        } else{
            System.out.println("\"Unbekannter Befehl! Mögliche Befehle: store sprint, store employee\"");
        }
    }

    private void storeEmpl() throws ContainerException{
        ObjectOutputStream oos = null;
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream( LOCATION );
            oos = new ObjectOutputStream(fos);

            oos.writeObject( Container.getInstance().getCurrentListEmpl());
            System.out.println( Container.getInstance().sizeEmpl() + " Employee/s wurde/n erfolgreich gespeichert!");
        }
        catch (IOException e) {
            e.printStackTrace();
            //  Delegation in den aufrufendem Context
            // (Anwendung Pattern "Chain Of Responsibility)
            throw new ContainerException("Fehler beim Abspeichern");
        }
    }

    private void storeSpr() throws ContainerException{
        ObjectOutputStream oos = null;
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream( LOCATION2 );
            oos = new ObjectOutputStream(fos);

            oos.writeObject( Container.getInstance().sizeSpr());
            System.out.println( Container.getInstance().sizeSpr() + " Sprint/s wurde/n erfolgreich gespeichert!");
        }
        catch (IOException e) {
            e.printStackTrace();
            //  Delegation in den aufrufendem Context
            // (Anwendung Pattern "Chain Of Responsibility)
            throw new ContainerException("Fehler beim Abspeichern");
        }
    }

    @Override
    public void undo() {

    }
}
