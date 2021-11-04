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
    for (int i = 0; i < 3; ++i) {
        System.out.print("Wollen Sie dem Mitarbeiter eine Expertise zuweisen? (Ja/Nein): ");
        String entscheidung = sc.next().toUpperCase(); // Zeichenkette einlesen
        if (entscheidung.equals("JA")) {
            System.out.print("Geben Sie bitte die Bezeichnung der Expertise des Mitarbeiters ein: ");
            String expertise = sc.next(); // Zeichenkette einlesen
            System.out.print("Geben Sie bitte den Grad der Expertise des Mitarbeiters ein: ");
            int expertisenGrad = sc.nextInt(); // Zeichenkette einlesen
            employeeExpertise.add(i, expertise);
            employeeExpertise.add(i, expertisenGrad);
            if (i == 0) {
                employee.setExpertise1(employeeExpertise);
            }
            if (i == 1) {
                employee.setExpertise2(employeeExpertise);
            }
            if (i == 2) {
                employee.setExpertise3(employeeExpertise);
            }
        } else if (entscheidung.equals("NEIN")) {
            break;
        } else{
            System.out.println("Geben Sie bitte Ja oder Nein ein");
            i = i-1;
        }

    }
    //sc.close(); // Scanner schliessen
    // (Eingabe beenden)
    return employee;
    }
}
