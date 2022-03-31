package org.hbrs.se1.ws21.uebung4.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;
import java.util.Map.Entry;

public class PlanCommand implements Command {
    private final String[] parameter;

    public PlanCommand(String[] parameter) {
        this.parameter = parameter;
    }

    @Override
    public void execute() throws ContainerException, ParseException {
        // TODO: 21.03.22 plan sprint weiter implementieren
        if(parameter[3].equals("-all")){
            helperPlan(true);
        } else if (parameter[3].equals("none")){
            helperPlan(false);

        }
    }

    public void helperPlan(boolean showAllParameter) throws ContainerException, ParseException {
        HashMap<Employee, Double> matchList = new HashMap<>();
        if (Container.getInstance().checkName(parameter[2])) {
            for (Employee employee : Container.getInstance().getCurrentListEmpl()) {
                Sprint temp_sprint = Container.getInstance().getSprintFromName(parameter[2]);
                double matchPct = 0;
                double dateFactor = -1;
                for (Object sprExpertise : temp_sprint.getExpertise()) {
                    double gleichheitsfaktor = 0;
                    for (Object empExpertise : employee.getExpertise()) {
                        if (sprExpertise.equals(empExpertise)) {
                            gleichheitsfaktor = 1;
                        }
                        if (sprExpertise.toString().substring(0, 4).equals(empExpertise.toString().substring(0, 4))) {
                            if (gleichheitsfaktor < 0.8) {
                                gleichheitsfaktor = 0.8;
                            }
                        }
                    }
                    SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

                    try {
                        // parse Datum vom Typ String in Datums-Typ
                        Date dateEmpStart = formatter.parse(employee.getStartVerfuegbarkeit());
                        Date dateEmpEnd = formatter.parse(employee.getEndVerfuegbarkeit());
                        Date dateSprStart = formatter.parse(temp_sprint.getStartdate());
                        Date dateSprEnd = formatter.parse(temp_sprint.getEnddate());

                        if (dateSprEnd.before(dateEmpStart) || dateEmpEnd.before(dateSprStart)){
                            employee.setVerfuegbarkeit("nicht verfuegbar");
                            dateFactor = 0;
                        }
                        else if (dateSprStart.before(dateEmpStart) || dateEmpEnd.before(dateSprEnd) ){
                            employee.setVerfuegbarkeit("teilweise");
                            boolean start = false;
                            // eig longs statt double aber damit hat die rechnung iwie nicht funktioniert unterschied aber minimal
                            double lengthSprint = dateSprEnd.getTime() - dateSprStart.getTime();
                            double lengthSprintDays = (lengthSprint / (1000*60*60*24)) % 365;
                            double daysDifferenceStart = 0;
                            // Rechnung wv Prozentual da
                            if(dateSprStart.before(dateEmpStart)){
                                start = true;
                                double timeDifferenceStart = dateEmpStart.getTime() - dateSprStart.getTime();
                                daysDifferenceStart = (timeDifferenceStart / (1000*60*60*24)) % 365;
                                dateFactor = (lengthSprintDays-daysDifferenceStart)/lengthSprintDays;
                            }
                            if (dateEmpEnd.before(dateSprEnd)){
                                double timeDifferenceEnd = dateSprEnd.getTime() - dateEmpEnd.getTime();
                                double daysDifferenceEnd = (timeDifferenceEnd / (1000*60*60*24)) % 365;
                                dateFactor = (lengthSprintDays-daysDifferenceEnd)/lengthSprintDays;
                                if (start){
                                    dateFactor = (lengthSprintDays-(daysDifferenceStart+daysDifferenceEnd))/lengthSprintDays;
                                }
                            }
                        }
                        else{
                            dateFactor = 1;
                            employee.setVerfuegbarkeit("verfuegbar");
                        }
                        matchPct = matchPct + (100.0 / temp_sprint.getExpertise().size()) * gleichheitsfaktor;
                        // Uebergabe des Prozentualen-Anteils der Verfuegbarkeit an die Instanz-Methode setOvMatch() (siehe Employee-Klasse)
                        employee.setOvMatch(matchPct); // todo --> Ziel ist Prozentuale Angabe in der Ausgabe-Konsole "Overall Match"!

                    }
                    catch (ParseException e){
                        System.out.println("Datum im falschen Format. Verwenden sie enter start/end mit dem Format dd.MM.yyyy!");
                    }

                }
            if (showAllParameter || matchPct != 0) {
                matchPct = matchPct * dateFactor;
                matchPct = Math.round(matchPct);
                matchList.put(employee, matchPct);
            }
            }
        }
            else {
                System.out.println("Den angegebenen Sprint: \""+parameter[2]+ "\" gibt es nicht.");
            }


        System.out.println("Die folgenden Mitarbeiter sind für Ihren Sprint (nicht) geeignet: ");
        Map<Employee, Double> sortedMap = hashMapSort(matchList);
        printMap(sortedMap);

    }

    public Map<Employee, Double> hashMapSort(HashMap<Employee, Double> mapPct) {
        List<Entry<Employee, Double>> list = new LinkedList<>(mapPct.entrySet());
        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        Map<Employee, Double> sortedMap = new LinkedHashMap<>();
        for (Entry<Employee, Double> entry : list)
        {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }

    private static void printMap(Map<Employee, Double> map) {
        String format = "|%1$-20s|%2$-20s|%3$-20s|%n";
        System.out.format(format, "Vorname", "Nachname", "Treffer in %");
        System.out.format(format, "====================", "====================", "====================", "====================");
        map.forEach((key, value) -> System.out.format(format, key.getVorname(), key.getName(), value));
    }

    @Override
    public void undo() {

    }
}
