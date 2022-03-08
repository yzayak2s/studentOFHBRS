package org.hbrs.se1.ws21.uebung1.view;

import org.hbrs.se1.ws21.uebung1.control.Translator;
import org.hbrs.se1.ws21.uebung1.control.GermanTranslator;
import org.hbrs.se1.ws21.uebung1.control.TranslatorFactory;
import org.hbrs.se1.ws21.uebung1.control.factories.TranslateFactory;

/**
 *
 * @author yzayak2s rfalke2s
 *
 */
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

        // Verwendung Design Pattern: Factory Method
        // Problem: Inkonsistente Objekt-Erzeugung
        // Lösung / Vorteil: konsistente und zentrale Stelle zur
        // Objekterzeugung
        //richtiger Code: GermanTranslator translator = TranslatorFactory.createGermanTranslator();
        Translator translator = TranslateFactory.createGermanTranslator(); // new GermanTranslator();
        String result = translator.translateNumber(1);

        translator = TranslateFactory.createSpanishTranslator();

        System.out.println("Das Ergebnis der Berechnung: " +
                translator.translateNumber(aNumber));

    }
}



