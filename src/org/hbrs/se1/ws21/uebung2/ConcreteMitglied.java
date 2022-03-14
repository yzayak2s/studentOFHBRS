package org.hbrs.se1.ws21.uebung2;
/**
 *
 * @author yzayak2s rfalke2s
 *
 */
public class ConcreteMitglied implements Member {

    private Integer id = null;

    @Override
    public Integer getID() {
        return id;
    }

    public ConcreteMitglied(int id) {
        this.id = id;
    }

    public void setID(Integer id) {
        this.id =id;
    }

    @Override
    public String toString(){
        return "ConcreteMember (ID = " + getID() + " )";
    }
}