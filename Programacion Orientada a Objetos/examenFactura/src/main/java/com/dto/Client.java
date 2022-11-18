package com.dto;

import java.util.List;

public class Client extends Person{
    private static int clientNumber = 0;
    private int id;
    private String rfc;
    private String address;
    private List<Invoice> invoices;

    public Client(String name, String firstLastName, String secondLastName, Date birthday, String rfc, String address, List<Invoice> invoices) {
        super(name, firstLastName, secondLastName, birthday);
        this.id = ++clientNumber;
        this.rfc = rfc;
        this.address = address;
        this.invoices = invoices;
    }

    public int getId() {
        return id;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    @Override
    public String toString() {
        return super.toString() + "[" +
                "Client{" +
                "rfc='" + rfc + '\'' +
                ", address='" + address + '\'' +
                ", invoices=" + invoices +
                "}]";
    }
}
