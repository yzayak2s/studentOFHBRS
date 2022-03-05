package org.hbrs.se1.ws21.uebung4.model;

import org.hbrs.se1.ws21.uebung4.model.persistence.PersistenceStrategy;
import org.hbrs.se1.ws21.uebung4.model.persistence.PersistenceStrategyStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class StoreCommand implements Command{
    private final String parameter;

    public StoreCommand(String parameter) {
        this.parameter = parameter;
    }

    final static String LOCATION = "StoredSprints.ser";

    @Override
    public void execute() throws ContainerException {

        if (Container.getInstance().checkName(parameter)){
            ObjectOutputStream oos = null;
            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream( LOCATION );
                oos = new ObjectOutputStream(fos);
                oos.writeObject( Container.getInstance().getSprintFromName(parameter) );
                System.out.println( "Der Sprint" + parameter + "wurden erfolgreich gespeichert!");
            }
            catch (IOException e) {
                e.printStackTrace();
                //  Delegation in den aufrufendem Context
                // (Anwendung Pattern "Chain Of Responsibility)
                throw new ContainerException("Fehler beim Abspeichern");
            }
        }
    }

    @Override
    public void undo() {

    }
}
