package org.hbrs.se1.ws21.uebung4.model;


import java.util.List;

public class Employee implements java.io.Serializable, Comparable, Member {

    private String vorname;
    private String name;
    private Integer pid;
    private String abteilung;
    private String rolle;
    private List<Object> expertise1 = null;
    private List<Object> expertise2 = null;
    private List<Object> expertise3 = null;

    public String getAbteilung() {
        return abteilung;
    }

    public void setAbteilung(String abteilung) {
        this.abteilung = abteilung;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getRolle() {
        return rolle;
    }

    public void setRolle(String rolle) {
        this.rolle = rolle;
    }

    public List<Object> getExpertise1() {
        return expertise1;
    }

    public void setExpertise1(List<Object> expertise1) {
        this.expertise1 = expertise1;
    }

    public List<Object> getExpertise2() {
        return expertise2;
    }

    public void setExpertise2(List<Object> expertise2) {
        this.expertise2 = expertise2;
    }

    public List<Object> getExpertise3() {
        return expertise3;
    }

    public void setExpertise3(List<Object> expertise3) {
        this.expertise3 = expertise1;
    }

    public String toString(){
        return ("Mitarbeiter-ID: "+ getPid() +", Name: " + getVorname() + " " + getName() + ", Rolle: " + getRolle()) +", Abteilung: " +getAbteilung();
    }


    @Override
    public int compareTo(Object o) {
        return 0; // Werte: 0, 1, -1 --> Pid vergleichen!
    }
}

