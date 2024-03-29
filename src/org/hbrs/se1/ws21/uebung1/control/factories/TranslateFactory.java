package org.hbrs.se1.ws21.uebung1.control.factories;

import org.hbrs.se1.ws21.uebung1.control.EnglishTranslator;
import org.hbrs.se1.ws21.uebung1.control.GermanTranslator;
import org.hbrs.se1.ws21.uebung1.control.SpanishTranslator;
import org.hbrs.se1.ws21.uebung1.control.Translator;

public class TranslateFactory {

    public static Translator createGermanTranslator(){
        GermanTranslator translator =  new GermanTranslator();
        translator.setDate("11-11-2021");
        return translator;
    }

    public static Translator createEnglishTranslator(){
        return new EnglishTranslator();
    }

    public static Translator createSpanishTranslator(){
        return new SpanishTranslator();
    }
}
