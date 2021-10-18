package org.hbrs.se1.ws21.uebung2;


import java.util.ArrayList;

public class Container{
    ArrayList<Member> list = new ArrayList<>(); // Generische Klasse -> Generik
    public Container(){
        Container container = new Container();
    }

    public static Mitglied newMember(){
        return new Mitglied();
    }

    public void addMember(Member member) throws ContainerException { // (geprüfte Exception)
        // StackTrace: "„Das Member-Objekt mit der ID [hier die ID des Objekts] ist bereits vorhanden!“
        int id = member.getID();
        if (list.contains(member)){
            throw new ContainerException(member);
        }
        list.add(member);
    }

    public String deleteMember(int id){
        int sizeAlt = list.size();
        for(int i=0;i<list.size();i++){
            if (id == list.get(i).getID()){ // Paramater id == Id des Members an der i-ten Position
                list.remove(i);
            }
        }
        if( sizeAlt == list.size()){
            return "Das Member-Objekt mit der ID " + id + " ist nicht vorhanden!";
        }
        return "Das Member-Objekt mit der ID " + id + " wurde erfolgreich gelöscht!";
    }

    public void dump(){
        for (Member member : list) {
            System.out.println(member.toString()); //Ausgabe auf der Konsole
        }
    }

    public int size(){
        return list.size(); // Anzahl der Elemente in der ArrayList
    }
}
