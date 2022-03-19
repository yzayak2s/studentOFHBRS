package org.hbrs.se1.ws21.uebung4.view;

import org.hbrs.se1.ws21.solutions.uebung2.Member;
import org.hbrs.se1.ws21.uebung4.model.Sprint;

import java.util.List;

public class SprintView {
    public void dumpSpr(List<Sprint> list1){
        for (Sprint sprint : list1) { // Lösung mit Member For each:
            System.out.println(sprint.toString()); //Ausgabe auf der Konsole
        }
    }
}
