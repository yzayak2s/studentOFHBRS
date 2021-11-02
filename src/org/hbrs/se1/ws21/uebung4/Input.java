package org.hbrs.se1.ws21.uebung4;

import org.hbrs.se1.ws21.uebung2.Container;

import java.util.Scanner;

public class Input {
    public Scanner getScanner(){
        return new Scanner(System.in);
    }
public static void echoSID() {
        Scanner sc = new Scanner(System.in);
        // Tastatur-Scanner anlegen
    /*System.out.print("Geben Sie bitte eine Mitarbeiter ID ein: ");
    int id = sc.nextInt(); // Ganzzahl einlesen
    System.out.print("Geben Sie bitte den Vornamen des Mitarbeiters ein: ");
    String firstname = sc.next(); // Zeichenkette einlesen
    System.out.print("Geben Sie bitte den Nachnamen des Mitarbeiters ein: ");
    String lastname = sc.next(); // Zeichenkette einlesen
    System.out.print("Geben Sie bitte ein, welche Rolle der Mitarbeiter im Unternehmen hat: ");
    String role = sc.next(); // Zeichenkette einlesen
    System.out.print("Geben Sie bitte die Abteilung des Mitarbeiters ein, falls vorhanden: ");
    String department = sc.next(); // Zeichenkette einlesen*/
    for(int i=0;i<3;++i) {
        System.out.print("Wollen Sie dem Mitarbeiter eine Expertise zuweisen? (Ja/Nein): ");
        String entscheidung = sc.next().toUpperCase(); // Zeichenkette einlesen
        if (entscheidung.equals("JA")) {

            String expertise1 = sc.next(); // Zeichenkette einlesen

            int id2 = sc.nextInt(); // Ganzzahl einlesen
        } else if(entscheidung.equals("NEIN")){
            break;
        } else{
            System.out.println("Geben Sie bitte Ja oder Nein ein");
        }
    }
    sc.close(); // Scanner schliessen
    // (Eingabe beenden)
    }
public static void main(String[] args){
    echoSID();
    }
}
