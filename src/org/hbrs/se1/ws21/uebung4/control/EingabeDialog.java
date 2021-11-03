package org.hbrs.se1.ws21.uebung4.control;

import org.hbrs.se1.ws21.uebung2.Container;
import org.hbrs.se1.ws21.uebung4.model.Employee;

import java.util.Scanner;
import java.util.List;

public class EingabeDialog {
    public Scanner getScanner(){
        return new Scanner(System.in);
    }
public static Employee eingabeDialog() {
        Employee employee = new Employee();
        Scanner sc = new Scanner(System.in); // Tastatur-Scanner anlegen
    System.out.print("Geben Sie bitte eine Mitarbeiter ID ein: ");
    employee.setPid(sc.nextInt()); // Ganzzahl einlesen
    System.out.print("Geben Sie bitte den Vornamen des Mitarbeiters ein: ");
    String firstname = sc.next(); // Zeichenkette einlesen
    System.out.print("Geben Sie bitte den Nachnamen des Mitarbeiters ein: ");
    String lastname = sc.next(); // Zeichenkette einlesen
    System.out.print("Geben Sie bitte ein, welche Rolle der Mitarbeiter im Unternehmen hat: ");
    String role = sc.next(); // Zeichenkette einlesen
    System.out.print("Geben Sie bitte die Abteilung des Mitarbeiters ein, falls vorhanden: ");
    String department = sc.next(); // Zeichenkette einlesen
    List<String> expertisenArray = null;
    List<Integer> expertisenGradArray = null;

    for(int i=0;i<3;++i) {
        System.out.print("Wollen Sie dem Mitarbeiter eine Expertise zuweisen? (Ja/Nein): ");
        String entscheidung = sc.next().toUpperCase(); // Zeichenkette einlesen
        if (entscheidung.equals("JA")) {
            System.out.print("Geben Sie bitte die Bezeichnung der Expertise des Mitarbeiters ein: ");
            String expertise = sc.next(); // Zeichenkette einlesen
            System.out.print("Geben Sie bitte den Grad der Expertise des Mitarbeiters ein: ");
            int expertisenGrad = sc.nextInt(); // Zeichenkette einlesen
            expertisenArray.add(i,expertise);
            expertisenGradArray.add(i,expertisenGrad);

        } else if(entscheidung.equals("NEIN")){
            break;
        } else{
            System.out.println("Geben Sie bitte Ja oder Nein ein");
        }
    }
    sc.close(); // Scanner schliessen
    // (Eingabe beenden)
    return employee;
    }
}
