package com.bank;

import java.util.Date;

public class Movement {

    private String kind;
    private Date date;
    private double amount;
    private double lastAmount;
    private double newAmount;

    public Movement(String kind, Date date, double amount, double lastAmount, double newAmount) {
        this.kind = kind;
        this.date = date;
        this.amount = amount;
        this.lastAmount = lastAmount;
        this.newAmount = newAmount;
    }



    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getLastAmount() {
        return lastAmount;
    }

    public void setLastAmount(double lastAmount) {
        this.lastAmount = lastAmount;
    }

    public double getNewAmount() {
        return newAmount;
    }

    public void setNewAmount(double newAmount) {
        this.newAmount = newAmount;
    }

    @Override
    public String toString() {
        return "Movement{" +
                "kind='" + kind + '\'' +
                ", date=" + date +
                ", amount=" + amount +
                ", lastAmount=" + lastAmount +
                ", newAmount=" + newAmount +
                '}';
    }
}
