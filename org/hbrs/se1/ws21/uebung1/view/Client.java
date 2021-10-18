package org.hbrs.se1.ws21.uebung1.view;

import com.sun.java.accessibility.util.Translator;
import org.hbrs.se1.ws21.uebung1.control.GermanTranslator;
import org.hbrs.se1.ws21.uebung1.control.TranslatorFactory;
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
        GermanTranslator translator = TranslatorFactory.createGermanTranslator();

        System.out.println("Das Ergebnis der Berechnung: " +
                translator.translateNumber(aNumber));

    }
}



