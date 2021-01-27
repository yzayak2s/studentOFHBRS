package org.hbrs.se.ws20.uebung3;

public class TestContainer {

	public static void main (String[] args)  {
		TestContainer test = new TestContainer();
		try {
			test.start();
		} catch (ContainerException e) {
			e.printStackTrace();
		}

	}

	// Variable zur Feststellung, ob alle Testfälle erfolgreich waren
	// wird auf false gesetzt, falls mindestens ein Testfall fehlgeschlagen ist.
	private boolean testStatus = true; 
	
	public void start() throws ContainerException {
		
		// Ist so mit einem Cast moeglich...
		Member r1 = new MemberKonkret(12, null);
		( (Info)  r1 ).setName("Mueller");
		
		// ... oder besser ueber Konstruktor:
		Member r2 = new MemberKonkret(32, "Theo");
		Member r3 = new MemberKonkret(112, "Maier");
		Member r4 = new MemberKonkret(1211, "Juergen");
		Member r5 = new MemberKonkret(934, "Schmitt");
			 
		// Instanz holen
		Container store = Container.getInstance();
		Container store2 = Container.getInstance();
		
		if ( store == store2 ) {
			System.out.println("Objekte identisch");
		}
		
		if ( store.equals( store2 ) ) {
			System.out.println("Objekte gleich");
		}
		
		// Listen-Typ setzen
		// store.changeListType( Modus.LIST_TYPE_CUSTOM );
		
		// Testfall 1 - Check auf leeren Store
		vergleich ( "Testfall 1 - Pruefung auf leeren Store" , 0 , store.getAnzahl()  );
		
		store.addMember( r1 ); 
		store.addMember( r2 );
		store.addMember( r3 );
		store.addMember( r4 );
	
		// Testfall 2 - Check, ob vier Objekte eingefuegt wurden
		vergleich ( "Testfall 2 - Pruefen, ob vier Objekte eingefuegt wurden" , 4 , store.getAnzahl()  );
		
		store.addMember(r5);
		
		// Testfall 3 - Check, ob fuenftes Objekt eingefuegt wurde
		vergleich ( "Testfall 3 - Pruefen, ob fuenftes Objekt eingefuegt wurde" , 5 , store.getAnzahl()  );
		
		String result = store.deleteMember(12);
		// System.out.println( result );
		
		// Testfall 4 - Check, ob Objekt geloescht wurde
		vergleich ( "Testfall 4 - Pruefen, ob Objekt geloescht wurde" ,  4 , store.getAnzahl()  );
		
		result = store.deleteMember(12222);
		System.out.println( result );
		
		// Testfall 5 - Pruefen, ob ein Objekt faelschlicherweise nicht geloescht wurde
		vergleich ( "Testfall 5 - Pruefen, ob ein Objekt faelschlicherweise nicht geloescht wurde" , 4 , store.getAnzahl()  );
		
		try {
			store.addMember( r2 );
		} catch (ContainerException e) {
			
			e.printStackTrace();
		} finally {
			// Testfall 6 - Pruefen, ob ein Objekt faelschlicherweise nicht doppelt eingefuegt wurde
			vergleich ( "Testfall 6 - Check, ob ein Objekt faelschlicherweise nicht doppelt eingefuegt wurde" , 4 , store.getAnzahl()  );

		}
		
		// Test der Dump-Funktion (ohne Kontrolle)
		// store.dump();
		
		CloneableMember original = new CloneableMember( 565 , "Asbach" );
		CloneableMember copie = null;
		
		try {
			copie = ( CloneableMember ) original.clone();
		} catch (CloneNotSupportedException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Testfall 7 - Pruefen, ob ein kopiertes Objekt faelschlicherweise nicht doppelt eingefuegt wurde
		store.addMember( copie );
		try {
			
			store.addMember( original );
			
		} catch (ContainerException e) {
			
			// e.printStackTrace();
			
		} finally {
			// Testfall 7 - Check, ob ein kopiertes Objekt faelschlicherweise nicht doppelt eingefuegt wurde
			vergleich ( "Testfall 7 - Check, ob ein kopiertes Objekt faelschlicherweise nicht doppelt eingefuegt wurde" , 5 , store.getAnzahl()  );
			
		}
		// store.dump();
		
		checkTestSuite();
	}
	
	private void checkTestSuite() {
		if (this.testStatus) {
			System.out.println("Der gesamte Testfall war erfolgreich!");
			
		} else {
			System.out.println("Der Testfall war nicht erfolgreich!");
		}
		
	}

	private void vergleich( String titel, int soll , int ist ){
		System.out.print( titel + ": \n");
		if (soll == ist ) {
			System.out.print("Soll (" + soll + ") = IST (" + ist + ") --> Test ERFOLGREICH");
		} else {
			System.out.print("Soll (" + soll + ") != IST (" + ist + ") --> Test NICHT ERFOLGREICH");
			this.testStatus = false;
		}
		System.out.println("\n");
	}	

}
