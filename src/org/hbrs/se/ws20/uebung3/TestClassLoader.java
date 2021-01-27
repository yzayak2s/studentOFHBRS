package org.hbrs.se.ws20.uebung3;


public class TestClassLoader {
	
	private Container c = null; 

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestClassLoader t = new TestClassLoader();

	}
	
	public TestClassLoader(){
		// Hier wird die Klasse vom Classloader geladen, aber nicht instanziiert,
		// da die Objektvariable instance in Klasse Container nicht belegt ist
		// Falls doch belegt, würde bereits bei diesem Zugriff das Objekt
		// verfrueht instanziiert werden. Der Java-Compiler fuegt dazu einen
		// weiteren static-Block hinzu, der die Varibale beim Laden belegt.
		// (--> bitte selber mal ausprobieren)
		Container.printInfoAboutClass();
				
	}

}
