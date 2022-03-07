package org.hbrs.se1.ws21.uebung4.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.Scanner;

public class LoadCommand implements Command {
    private final String[] parameter;

    public LoadCommand(String[] parameter) {
        this.parameter= parameter;
    }

    @Override
    public void execute() {
        switch (this.parameter[1]) {
            case "force" -> {
                Container.getInstance().setListe(null);
                Container.getInstance().load();
            }
            case "merge" -> {
                List<Employee> tmp = Container.getInstance().getCurrentList();    // zwischenzeitliches speichern der aktuellen Liste im Container
                Container.getInstance().load();                                    // ersetzen der liste durch die liste im File
                for (Employee employee : tmp) {
                    int counter = 0;
                    int tempID = employee.getPid();
                    for (Employee e : Container.getInstance().getCurrentList()) {
                        if (e.getPid() != tempID) {
                            counter++;
                        }
                    }
                    if (counter == Container.getInstance().getCurrentList().size()) {
                        Container.getInstance().getCurrentList().add(employee);   // hinzufügen der temporär gespeicherten Mitarbeiter sofern noch nicht im Speicher
                    } else {
                        System.out.println("ID: " + tempID + " bereits vergeben! Wollen sie die ID überschreiben?");
                        Scanner sc = new Scanner(System.in);
                        if (sc.next().equalsIgnoreCase("JA")) {
                            for (Employee e : Container.getInstance().getCurrentList()) {
                                if (e.getPid() == tempID) {
                                    Container.getInstance().getCurrentList().remove(e);        // Element mit derselben Nummer löschen
                                    Container.getInstance().getCurrentList().add(employee);    // Das Element aus dem File hinzufügen
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            case "sprint" -> {
                final String LOCATION = "StoredSprints.ser";
                ObjectInputStream ois = null;
                FileInputStream fis = null;
                try {
                    fis = new FileInputStream( LOCATION );
                    ois = new ObjectInputStream(fis);
                    // Auslesen der Liste
                    Object obj = ois.readObject();
                    if (obj instanceof List<?>) {
                        List<Sprint> sprintList = (List) obj;
                        for (Sprint sprintFromList : sprintList) {
                            if(parameter[2].equals(sprintFromList.getName())){
                                Container.getInstance().addSprint(sprintFromList);
                                System.out.println( "Der Sprint " + parameter + " wurde erfolgreich geladen!");
                            }
                        }
                        System.out.println("Datei nicht gefunden!");
                    }
                }
                catch (IOException e) {
                    System.out.println("LOG (für Admin): Datei konnte nicht gefunden werden!");
                    System.out.println(e.getMessage());
                }
                catch (ClassNotFoundException e) {
                    System.out.println("LOG (für Admin): Liste konnte nicht extrahiert werden (ClassNotFound)!");
                } catch (ContainerException e) {
                    e.printStackTrace();
                } finally {
                    if (ois != null) try { ois.close(); } catch (IOException e) {}
                    if (fis != null) try { fis.close(); } catch (IOException e) {}
                }
            }
            case "none" -> System.out.println("Geben Sie bitte die Variante des Ladens als 2. Parameter an (load force oder load merge).");
            default -> System.out.println("Unbekannter Befehl! Mögliche Befehle: load force, load merge");
        }
    }

    @Override
    public void undo() {

    }
}
