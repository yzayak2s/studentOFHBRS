package org.hbrs.se1.ws21.uebung4.control;

import org.hbrs.se1.ws21.uebung2.Container;
import org.hbrs.se1.ws21.uebung4.model.Employee;

import java.util.*;

public class EingabeDialog {
public static Employee eingabeDialog() {
        Employee employee = new Employee();
        Scanner sc = new Scanner(System.in); // Tastatur-Scanner anlegen
    System.out.print("Geben Sie bitte eine Mitarbeiter ID ein: ");
    employee.setPid(sc.nextInt());
    System.out.print("Geben Sie bitte den Vornamen des Mitarbeiters ein: ");
    employee.setVorname(sc.next());
    System.out.print("Geben Sie bitte den Nachnamen des Mitarbeiters ein: ");
    employee.setName(sc.next());
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
}
