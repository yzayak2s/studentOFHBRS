package org.hbrs.se1.ws21.uebung4.model;


import java.util.ArrayList;
import java.util.List;

public class Employee implements java.io.Serializable, Comparable<Employee>, Member {

    private String vorname;
    private String name;
    private Integer pid;
    private String abteilung;
    private String rolle;
    private List<Object> expertise = new ArrayList<>();
    private List<Integer> expertisenGrad = new ArrayList<>();

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

    public List<Object> getExpertise() {
        return expertise;
    }

    public void setExpertise(List<Object> expertise) {
        this.expertise = expertise;
    }

    public List<Integer> getExpertisenGrad() {
        return expertisenGrad;
    }

    public void setExpertisenGrad(List<Integer> expertisenGrad) {
        this.expertisenGrad = expertisenGrad;
    }

    @Override
    public String toString(){
        return ("Mitarbeiter-ID: "+ getPid() +", Name: " + getVorname() + " " + getName() + ", Rolle: " + getRolle()) +", Abteilung: " +getAbteilung();
    }

    @Override
    public int compareTo(Employee e) {
        return this.pid.compareTo(e.pid); // Werte: 0, 1, -1 --> Pid vergleichen!
    }
}

