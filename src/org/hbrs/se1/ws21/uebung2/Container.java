package org.hbrs.se1.ws21.uebung2;

import org.hbrs.se1.ws21.uebung3.persistence.*;

import java.nio.channels.ConnectionPendingException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yzayak2s rfalke2s
 *
 */
public final class Container{
    /**
     * privates Klassenattribut,
     * wird beim erstmaligen Gebrauch (nicht beim Laden) der Klasse erzeugt
     */
    private static Container instance;

    /* Konstruktor ist privat, Klasse darf nicht von außen instanziiert werden. */

    private Container(){
        // Container container = new Container();
        list = new ArrayList<>(); // Generische Klasse -> Generik
    }

    /**
     * Statische Methode „getInstance()“ liefert die einzige Instanz der Klasse zurück.
     * Ist synchronisiert und somit thread-sicher.
     */
    //Threads Algortihmen die am Laufen sind -> mehrere Dinge/Programmabläufe Gleichzeitig
    public static Container getInstance()
    {
        if (instance == null)
        {
            instance = new Container();
        }
        return instance;
    }

    private List<Member> list; // instanzvariablen alle private setzen

    public static Mitglied newMember(int number){
        return new Mitglied(number);
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

    /*public void dump(){
        for (Member member : list) {
            System.out.println(member.toString()); //Ausgabe auf der Konsole
        }
    }*/

    public int size(){
        return list.size(); // Anzahl der Elemente in der ArrayList
    }

    public void store() throws PersistenceException{
        PersistenceStrategyStream<Member> persisStraStream = new PersistenceStrategyStream<Member>();
        persisStraStream.save(list);

    }

    public void load() throws PersistenceException{
        PersistenceStrategyStream<Member> persisStraStream = new PersistenceStrategyStream<Member>();
        persisStraStream.load();
        list = persisStraStream.load();
    }

    public List<Member> getCurrentList() {
        return list;
    }
}
