package com.bank;

import java.util.Date;

public class InversionAccount extends Account{

    private int term;
    private double interest;

    public InversionAccount(double balance, Date creationDate, Client client, int term, double interest) {
        super(balance, creationDate, client);
        this.term = term;
        this.interest = interest;
    }

    public void proyectInvertion(){
        System.out.println("With: " + this.interest + "% interest" + " and " + this.term + " months, is expexted you will win " + (this.getBalance() + (this.getBalance() * (this.interest / 100d) * (this.term / 100d) * 100d)) + "$");
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
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
