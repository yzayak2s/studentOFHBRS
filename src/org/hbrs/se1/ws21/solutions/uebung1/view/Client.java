package org.hbrs.se1.ws21.solutions.uebung1.view;

import org.hbrs.se1.ws21.solutions.uebung1.control.Translator;
import org.hbrs.se1.ws21.solutions.uebung1.control.factory.TranslatorFactory;

public class Client {

	/*
	 * Methode zur Ausgabe einer Zahl auf der Console
	 */
	public void display( int aNumber ){
		// In dieser Methode soll die Methode translateNumber 
		// mit dem übergegebenen Wert der Variable aNumber 
		// aufgerufen werden.
		// Strenge Implementierung gegen das Interface Translator gewuenscht!

		// Referenz aktiv beziehen
		Translator translator = TranslatorFactory.createGermanTranslator(); // new GermanTranslator();
		String result = translator.translateNumber( aNumber );

		System.out.println("Das Ergebnis der Berechnung: " +
				"[das Ergebnis an dieser Stelle]" + result );

		translator = TranslatorFactory.createEnglishTranslator();
		result = translator.translateNumber( aNumber );

		// System.out.println("Ergebnis auf Englisch: " + result );

	}
}




