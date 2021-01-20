package org.hbrs.se.ws20.solutions.uebung8;

public class HotelSuche {

    public void start() {
        ExternalHotelSucheInterface adapter = new ReiseAnbieterAdapter(); // Factory
        SuchErgebnis ergebnis = adapter.suche( new SuchAuftrag() );
        // Work on SuchErgebnis (z.B. Ausgabe...)

    }

}
