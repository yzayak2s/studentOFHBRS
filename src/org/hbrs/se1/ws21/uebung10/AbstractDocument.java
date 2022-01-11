package org.hbrs.se1.ws21.uebung10;

public abstract class AbstractDocument implements Document {
    private int id = 0;

    // Methoden
    public int getID(){
       return id;
    }
    public void setID(int id){
        this.id = id;
    }

}
