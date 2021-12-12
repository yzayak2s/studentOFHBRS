package org.hbrs.se1.ws21.uebung8;

public class ReiseAnbieterAdapter {

    SuchErgebnis suche(SuchAuftrag r){
        for (Object : r
             ) {
            if (SuchAuftrag.contains(filter[x])){
                SuchErgebnis suchErgebnis = filter[x];
            }
        }
    }
    private QueryObject convertIN(SuchAuftrag r){
        QueryObject q = new QueryObject();
        r.convertParameter(r,q);
        return q;
    }
    private SuchAuftrag convertOUT(QueryResult q) {
        SuchAuftrag s = new SuchAuftrag();
        q.convertParameter(s, q);
        return s;
    }

    
}

