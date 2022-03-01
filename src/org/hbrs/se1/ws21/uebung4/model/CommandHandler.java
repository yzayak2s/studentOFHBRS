package org.hbrs.se1.ws21.uebung4.model;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/*
 * Invoker (laut Command Pattern)
 */
public class CommandHandler {
	public static Command commandHashMap(String[] parameter){
		// füllen des String Arrays auf maximale mögliche größe
		if (parameter.length -1 < 4) {
			String[] temp = new String[4];
			for (int i = 0; i < 4; i++) {

				if (i < parameter.length) {
					temp[i] = parameter[i];
				} else {
					temp[i] = "none";
				}

			}
			parameter = temp;
		}
		for (int i = 0; i < parameter.length; i++) {
			System.out.println(parameter[i]);
		}
		// Initialisierung der Kommandos
		HashMap<String, Command> commandsMap = new HashMap();
		commandsMap.put( "help" , new HelpCommand() );
		commandsMap.put(  "dump"  , new DumpCommand() );
		commandsMap.put(  "enter"  , new EnterCommand(parameter) );
		commandsMap.put(  "load"  , new LoadCommand(parameter[1]) );
		commandsMap.put(  "show"  , new ShowCommand(parameter[1]) );
		//Default Parameter von load
		//commandsMap.put(  "dump"  , new DumpCommand() );
		//commandsMap.put(  "dump"  , new DumpCommand() );
		//commandsMap.put(  "dump"  , new DumpCommand() );
		return commandsMap.get(parameter[0]);
	}
	public static void startEingabe()  {

		String strInput = null;

		// Initialisierung des Eingabe-View
		Scanner scanner = new Scanner( System.in );
		
		while ( true ) {
			// Print the prompt
			System.out.print("> ");

			// Naechster Befehl
			strInput = scanner.nextLine();
			String[] splited = strInput.split("\\s+");


			// KEINE IF-Anweisung oder Switch-Case-Statement mit N Zeilen
			// Anforderung: Auswahl des "Kommandos" in EINER Zeile
			// Verwendung des Command Pattern!

			Command command = commandHashMap(splited);
			command.execute();

			// Stack, zur Abspeicherung der ausgeführten Commandos
			Stack<Command> stack = new Stack();
			stack.push(command);

			// Ergänzungen: Rückgängig-Machung des letzten Befehls:
			//Command command1 = stack.pop();
		//	System.out.println("LOG: Command wurde zurückgeführt!");
		//	command1.undo();




		}

	}

}
