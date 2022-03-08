package org.hbrs.se1.ws21.uebung1.control;

public class SpanishTranslator implements Translator {

    public String fecha = "oct/2020"; // Default-Wert


    private String[] numero = { "uno" , "dos" , "tres" , "cuatro" , "cinco" , "seis" , "siete" , "ocho" , "Nueve" , "diez" };

    public String translateNumber (int number){

        String result = "";

        try {
            result = numero[ number -1 ];
        } catch (ArrayIndexOutOfBoundsException e){
            result = "No es posible traducir el numero " + number + "! (V " + version + ")";
        } finally {
            return result;
        }
    }
}
