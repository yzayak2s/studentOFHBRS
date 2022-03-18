package org.hbrs.se1.ws21.uebung4.model;

import org.hbrs.se1.ws21.uebung4.model.persistence.PersistenceStrategy;
import org.hbrs.se1.ws21.uebung4.model.persistence.PersistenceStrategyStream;

import java.io.*;

public class StoreCommand implements Command{
    private final String[] parameter;

    public StoreCommand(String[] parameter) {
        this.parameter = parameter;
    }

    final static String LOCATION = "StoredSprints.ser";

    @Override
    public void execute() throws ContainerException {
        // TODO: 17.03.22 Speichert nur ein Sprint. Falls bereits ein Sprint vorhanden ist, wird dieser überschrieben.  
        if (Container.getInstance().checkName(parameter[2])){
            ObjectOutputStream oos = null;
            ObjectInputStream ois = null;
            FileInputStream fis = null;
            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream( LOCATION );
                oos = new ObjectOutputStream(fos);
                fis = new FileInputStream(LOCATION);
                ois = new ObjectInputStream(fis);

                // take the copy of the stream and re-write it to an InputStream
                PipedInputStream in = new PipedInputStream();
                final PipedOutputStream out = new PipedOutputStream(in);
                ObjectOutputStream finalOos = oos;
                new Thread(new Runnable() {
                    public void run () {
                        try {
                            // write the original OutputStream to the PipedOutputStream
                            // note that in order for the below method to work, you need
                            // to ensure that the data has finished writing to the
                            // ByteArrayOutputStream
                            finalOos.writeObject(out);
                        }
                        catch (IOException e) {
                            // logging and exception handling should go here
                        }
                        finally {
                            // close the PipedOutputStream here because we're done writing data
                            // once this thread has completed its run
                            if (out != null) {
                                // close the PipedOutputStream cleanly
                                try {
                                    out.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }).start();

                //SequenceInputStream mergeinput = new java.io.SequenceInputStream(ois, oos);
                oos.writeObject( Container.getInstance().getSprintFromName(parameter[2]) );
                System.out.println( "Der Sprint " + parameter + " wurde erfolgreich gespeichert!");
            }
            catch (IOException e) {
                e.printStackTrace();
                //  Delegation in den aufrufendem Context
                // (Anwendung Pattern "Chain Of Responsibility)
                throw new ContainerException("Fehler beim Abspeichern");
            }
        } else{
            System.out.println("Sprint mit dem Namen nicht vorhanden!");
        }
    }

    @Override
    public void undo() {

    }
}
