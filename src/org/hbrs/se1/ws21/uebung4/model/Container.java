package org.hbrs.se1.ws21.uebung4.model;

import org.hbrs.se1.ws21.uebung4.control.EingabeDialog;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/*
 * Klasse zum Management sowie zur Eingabe unnd Ausgabe von Mitarbeitern (engl. Employees).
 * Die Anwendung wird über dies Klasse auch gestartet (main-Methode hier vorhanden)
 *
 * erstellt von Julius P., H-BRS 2021, Version 1.1
 *
 * Strategie für die Wiederverwendung (Reuse):
 * - Anlegen der Klasse Employee
 * - Anpassen des Generic in der List-Klasse (ALT: Member, NEU: Employee)
 * - Anpassen der Methodennamen
 *
 * (Was ist ihre Strategie zur Wiederverwendung?)
 * Klasse Employe implementiert Interface Member (Employee implements Member)
 * Vorteil: Wiederverwendung von Member, ID verwenden; Strenge Implementierung gegen Interface
 * Nachteil: Viele Casts notwendig, um auf die anderen Methoden zuzugreifen
 * Alternative: Container mit Generic entwickeln (z.B. Container<E>))
 * 
 */

public class Container {
	 
	// Interne ArrayList zur Abspeicherung der Objekte vom Type Employee
	private List<Employee> liste = null;
	
	// Statische Klassen-Variable, um die Referenz
	// auf das einzige Container-Objekt abzuspeichern
	// Diese Variante sei thread-safe, so hat Hr. P. es gehört... stimmt das? --> JA!
	// Nachteil: ggf. hoher Speicherbedarf, da Singleton zu Programmstart schon erzeugt
	private static Container instance = new Container();
	
	// URL der Datei, in der die Objekte gespeichert werden 
	final static String LOCATION = "allemployees1.ser";

	/**
	 * Liefert ein Singleton zurück.
	 * @return
	 */
	public static Container getInstance() {
		return instance;
	}
	
	/**
	 * Vorschriftsmäßiges Ueberschreiben des Konstruktors (private) gemaess Singleton-Pattern (oder?)
	 * Nun auf private gesetzt! Vorher ohne Access Qualifier (--> dann package-private)
	 */
	private Container(){
		liste = new ArrayList<Employee>();
	}
	
	/**
	 * Start-Methoden zum Starten des Programms 
	 * (hier koennen ggf. weitere Initialisierungsarbeiten gemacht werden spaeter)
	 */
	public static void main (String[] args) throws Exception {
		Container con = Container.getInstance();
		con.startEingabe(); 
	}
	
