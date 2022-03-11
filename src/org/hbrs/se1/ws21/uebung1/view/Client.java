package org.hbrs.se1.ws21.uebung1.view;

import org.hbrs.se1.ws21.uebung1.control.*;
import org.hbrs.se1.ws21.uebung1.control.factories.TranslateFactory;

/**
 *
 * @author yzayak2s rfalke2s
 *
 */
public class Client {

     //private Translator translator;
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

        String result = translator.translateNumber(aNumber);

        System.out.println("Das Ergebnis der Berechnung: " +
                "[das Ergebnis an dieser Stelle]" + result );

        //translator = TranslateFactory.createEnglishTranslator();
        //result = translator.translateNumber(aNumber);
        //
        //System.out.println("\nErgebnis auf Englisch: " + result );

    }

    //public void setTranslator( Translator translator){
    //    this.translator = translator;
    //}
}



