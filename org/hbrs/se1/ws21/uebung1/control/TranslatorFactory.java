package org.hbrs.se1.ws21.uebung1.control;

/**
 *
 * @author yzayak2s rfalke2s
 *
 */

public class TranslatorFactory {
    public static GermanTranslator createGermanTranslator(){
        GermanTranslator translator = new GermanTranslator();
        translator.setDate("Oct/11");
        return translator;
    }
}
