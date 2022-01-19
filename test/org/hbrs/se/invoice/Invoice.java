package org.hbrs.se.invoice;

public class Invoice {
    private int sum;
    private String currency;

    public Invoice( int sum, String currency ){
        this.sum = sum;
        this.currency = currency;
    }


    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

}


