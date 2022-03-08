package org.hbrs.se1.ws21.uebung1.control;

public class EnglishTranslator implements Translator {

    public String date = "Okt/2020"; // Default-Wert

    // Das initiale Array mit den Zahlen
    private String[] numbers = {"one" , "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};

    public String translateNumber (int number){

        String result = "";

        try {
            result = numbers[ number -1 ];
        } catch (ArrayIndexOutOfBoundsException e){

            result = "Translation of " + number + " is not possible! (V " + version + ")";

        } finally {
            return result;
        }
    }
}
