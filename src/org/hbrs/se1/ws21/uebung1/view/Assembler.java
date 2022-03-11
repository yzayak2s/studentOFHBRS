package org.hbrs.se1.ws21.uebung1.view;

import org.hbrs.se1.ws21.uebung1.control.EnglishTranslator;
import org.hbrs.se1.ws21.uebung1.control.GermanTranslator;

public class Assembler {

    public void main(){
        // Dependency Injection (DI) Pattern
        // Passiv --> SE-2
        // hier kann Außerhalb des Clients ein Translator gesetzt werden

        GermanTranslator translator = new GermanTranslator();
        //Client client = new Client(translator);

        //..

        //client.setTranslator(new EnglishTranslator());
    }
}
