package org.hbrs.se.ws20.demo.dependencies;

/**
 * Demo zur Implementierung eines Interface mit Default-Methoden
 * sowie mit statischen Methoden
 */


public class Application implements GenericInterface {
	
	private String name; 
	
    @Override
    public String getName() {
        return null;
    }
    
    public static void log(){
        // Statische Methode kann nicht ueberschrieben werden!
        System.out.println("Hello from Static-Method in Class");
    }
    
    @Override
	public void printState() {
    	// Default-Methode kann ueberschrieben werden!
		System.out.println("Hello from overridden Method");
		GenericInterface.super.printState();
	}

    public static void main ( String args[] ) {
        GenericInterface my = new Application();
        
        // Aufruf der überschriebenen Methode 
        my.getName();
        
        //Aufruf der Default-Methode aus Interface
        my.printState();
        
        // Aufruf der statischen Methode aus Interface
        GenericInterface.log();
        
        // Aufruf der statischen Methode aus der Klasse (Cast notwendig)
        ((Application) my).log();
   
    }
 
}

