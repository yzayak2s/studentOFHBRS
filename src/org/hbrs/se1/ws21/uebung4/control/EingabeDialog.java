package org.hbrs.se1.ws21.uebung4.control;

import org.hbrs.se1.ws21.uebung4.model.Container;
import org.hbrs.se1.ws21.uebung4.model.ContainerException;
import org.hbrs.se1.ws21.uebung4.model.Employee;

import java.util.*;

public class EingabeDialog {
public static Employee eingabeDialog() throws Exception {
    Employee employee = new Employee();
    Scanner sc = new Scanner(System.in); // Tastatur-Scanner anlegen
    int counter = 0;
    System.out.print("Geben Sie bitte eine Mitarbeiter ID ein: ");

    try {
        int tempID = sc.nextInt();
        for(Employee e: Container.getInstance().getCurrentListEmpl()) {
            if(e.getPid()!= tempID){
                counter++;
            }
        }
        if (counter==Container.getInstance().getCurrentListEmpl().size()) {
            employee.setPid(tempID);
        }
        else {
            System.out.println("ID schon vergeben! Geben Sie bitte eine andere ID.\n");
            eingabeDialog();
        }
    } catch (InputMismatchException inputMismatchException) {
        System.out.println("Bitte geben Sie eine gültige ID ein!\n");
        eingabeDialog();
    }

    System.out.print("Geben Sie bitte den Vornamen des Mitarbeiters ein: ");
    employee.setVorname(sc.next());
    System.out.print("Geben Sie bitte den Nachnamen des Mitarbeiters ein: ");
    String name = sc.next();
    employee.setName(EingabeDialog.setName(name));
    System.out.print("Geben Sie bitte ein, welche Rolle der Mitarbeiter im Unternehmen hat: ");
    employee.setRolle(sc.next());
    System.out.print("Geben Sie bitte die Abteilung des Mitarbeiters ein, falls vorhanden (sonst n/a): ");
    employee.setAbteilung(sc.next());
    List<Object> employeeExpertise = new ArrayList<Object>();
    List<Integer> employeeExpertisenGrad = new ArrayList<>();

    for (int i = 0; i < 3; ++i) {
        String entscheidung;
        if(i==0){
            System.out.print("Wollen Sie dem Mitarbeiter eine Expertise zuweisen? (Ja/Nein): ");
            entscheidung = sc.next().toUpperCase(); // Zeichenkette einlesen
        }
        else {
            System.out.print("Wollen Sie dem Mitarbeiter eine weitere Expertise zuweisen? (Ja/Nein): ");
             entscheidung = sc.next().toUpperCase(); // Zeichenkette einlesen
        }

        if (entscheidung.equals("JA")) {
            System.out.print("Geben Sie bitte die Bezeichnung der Expertise des Mitarbeiters ein: ");
            String expertise = sc.next(); // Zeichenkette einlesen
            System.out.print("Geben Sie bitte den Grad der Expertise des Mitarbeiters ein: ");
            int expertisenGrad = sc.nextInt(); // Zeichenkette einlesen
            employeeExpertise.add(i, expertise);
            employeeExpertisenGrad.add(i, expertisenGrad);
        } else if (entscheidung.equals("NEIN")) {
            break;
        } else{
            System.out.println("Geben Sie bitte Ja oder Nein ein");
            i = i-1;
        }

    }
    employee.setExpertise(employeeExpertise);
    employee.setExpertisenGrad(employeeExpertisenGrad);
    //sc.close(); // Scanner schliessen
    // (Eingabe beenden)
    return employee;
    }
    public static String setName(String name) throws Exception{
        double userInputDouble = 0;

        while (true) {
            Scanner sc = new Scanner(System.in);
            try {
                userInputDouble = Double.parseDouble(name);     // double da man damit int auch direkt behandelt
                throw new ContainerException("Ungültiges Format: Zahl ("+userInputDouble+")");

            }
            catch (ContainerException e) {
                e.printStackTrace();
                System.out.print("Geben Sie bitte den richtigen Nachnamen des Mitarbeiters ein: ");
                name = sc.next();
            }
            catch (NumberFormatException ignore) {
                break;

            }
        }
    return name;
    }
}