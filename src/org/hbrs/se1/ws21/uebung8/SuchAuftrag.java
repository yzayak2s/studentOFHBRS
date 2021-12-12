package org.hbrs.se1.ws21.uebung8;

public class SuchAuftrag {
    private String[] uebergabeParameter;


    public SuchAuftrag(){

    }

    public void setUebergabeParameter(String[] uebergabeParameter) {
        this.uebergabeParameter = uebergabeParameter;
    }

    public String[] getUebergabeParameter() {
        return uebergabeParameter;
    }

    public void convertParameter(SuchAuftrag s, QueryObject q){
        String[] p = s.getUebergabeParameter();
        q.setQueryParameters(p);
    }

}
