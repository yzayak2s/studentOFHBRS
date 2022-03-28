package org.hbrs.se1.ws21.uebung4.model;

import java.util.*;
import java.util.Map.Entry;

public class PlanCommand implements Command {
    private final String[] parameter;

    public PlanCommand(String[] parameter) {
        this.parameter = parameter;
    }

    @Override
    public void execute() throws ContainerException {
        // TODO: 21.03.22 plan sprint weiter implementieren
        if(parameter[3].equals("-all")){
            helperPlan(true);
        } else if (parameter[3].equals("none")){
            helperPlan(false);

        }
    }

    public void helperPlan(boolean showAllParameter) throws ContainerException {
        HashMap<Employee, Double> matchList = new HashMap<>();
        if (Container.getInstance().checkName(parameter[2])) {
            for (Employee employee : Container.getInstance().getCurrentListEmpl()) {
                Sprint temp_sprint = Container.getInstance().getSprintFromName(parameter[2]);
                double matchPct = 0;
                for (Object sprExpertise : temp_sprint.getExpertise()) {
                    double Gleichheitsfaktor = 0;
                    for (Object empExpertise : employee.getExpertise()) {
                        if (sprExpertise.equals(empExpertise)) {
                            Gleichheitsfaktor = 1;
                        }
                        if (sprExpertise.toString().substring(0, 4).equals(empExpertise.toString().substring(0, 4))) {
                            if (Gleichheitsfaktor < 0.8) {
                                Gleichheitsfaktor = 0.8;
                            }
                        }
                    }
                    matchPct = matchPct + (100.0 / temp_sprint.getExpertise().size()) * Gleichheitsfaktor;
                    if (showAllParameter || matchPct != 0) {
                        matchList.put(employee, matchPct);
                    }

                }

            }
        }
            else {
                System.out.println("Den angegebenen Sprint: \""+parameter[2]+ "\" gibt es nicht.");
            }


        System.out.println("Die folgenden Mitarbeiter sind in der Filiale verfügbar (geeignet und nicht geeignet):");
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
        map.forEach((key, value) -> System.out.println("Mitarbeiter : " + key + " | Eignung für Sprint : " + value+"%"));
    }

    @Override
    public void undo() {

    }
}
