/**
 *
 * @author yzayak2s rfalke2s
 *
 */
import org.hbrs.se1.ws21.uebung1.control.*;
import org.hbrs.se1.ws21.uebung1.control.factories.TranslateFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestFactory {

    private Translator translator = null;

    @BeforeEach
    public void setUp(){
        this.translator = TranslateFactory.createGermanTranslator();
    }

    @Test
    public void test(){
        // Positiver Test
        assertEquals("eins", this.translator.translateNumber(1));
        assertEquals("zwei", this.translator.translateNumber(2));
        assertEquals("drei", this.translator.translateNumber(3));
        assertEquals("vier", this.translator.translateNumber(4));
        assertEquals("fünf", this.translator.translateNumber(5));
        assertEquals("sechs", this.translator.translateNumber(6));
        assertEquals("sieben", this.translator.translateNumber(7));
        assertEquals("acht", this.translator.translateNumber(8));
        assertEquals("neun", this.translator.translateNumber(9));
        assertEquals("zehn", this.translator.translateNumber(10));

        // Negativer Test
        String test = "Übersetzung der Zahl 11 nicht möglich! (V " + Translator.version + ")";
        assertEquals(test, this.translator.translateNumber(11));

        String test2 = "Übersetzung der Zahl -11 nicht möglich! (V " + Translator.version + ")";
        assertEquals(test2, this.translator.translateNumber(-11));

        String test3 = "Übersetzung der Zahl 0 nicht möglich! (V " + Translator.version + ")";
        assertEquals(test3, this.translator.translateNumber(0));


        //String erg_case1 = translator.translateNumber(8);
        //String erg_case2 = translator.translateNumber(12);
        //String erg_case3 = translator.translateNumber(-12);
        //String erg_case4 = translator.translateNumber(0);
        //assertEquals("acht", erg_case1);
        //assertEquals("Übersetzung der Zahl 12 nicht möglich (1.0)", erg_case2);
        //assertEquals("Übersetzung der Zahl -12 nicht möglich (1.0)", erg_case3);
        //assertEquals("Übersetzung der Zahl 0 nicht möglich (1.0)", erg_case4);
    }
}