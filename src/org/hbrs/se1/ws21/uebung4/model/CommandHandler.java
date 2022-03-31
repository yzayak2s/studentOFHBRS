package org.hbrs.se1.ws21.uebung4.model;

import java.text.ParseException;
import java.util.*;

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
		//for (int i = 0; i < parameter.length; i++) {
		//	System.out.println(parameter[i]);
		//}
		// Initialisierung der Kommandos
		HashMap<String, Command> commandsMap = new HashMap();
		commandsMap.put( "help" , new HelpCommand() );
		commandsMap.put( "dump"  , new DumpCommand() );
		commandsMap.put( "enter"  , new EnterCommand(parameter) );
		commandsMap.put( "delete", new DeleteCommand(parameter));
		commandsMap.put( "load"  , new LoadCommand(parameter) );
		commandsMap.put( "show"  , new ShowCommand(parameter) );
		commandsMap.put( "store"  , new StoreCommand(parameter) );
		commandsMap.put( "exit", new ExitCommand(parameter));
		commandsMap.put( "plan", new PlanCommand(parameter));
		commandsMap.put( "undo",  new UndoCommand());
		//Default Parameter von load
		//commandsMap.put(  "dump"  , new DumpCommand() );
		//commandsMap.put(  "dump"  , new DumpCommand() );
		//commandsMap.put(  "dump"  , new DumpCommand() );
		return commandsMap.get(parameter[0]);
	}

	public static void startEingabe() throws ContainerException, ParseException {
		Stack<Command> stack = new Stack();
		String strInput = null;

		// Initialisierung des Eingabe-View
		Scanner scanner = new Scanner( System.in );

		// Ausgabe eines Texts zur Begruessung
		System.out.println("Employee-Tool V2.1 by yzayak2s & rfalke2s");

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
			//try {
				command.execute();
			//} catch (NullPointerException e){
			//	System.out.println("Befehl nicht bekannt. Geben Sie bitte einen gültigen Befehl ein!\n" +
			//			"Geben Sie \"help\" ein, um eine Liste möglicher Befehle anzeigen zu lassen.");
			//}

			if(splited[0].equals("exit")){
				scanner.close();
				break;
			}

			// Stack, zur Abspeicherung der ausgeführten Commandos

			CommandList.addBefehl(command);
		}

	}

}