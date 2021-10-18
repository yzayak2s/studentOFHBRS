package src.org.hbrs.se1.ws21.uebung2;

public class Mitglied implements Member {
    public int number;
    @Override
    public Integer getID() {
        return number;
    }

    public void setID(int number) {
        this.number=number;
    }
    public String toString(){
        return "Member (ID = " + getID() + " )";
    }
}