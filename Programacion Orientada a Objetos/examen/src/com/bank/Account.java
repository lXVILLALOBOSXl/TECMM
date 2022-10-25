package com.bank;

import java.util.Date;

public class Account {

    private int accountNumber;
    private double balance;
    private Date creationDate;
    private Client client;
    private static int accountsNumber = 0;


    public Account(double balance, Date creationDate, Client client) {
        this.accountNumber = ++Account.accountsNumber;
        this.balance = balance;
        this.creationDate = creationDate;
        this.client = client;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", balance=" + balance +
                ", creationDate=" + creationDate +
                ", client=" + client +
                '}';
    }
}
