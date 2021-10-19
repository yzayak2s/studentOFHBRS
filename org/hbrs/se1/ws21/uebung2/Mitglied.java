package org.hbrs.se1.ws21.uebung2;
/**
 *
 * @author yzayak2s rfalke2s
 *
 */
public class Mitglied implements Member {

    public int number;
    @Override
    public Integer getID() {
        return number;
    }

    public Mitglied(int number) {
        this.number = number;
    }

    public void setID(int number) {
        this.number=number;
    }
    public String toString(){
        return "Member (ID = " + getID() + " )";
    }
}