	/*
	 * Diese Methode realisiert eine Eingabe ueber einen Scanner
	 * Alle Exceptions werden an den aufrufenden Context (hier: main) weitergegeben (throws)
	 * Das entlastet den Entwickler zur Entwicklungszeit und den Endanwender zur Laufzeit
	 */
	public void startEingabe() throws ContainerException, Exception {

		String strInput = null;

		// Initialisierung des Eingabe-View
		Scanner scanner = new Scanner(System.in);

		// Ausgabe eines Texts zur Begruessung
		System.out.println("Employee-Tool V1.1 by yzayak2s & rfalke2s");

		while (true) {

			System.out.print("> ");

			strInput = scanner.nextLine();

			// Extrahiert ein Array aus der Eingabe
			String[] strings = strInput.split(" ");

			// 	Falls 'help' eingegeben wurde, werden alle Befehle ausgedruckt
			if ( strings[0].equals("help") ) {
				System.out.println("Folgende Befehle stehen zur Verfuegung: help, dump....");
			}
			// Auswahl der bisher implementierten Befehle:
			if (strings[0].equals("dump")) {
				startAusgabe(liste, "dump");

			}
			// Auswahl der bisher implementierten Befehle:
			if (strings[0].equals("enter")) {
				// Daten einlesen ...
				// this.addEmployee( new Employee( data ) ) um das Objekt in die Liste einzufügen.
				this.addEmployee(EingabeDialog.eingabeDialog());
			}

			if (strings[0].equals("store")) {
				this.store();
			}
			// Anwendung beenden, Scanner schließen
			if (strings[0].equals("exit")) {
				scanner.close();
				break;
			}
			if (strings[0].equals("search")) {
				List<Employee> tmp = new ArrayList<>();
				for (Employee employee : liste) {
					for (int i = 0; i < employee.getExpertise().size(); i++) {
						if (strings[1].equals(employee.getExpertise().get(i))) {
							tmp.add(employee);
						}
					}
				}
				startAusgabe(tmp, strings[1]);
			}
			if (strings[0].equals("load")) {
				try {
					if (strings[1].equals("force")) {
						liste = null;
						this.load();
					} else if (strings[1].equals("merge")) {
						List<Employee> tmp = getCurrentList();    // zwischenzeitliches speichern der aktuellen Liste im Container
						load();                                    // ersetzen der liste durch die liste im File
						for (Employee employee : tmp) {
							int counter = 0;
							int tempID = employee.getPid();
							for(Employee e: Container.getInstance().getCurrentList()) {
								if(e.getPid()!= tempID){
									counter++;
								}
							}
							if (counter==Container.getInstance().getCurrentList().size()) {
								liste.add(employee);   // hinzufügen der temporär gespeicherten Mitarbeiter sofern noch nicht im Speicher
							}
							else {
								System.out.println("ID: " + tempID + " bereits vergeben! Wollen sie die ID überschreiben?");
								Scanner sc = new Scanner(System.in);
								if(sc.next().toUpperCase().equals("JA")) {
									for (Employee e : liste) {
										if (e.getPid() == tempID) {
											liste.remove(e);		// Element mit derselben Nummer löschen
											liste.add(employee);	// Das Element aus dem File hinzufügen
											break;
										}
										else{}
									}
								}
								else {}
							}
						}
					}
					else{
						System.out.println("Unbekannter Befehl! Mögliche Befehle: load force, load merge");
					}
				}
				catch(ArrayIndexOutOfBoundsException e){
						System.out.println("Geben Sie bitte die Variante des Ladens als 2. Parameter an (load force oder load merge).");
					}


				}
			}
		}



	/**
	 * Diese Methode realisiert die Ausgabe.
	 */
	public void startAusgabe(List<Employee> listEmployees, String orderBy) {
		// [Variante mit forEach-Methode / Streams (--> Kapitel 9, Lösung Übung Nr. 2)?
		//  Gerne auch mit Beachtung der neuen US1
		// (Filterung Abteilung = "ein Wert (z.B. Marketing)"
		List<String> filterListe = listEmployees.stream()		// Filter nach Rennfahrer und ID < 100
				.filter( employee -> employee.getRolle().equals("Rennfahrer") )
				.filter (employee ->  employee.getPid() < 100 )
				.map( employee -> employee.getName() )
				.collect(Collectors.toList());
		List<Employee> tmp = new ArrayList<>();
		for (Employee employee : listEmployees) {
			for (int i = 0; i < filterListe.size(); i++);
			if(filterListe.contains(employee.getName())) {		// falls Liste Name eines Employees enthält
				tmp.add(employee);
			}
		}
		listEmployees = tmp;
		try {
			bubbleSort(listEmployees, listEmployees.size(), orderBy);
		}
		catch (ContainerException e){
			System.out.println("Der Container ist leer!");
		}
		// Klassische Ausgabe ueber eine For-Each-Schleife
		if (orderBy.equals("dump")){
			for (Employee employee : listEmployees) {
				System.out.println(employee.toString());
			}
		}
		else {
			for (Employee employee : listEmployees) {
				for (int j = 0; j < employee.getExpertise().size(); j++) {    // Expertisengrad von j bekommen
					if (orderBy.equals(employee.getExpertise().get(j))) {
						int grad = employee.getExpertisenGrad().get(j);
						System.out.println("Expertise: " + orderBy + ", Expertisengrad: " + grad + " | " + employee.toString());
						}
					}
				}
			}



	}
	static void bubbleSort(List<Employee> employees, int n, String orderBy) throws ContainerException {
		if (n == 0) {
			throw new ContainerException("Container Empty");
		}
		if (n == 1)                     //passes are done
		{
			return;
		}
		for (int i = 0; i < n - 1; i++)       //iteration through unsorted elements
		{
			if (orderBy.equals("dump")) {
				if (employees.get(i).compareTo(employees.get(i + 1)) >= 1)      //prüft ob die ID von i > i+1
					{                           								// falls ja wird die Position getauscht
						Collections.swap(employees, i, i + 1);
					}
				}
			else {   // order by Keyword
				for (Employee employee : employees) {
					int v1 = 0;
					int v2 = 0;
					for (int j = 0; j < employees.get(i).getExpertise().size(); j++) {	// Expertisengrad von i bekommen
						if (orderBy.equals(employees.get(i).getExpertise().get(j))) {
							v1 = employees.get(i).getExpertisenGrad().get(j);
						}
					}
					for (int k = 0; k < employees.get(i+1).getExpertise().size(); k++) {	// Expertisengrad von i+1 bekommen
						if (orderBy.equals(employees.get(i+1).getExpertise().get(k))){
							v2 = employees.get(i+1).getExpertisenGrad().get(k);
						}
					}
					if(v2>v1){
						Collections.swap(employees, i, i + 1);				// falls nötig tauschen
					}
					if(v2==v1){															// falls gleich Sortierung nach ID
						if (employees.get(i).compareTo(employees.get(i + 1)) >= 1)      //prüft ob die ID von i > i+1
						{                           									// falls ja wird die Position getauscht
							Collections.swap(employees, i, i + 1);
						}
					}
				}
			}

			bubbleSort(employees, n - 1, orderBy);           //one pass done, proceed to the next
		}
	}

