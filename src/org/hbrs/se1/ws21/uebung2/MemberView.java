package org.hbrs.se1.ws21.uebung2;

import java.util.List;

public class MemberView {
    public void dump(){
        dump(Container.getInstance().getCurrentList());
    }
    public void dump(List<Member> list1){
        for (Member member : list1) { // Lösung mit Member For each:
            System.out.println(member.toString()); //Ausgabe auf der Konsole
        }
    }
}
