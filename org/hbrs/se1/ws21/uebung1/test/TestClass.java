package org.hbrs.se1.ws21.uebung1.control;

/**
 *
 * @author yzayak2s rfalke2s
 *
 */
import org.hbrs.se1.ws21.uebung1.view.Client;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestClass {
    @Test
    public void test(){
        GermanTranslator translator = TranslatorFactory.createGermanTranslator();
        String erg_case1 = translator.translateNumber(8);
        String erg_case2 = translator.translateNumber(12);
        String erg_case3 = translator.translateNumber(-12);
        String erg_case4 = translator.translateNumber(0);
        assertEquals("acht", erg_case1);
        assertEquals("Übersetzung der Zahl 12 nicht möglich (1.0)", erg_case2);
        assertEquals("Übersetzung der Zahl -12 nicht möglich (1.0)", erg_case3);
        assertEquals("Übersetzung der Zahl 0 nicht möglich (1.0)", erg_case4);
    }
}
