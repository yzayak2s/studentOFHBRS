package org.hbrs.se.ws20.uebung1.control;

public class GermanTranslator implements Translator {

	public String date = "Okt/2020"; // Default-Wert
	private String[] zahlen = {"eins", "zwei", "drei", "vier", "fünf", "sechs", "sieben", "acht", "neun", "zehn"};
	/**
	 * Methode zur Übersetzung einer Zahl in eine String-Repraesentation
	 * @see org.bonn.se.übung1.ws14.lösung.Translator#translateNumber(int)
	 */
	public String translateNumber( int number ) { 
		// [ihr Source Code aus Übung 1-2]
		String result = "";
		try {
			result = zahlen[ number -1];
		} catch (ArrayIndexOutOfBoundsException e){
			result = "Übersetzung der Zahl " + number + " nicht möglich! (V " + Translator.version + ")";
		} finally {
			return result;
		}
	}
		
	/**
	 * Objektmethode der Klasse GermanTranslator zur Ausgabe einer Info.
	 */
	public void printInfo() {
		System.out.println( "GermanTranslator v1.9, erzeugt am " + this.date );
	}

	/**
	 * Setzen des Datums, wann der Uebersetzer erzeugt wurde (Format: Monat/Jahr (Beispiel: Nov/2020))
	 * Das Datum sollte system-intern gesetzt werden und nicht von externen View-Klassen
	 */
	public void setDate( String date ) {
		this.date = date;
	}

}
