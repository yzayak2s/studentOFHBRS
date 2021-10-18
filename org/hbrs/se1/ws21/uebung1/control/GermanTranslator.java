package org.hbrs.se1.ws21.uebung1.control; //Sortierung des Codes der Klassen, Zugriffsteuerung, bringt Struktur

public class GermanTranslator implements Translator {

    public String date = "Okt/2021"; // Default-Wert

    /**
     * Methode zur Übersetzung einer Zahl in eine String-Repraesentation
     */

    public String translateNumber(int number) {
        // [ihr Source Code aus Übung 1-2]
        /**
         *
         * @author yzayak2s rfalke2s
         *
         */
        String[] deutscheZahlenArray = {"eins", "zwei", "drei", "vier", "fünf", "sechs", "sieben", "acht", "neun", "zehn"};
        try {
            return deutscheZahlenArray[number-1];
        } catch (Exception e) {
            return String.format("Übersetzung der Zahl %d nicht möglich (%f)", number, version);
        }
    }

    /**
     * Objektmethode der Klasse GermanTranslator zur Ausgabe einer Info.
     */
    public void printInfo() {
        System.out.println("GermanTranslator v1.9, erzeugt am " + this.date);
    }

    /**
     * Setzen des Datums, wann der Uebersetzer erzeugt wurde (Format: Monat/Jahr (Beispiel: Okt/2021))
     * Das Datum sollte system-intern gesetzt werden und nicht von externen View-Klassen
     */
    public void setDate(String date) {
        this.date = date;
    }
}