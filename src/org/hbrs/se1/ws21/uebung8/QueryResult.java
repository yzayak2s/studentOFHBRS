package org.hbrs.se1.ws21.uebung8;

public class QueryResult {
    private String[] queryParameters;
    public QueryResult(){

    }

    public String[] getQueryParameters() {
        return queryParameters;
    }

    public void setQueryParameters(String[] queryParameters) {
        this.queryParameters = queryParameters;
    }
    public void convertParameter(SuchAuftrag s, QueryResult q){
        String[] p = q.getQueryParameters();
        s.setUebergabeParameter(p);
    }
}
