package org.hbrs.se1.ws21.uebung4.model;

public interface Member {

    // ID ist in einem abgeleiteten Objekt über eine Konstruktor-Methode zu belegen
    // --> Primaerschluessel zur Unterscheidung aller Member-Objekte
    Integer getPid();

    public String toString();

}
