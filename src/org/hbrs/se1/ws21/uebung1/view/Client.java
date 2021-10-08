package org.hbrs.se1.ws21.uebung1.view;

import org.hbrs.se1.ws21.uebung1.control.GermanTranslator;
import org.hbrs.se1.ws21.uebung1.control.TranslatorFactory;

public class Client {

	/*
	 * Methode zur Ausgabe einer Zahl auf der Console
	 */
	public void display( int aNumber ){
		// In dieser Methode soll die Methode translateNumber 
		// mit dem übergegebenen Wert der Variable aNumber 
		// aufgerufen werden.
		//
		// Strenge Implementierung gegen das Interface Translator gewuenscht!

		// Verwendung Design Pattern "Factory Method" [GoF] Gang of Fore, Kapitel 6
		// Problem: Inkonsistente Objekt-Erzeugung
		// Lösung / Vorteile: Konsistente und zentrale Objekt-Erstellung über eine
		// eigene und separate Klasse
		GermanTranslator translator = TranslatorFactory.createGermanTranslator(); //new GermanTranslator
		String result = translator.translateNumber(1);

		translator = TranslatorFactory.createGermanTranslator(); //System bleibt anpassbarer

		System.out.println("Das Ergebnis der Berechnung: " +
				"[das Ergebnis an dieser Stelle]"  );


	}
}




