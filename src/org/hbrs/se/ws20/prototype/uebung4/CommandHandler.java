package org.hbrs.se.ws20.prototype.uebung4;

import java.util.HashMap;
import java.util.Scanner;

public class CommandHandler {
	
	public void startEingabe()  {
		
		String strInput = null;

		// Ansatz: Verwendung HashMap zur Verwaltung von KEY-VALUE-Paare
		// Verwendung des Command Pattern: Verwendung eine HashMap zur Verwaltung von Kommandos
		// KEY: alle Befehle wie z.B. enter, dump usw. (Type: String)
		// VALUE: Objektorientierte Präsentation eines Commandos, welches man ausführen kann
		HashMap<String, Command > commandHashMap = new HashMap<String, Command>();

		// Initialisierung
		// commandHashMap.put("enter" , new EnterCommand() );
		commandHashMap.put("dump" , new DumpCommand() );
		// ... alle n Commands registrieren

		// Initialisierung des Eingabe-View
		Scanner scanner = new Scanner( System.in );
		
		while ( true ) {
			// Print the prompt
			System.out.print( "> "  );
			// Naechster Befehl
			strInput = scanner.nextLine();

			// KEINE IF-Anweisung oder Switch-Case-Statement mit N Varianten
			// Anforderung: Auswahl des "Kommandos" in EINER Zeile

			Command command = commandHashMap.get( strInput );
			command.execute( null );

			// Befehlssatz zur Laufzeit anpassen
			commandHashMap.remove("dump");
			commandHashMap.put("ausgabe" ,  new DumpCommand() );

			// Befehl rückgängig machen (undo)
			command.undo();




		}
		

	}

}
