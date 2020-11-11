package org.hbrs.se.ws20.uebung1.control;

public class EnglishTranslator implements Translator {
    private String[] zahlen = { "one", "two", "three" };

    public String translateNumber( int number ) {
        // [ihr Source Code aus Übung 1-2]
        String result = "";
        try {
            result = zahlen[ number -1];
        } catch (ArrayIndexOutOfBoundsException e){
            result = "Translation of " + number + " is not possible! (V " + Translator.version + ")";
        } finally {
            return result;
        }
    }
}
