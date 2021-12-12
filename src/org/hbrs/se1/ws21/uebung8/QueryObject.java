package org.hbrs.se1.ws21.uebung8;

public class QueryObject {
    private QueryObject query = null;
    private String[] queryParameters;
    public QueryObject(){

    }

    public void setQuery(QueryObject query) {
        this.query = query;
    }

    public QueryObject getQuery() {
        return query;
    }

    public void setQueryParameters(String[] queryParameters) {
        this.queryParameters = queryParameters;
    }
}
