package org.hbrs.se1.ws21.uebung4.model;

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
	private List<Employee> employeeListe = null;
	private List<Sprint> sprintList = null;
	
	// Statische Klassen-Variable, um die Referenz
	// auf das einzige Container-Objekt abzuspeichern
	// Diese Variante sei thread-safe, so hat Hr. P. es gehört... stimmt das? --> JA!
	// Nachteil: ggf. hoher Speicherbedarf, da Singleton zu Programmstart schon erzeugt
	private static Container instance = new Container();
	
	// URL der Datei, in der die Objekte gespeichert werden
	final static String LOCATION2 = "allsprints1.ser";

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
		employeeListe = new ArrayList<Employee>();
		sprintList = new ArrayList<Sprint>();
	}
	
	/**
	 * Start-Methoden zum Starten des Programms 
	 * (hier koennen ggf. weitere Initialisierungsarbeiten gemacht werden spaeter)
	 */
	//public static void main (String[] args) throws Exception {
	//	Container con = Container.getInstance();
	//	con.startEingabe();
	//}
	
	/*
	 * Diese Methode realisiert eine Eingabe ueber einen Scanner
	 * Alle Exceptions werden an den aufrufenden Context (hier: main) weitergegeben (throws)
	 * Das entlastet den Entwickler zur Entwicklungszeit und den Endanwender zur Laufzeit
	 * startEingabe()-Methode befindet sich nun in der Klasse CommandHandler!
	 */
	//public void startEingabe() throws ContainerException, Exception {
		//
	//	String strInput = null;
		//
	//	// Initialisierung des Eingabe-View
	//	Scanner scanner = new Scanner(System.in);
		//
	//	// Ausgabe eines Texts zur Begruessung
	//	System.out.println("Employee-Tool V1.1 by yzayak2s & rfalke2s");
		//
	//	while (true) {
	//
	//		System.out.print("> ");
	//
	//		strInput = scanner.nextLine();
	//
	//		// Extrahiert ein Array aus der Eingabe
	//		String[] strings = strInput.split(" ");
	//
	//
	//
	//		if (strings[0].equals("store")) {
	//			this.storeEmpl();
	//		}
	//		// Anwendung beenden, Scanner schließen
	//		if (strings[0].equals("exit")) {
	//			scanner.close();
	//			break;
	//		}
	//		if (strings[0].equals("search")) {
	//			List<Employee> tmp = new ArrayList<>();
	//			for (Employee employee : employeeListe) {
	//				for (int i = 0; i < employee.getExpertise().size(); i++) {
	//					if (strings[1].equals(employee.getExpertise().get(i))) {
	//						tmp.add(employee);
	//					}
	//				}
	//			}
	//			startAusgabeEmpl(tmp, strings[1]);
	//		}
	//		if (strings[0].equals("load")) {
	//			try {
	//				if (strings[1].equals("force")) {
	//					employeeListe = null;
	//					this.loadEmpl();
	//				} else if (strings[1].equals("merge")) {
	//					List<Employee> tmp = getCurrentListEmpl();    // zwischenzeitliches speichern der aktuellen Liste im Container
	//					loadEmpl();                                    // ersetzen der liste durch die liste im File
	//					for (Employee employee : tmp) {
	//						int counter = 0;
	//						int tempID = employee.getPid();
	//						for(Employee e: Container.getInstance().getCurrentListEmpl()) {
	//							if(e.getPid()!= tempID){
	//								counter++;
	//							}
	//						}
	//						if (counter==Container.getInstance().getCurrentListEmpl().size()) {
	//							employeeListe.add(employee);   // hinzufügen der temporär gespeicherten Mitarbeiter sofern noch nicht im Speicher
	//						}
	//						else {
	//							System.out.println("ID: " + tempID + " bereits vergeben! Wollen sie die ID überschreiben?");
	//							Scanner sc = new Scanner(System.in);
	//							if(sc.next().toUpperCase().equals("JA")) {
	//								for (Employee e : employeeListe) {
	//									if (e.getPid() == tempID) {
	//										employeeListe.remove(e);		// Element mit derselben Nummer löschen
	//										employeeListe.add(employee);	// Das Element aus dem File hinzufügen
	//										break;
	//									}
	//									else{}
	//								}
	//							}
	//							else {}
	//						}
	//					}
	//				}
	//				else{
	//					System.out.println("Unbekannter Befehl! Mögliche Befehle: load force, load merge");
	//				}
	//			}
	//			catch(ArrayIndexOutOfBoundsException e){
	//					System.out.println("Geben Sie bitte die Variante des Ladens als 2. Parameter an (load force oder load merge).");
	//				}
	//
	//
	//			}
	//		}
	//	}

	/**
	 * Diese Methode realisiert die Ausgabe.
	 */
	public void startAusgabeEmpl(List<Employee> listEmployees, String orderBy) {
		// TODO: 19.03.22 Optionale Ueberarbeitung: "dump" wird hier und in der Methode "bubbleSort()" als orderBy-Option verwendet
		// [Variante mit forEach-Methode / Streams (--> Kapitel 9, Lösung Übung Nr. 2)?
		//  Gerne auch mit Beachtung der neuen US1
		// (Filterung Abteilung = "ein Wert (z.B. Marketing)"
		List<String> filterListe = listEmployees.stream()		// Filter nach Rennfahrer und ID < 100
		//		.filter( employee -> employee.getRolle().equals("Rennfahrer") )
		//		.filter (employee ->  employee.getPid() < 100 )
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
		else if (orderBy.equals("planProzent")){

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

	public void startAusgabeSpr(List<Sprint> sprintList){
		for (Sprint sprint : sprintList) { // Lösung mit Sprint For each:
			System.out.println(sprint.toString()); //Ausgabe auf der Konsole
		}
		//List<String> listSprint = this.sprintList.stream()
		//		.map(sprint -> sprint.getName())
		//		.collect(Collectors.toList()); // sortieren nach Alphabet
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
	// TODO: 28.03.22 Entferne Methode
	//private void storeEmpl() throws ContainerException{
	//	ObjectOutputStream oos = null;
	//	FileOutputStream fos = null;
	//	try {
	//		fos = new FileOutputStream( Container.LOCATION );
	//		oos = new ObjectOutputStream(fos);
	//
	//		oos.writeObject( this.employeeListe);
	//		System.out.println( this.sizeEmpl() + " Employee/s wurde/n erfolgreich gespeichert!");
	//	}
	//	catch (IOException e) {
	//		e.printStackTrace();
	//	  //  Delegation in den aufrufendem Context
	//	  // (Anwendung Pattern "Chain Of Responsibility)
	//	  throw new ContainerException("Fehler beim Abspeichern");
	//	}
	//}

	// TODO: 28.03.22 Entferne Methode
	//public static void storeEmployee() throws ContainerException{
	//	Container.getInstance().storeEmpl();
	//}

	// TODO: 28.03.22 Entferne Methode
	private void storeSpr() throws ContainerException{
		ObjectOutputStream oos = null;
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream( Container.LOCATION2 );
			oos = new ObjectOutputStream(fos);

			oos.writeObject( this.sprintList );
			System.out.println( this.sizeSpr() + " Sprint/s wurde/n erfolgreich gespeichert!");
		}
		catch (IOException e) {
			e.printStackTrace();
			//  Delegation in den aufrufendem Context
			// (Anwendung Pattern "Chain Of Responsibility)
			throw new ContainerException("Fehler beim Abspeichern");
		}
	}

	// TODO: 28.03.22 Entferne Methode
	public static void storeSprint() throws ContainerException{
		Container.getInstance().storeSpr();
	}

	/*
	 * Methode zum Laden der Liste. Es wird die komplette Liste
	 * inklusive ihrer gespeicherten Employee-Objekte geladen.
	 * 
	 */

	// TODO: 28.03.22 Entferne Methode
	//public void loadEmpl() {
	//	ObjectInputStream ois = null;
	//	FileInputStream fis = null;
	//	try {
	//	  fis = new FileInputStream( Container.LOCATION );
	//	  ois = new ObjectInputStream(fis);
	//	  // Auslesen der Liste
	//	  Object obj = ois.readObject();
	//	  if (obj instanceof List<?>) {
	//		  this.employeeListe = (List) obj;
	//	  }
	//	  System.out.println("Es wurde/n " + this.sizeEmpl() + " Mitarbeiter erfolgreich hochgeladen!");
	//	}
	//	catch (IOException e) {
	//		System.out.println("LOG (für Admin): Datei konnte nicht gefunden werden!");
	//	}
	//	catch (ClassNotFoundException e) {
	//		System.out.println("LOG (für Admin): Liste konnte nicht extrahiert werden (ClassNotFound)!");
	//	}
	//	finally {
	//	  if (ois != null) try { ois.close(); } catch (IOException e) {}
	//	  if (fis != null) try { fis.close(); } catch (IOException e) {}
	//	}
	//}

	/*
	 * Methode zum Laden der Liste. Es wird die komplette Liste
	 * inklusive ihrer gespeicherten Sprints-Objekte geladen.
	 *
	 */
	public void loadSpr() {
		ObjectInputStream ois = null;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream( Container.LOCATION2 );
			ois = new ObjectInputStream(fis);
			// Auslesen der Liste
			Object obj = ois.readObject();
			if (obj instanceof List<?>) {
				this.sprintList = (List) obj;
			}
			System.out.println("Es wurde/n " + this.sizeSpr() + " Sprint/s erfolgreich hochgeladen!");
		}
		catch (IOException e) {
			System.out.println("LOG (für Admin): Datei konnte nicht gefunden werden!");
			System.out.println();
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
		employeeListe.add(employee);
	}

	/**
	 * Prüft, ob ein Employee bereits vorhanden ist
	 * @param employee
	 * @return
	 */
	private boolean contains(Employee employee) {
		int ID = employee.getPid();
		for ( Employee emp : employeeListe) {
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
	public int sizeEmpl() {
		return employeeListe.size();
	}

	/**
	 * Ermittlung der Anzahl von internen Employee-Objekten
	 * @return
	 */
	public int sizeSpr() {
		return sprintList.size();
	}

	/**
	 * Methode zur Rückgabe der aktuellen Liste mit Stories
	 * Findet aktuell keine Anwendung bei Hr. P.
	 * @return
	 */
	public List<Employee> getCurrentListEmpl() {
		return this.employeeListe;
	}

	public List<Sprint> getCurrentListSpr() {
		return this.sprintList;
	}

	public void setListeEmpl(List<Employee> liste) {
		this.employeeListe = liste;
	}

	public void setListeSpr(List<Sprint> sprintList) {
		this.sprintList = sprintList;
	}

	/**
	 * Liefert einen bestimmten Employee zurück
	 * @param id
	 * @return
	 */
	private Employee getEmployee(int id) {
		for ( Employee employee : employeeListe) {
			if (id == employee.getPid() ){
				return employee;
			}
		}
		return null;
	}

	public static Employee getSpecEmployee(int getSpecEmployee){
		return Container.getInstance().getEmployee(getSpecEmployee);
	}

	public boolean checkName(String sprint){
			for(Sprint sprintFromList : sprintList){
				if(sprint.equals(sprintFromList.getName())){
					return true;
				}
			} return false;
	}

	public void addSprint ( Sprint sprint ) throws ContainerException {
		if (checkName(sprint.getName())) {
			ContainerException ex = new ContainerException("Sprint bereits vorhanden!");
			throw ex;
		}
		sprint.setSid(sprintList.size()+1);
		sprintList.add(sprint);
	}

	public List<Sprint> getSprintList() {
		return sprintList;
	}

	public void deleteSprintList(String sprintName){
		for(Sprint sprintFromList : sprintList){
			if(sprintName.equals(sprintFromList.getName())){
				getSprintList().remove(sprintFromList);
			}
		}
	}
	public Sprint getSprintFromName(String sprint_name) {

		for (Sprint sprintFromList : sprintList) {
			if(sprint_name.equals(sprintFromList.getName())){
				return sprintFromList;
			}
		}
		throw new IndexOutOfBoundsException("Kein Sprint mit dem Namen \""+ sprint_name +"\" vorhanden.");
	}

	public Employee getEmployeeFromId(String employee_Id) {

		for (Employee employeeFromList : employeeListe) {
			if(employee_Id.equals(employeeFromList.getName())){
				return employeeFromList;
			}
		}
		throw new IndexOutOfBoundsException("Kein Mitarbeiter mit der ID \""+ employee_Id +"\" vorhanden.");
	}
}