package com.bank;

import java.util.Date;

public class InversionAccount extends Account{

    private int term;
    private int interest;

    public InversionAccount(double balance, Date creationDate, Client client, int term, int interest) {
        super(balance, creationDate, client);
        this.term = term;
        this.interest = interest;
    }

    public void proyectInvertion(){
        System.out.println("With: " + this.interest + "% interest" + " and " + this.term + " months, is expexted you will win " + (this.getBalance() + (this.getBalance() * ((this.interest / 100) * (this.term / 100))) + "$"));
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public int getInterest() {
        return interest;
    }

    public void setInterest(int interest) {
        this.interest = interest;
    }

    @Override
    public String toString() {
        return super.toString() + " / InversionAccount{" +
                "term=" + term +
                ", interest=" + interest +
                '}';
    }
}
