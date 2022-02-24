package org.hbrs.se1.ws21.uebung4.model;

import java.util.ArrayList;
import java.util.List;

public class Sprint {
    private String name;
    private String startdate;
    private Integer sid; //Sprint ID
    private String enddate;
    private List<Object> expertise = new ArrayList<>();

    public List<Object> getExpertise() {
        return expertise;
    }

    public void setExpertise(List<Object> expertise) {
        this.expertise = expertise;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    @Override
    public String toString(){
        return ("Sprint ID: " + getSid() + ", Sprintname: "+ getName() +", Expertise/n: " + getExpertise() + ", Startdatum: " + getStartdate() + ", Enddatum: " + getEnddate());
    }
}
