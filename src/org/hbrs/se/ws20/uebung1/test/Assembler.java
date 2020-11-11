package org.hbrs.se.ws20.uebung1.test;


import org.hbrs.se.ws20.uebung1.control.EnglishTranslator;
import org.hbrs.se.ws20.uebung1.control.GermanTranslator;
import org.hbrs.se.ws20.uebung1.control.Translator;
import org.hbrs.se.ws20.uebung1.view.Client;

public class Assembler {
    private Client client = null;
    private Translator translator = null;

    public Assembler() {
        translator = new GermanTranslator();
        client = new Client();

        client.setTranslator( translator );
    }
    public void test() {

        client.display(1);
        client.display(2);
        client.display(3);
        client.display(4);
        client.display(5);
        client.display(6);
        client.display(7);
        client.display(8);
        client.display(9);
        client.display(10);

        client.display(11);
        client.display(-1);
        client.display(73456341);

        this.client.setTranslator(new EnglishTranslator());

        client.display(1);

        client.display(11);
    }

    public void  testAutomatisiert() {
        String ergebnis = this.translator.translateNumber(1);

        if(ergebnis.equals("eins")) {
            System.out.println("Test erfolgreich!");
        } else {
            System.out.println("Test nicht erfolgreich!");
        }
    }

    public static void main(String[] args) {
        Assembler assemb = new Assembler();
        assemb.test();
    }
}
