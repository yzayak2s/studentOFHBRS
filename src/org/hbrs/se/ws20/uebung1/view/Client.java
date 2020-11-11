package org.hbrs.se.ws20.uebung1.view;
import org.hbrs.se.ws20.uebung1.control.*;

public class Client {
	private Translator translator = null;
	/*
	 * Methode zur Ausgabe einer Zahl auf der Console
	 */
	public void display( int aNumber ){
		// In dieser Methode soll die Methode translateNumber 
		// mit dem übergegebenen Wert der Variable aNumber 
		// aufgerufen werden.
		// Strenge Implementierung gegen das Interface Translator gewuenscht!

		System.out.println("Das Ergebnis der Berechnung: " + aNumber + this.translator.translateNumber(aNumber) +
				Translator.version + "[das Ergebnis an dieser Stelle]" );
		Translator translator = Factory.createGermanTranslator();

	}
	public void setTranslator(Translator translator) {
		this.translator = translator;
	}
}




