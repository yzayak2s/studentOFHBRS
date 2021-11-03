package org.hbrs.se1.ws21.uebung4.view;

import org.hbrs.se1.ws21.uebung2.Member;

import java.util.List;

public class EmployeeView {

    public void dump(List<Member> list1){
        for (Member member : list1) { // Lösung mit Member For each:
            System.out.println(member.toString()); //Ausgabe auf der Konsole
        }
    }
}
