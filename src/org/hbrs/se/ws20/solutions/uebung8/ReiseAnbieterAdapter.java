package org.hbrs.se.ws20.solutions.uebung8;


public class ReiseAnbieterAdapter implements ExternalHotelSucheInterface {
	
	private ReiseAnbieter system; // = new ... hier ausgelassen
	
	@Override
	public SuchErgebnis suche( SuchAuftrag auftrag ) {
		QueryObject inputOld =  transformINPUT(auftrag);
		QueryResult resultOld = this.system.executeQuery(inputOld);
		SuchErgebnis resultNeu = transformOUTPUT( resultOld );
		return resultNeu;
	}
	
	private QueryObject transformINPUT( SuchAuftrag auftrag ) {
		// Transformation SuchAuftrag --> QueryObject
		return null;
	}
	
	private SuchErgebnis transformOUTPUT( QueryResult result ) {
		// Transformation QueryResult --> SuchErgebnis
		return null;
	}
	


	


}
