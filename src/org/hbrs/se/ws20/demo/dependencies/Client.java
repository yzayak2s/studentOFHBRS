package org.hbrs.se.ws20.demo.dependencies;

public class Client {
	
	/**
	 * Die Klasse Client hat eine Abhängigkeit zur Klasse Application:
	 *
	 *  ----------         ---------------
	 *  | Client |   --->  | Application |
	 *  ----------         ---------------
	 *
	 * Diese Abhängigkeit kann aus (mindestens) einer von drei Gruenden bestehen:
	 * 1. Abhängigkeit über eine Instanzvariable (Abhängigkeit Nr. 1)
	 * 2. Abhängigkeit über eine lokale Variable innerhalb einer Methode (Abhängigkeit Nr. 2)
	 * 3. Abhängigkeit über ein statisches Element (hier: eine statische Methode) (Abhängigkeit Nr. 3)
	 */
    
    // Abhängigkeit Nr. 1 (Instanz-Variable) --> auch eine Assoziation!
    private Application app;
    
    public void print() {
        // Abhängigkeit Nr. 2 (Lokale Variable)
        Application app;
        
        // Abhängigkeit Nr. 3 (Aufruf einer statischen Methode)
        Application.log();
        
    }
    
}
