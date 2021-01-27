package org.hbrs.se.ws20.uebung3;

import java.util.List;

public class MemberView {

    public void dump( List<Member> liste ) {
        System.out.println("Ausgabe aller Memberen: ");
        // Loesung mit For each:
        for (Member p : liste) {
            System.out.println("ID: " + p.getID());
        }
    }
}