	/*
	 * Methode zum Speichern der Liste. Es wird die komplette Liste
	 * inklusive ihrer gespeicherten Employee-Objekte gespeichert.
	 * 
	 */
	private void store() throws ContainerException{
		ObjectOutputStream oos = null;
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream( Container.LOCATION );
			oos = new ObjectOutputStream(fos);
			
			oos.writeObject( this.liste );
			System.out.println( this.size() + " Employee wurden erfolgreich gespeichert!");
		}
		catch (IOException e) {
			e.printStackTrace();
		  //  Delegation in den aufrufendem Context
		  // (Anwendung Pattern "Chain Of Responsibility)
		  throw new ContainerException("Fehler beim Abspeichern");
		}
	}

	/*
	 * Methode zum Laden der Liste. Es wird die komplette Liste
	 * inklusive ihrer gespeicherten Employee-Objekte geladen.
	 * 
	 */
	public void load() {
		ObjectInputStream ois = null;
		FileInputStream fis = null;
		try {
		  fis = new FileInputStream( Container.LOCATION );
		  ois = new ObjectInputStream(fis);
		  // Auslesen der Liste
		  Object obj = ois.readObject();
		  if (obj instanceof List<?>) {
			  this.liste = (List) obj;
		  }
		  System.out.println("Es wurden " + this.size() + " Mitarbeiter erfolgreich reingeladen!");
		}
		catch (IOException e) {
			System.out.println("LOG (für Admin): Datei konnte nicht gefunden werden!");
		}
		catch (ClassNotFoundException e) {
			System.out.println("LOG (für Admin): Liste konnte nicht extrahiert werden (ClassNotFound)!");
		}
		finally {
		  if (ois != null) try { ois.close(); } catch (IOException e) {}
		  if (fis != null) try { fis.close(); } catch (IOException e) {}
		}
	}

	/**
	 * Methode zum Hinzufügen eines Mitarbeiters unter Wahrung der Schlüsseleigenschaft
	 * @param employee
	 * @throws ContainerException
	 */
	public void addEmployee ( Employee employee ) throws ContainerException {
		if ( contains(employee) == true ) {
			ContainerException ex = new ContainerException("ID bereits vorhanden!");
			throw ex;
		}
		liste.add(employee);
	}

	/**
	 * Prüft, ob ein Employee bereits vorhanden ist
	 * @param employee
	 * @return
	 */
	private boolean contains(Employee employee) {
		int ID = employee.getPid();
		for ( Employee emp : liste) {
			if ( emp.getPid() == ID ) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Ermittlung der Anzahl von internen Employee-Objekten
	 * @return
	 */
	public int size() {
		return liste.size();
	}

	/**
	 * Methode zur Rückgabe der aktuellen Liste mit Stories
	 * Findet aktuell keine Anwendung bei Hr. P.
	 * @return
	 */
	public List<Employee> getCurrentList() {
		return this.liste;
	}

	/**
	 * Liefert einen bestimmten Employee zurück
	 * @param id
	 * @return
	 */
	private Employee getEmployee(int id) {
		for ( Employee employee : liste) {
			if (id == employee.getPid() ){
				return employee;
			}
		}
		return null;
	}
}
