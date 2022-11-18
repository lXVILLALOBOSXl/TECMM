package com.dto;

import com.dao.SalesmanDAO;

public class Saleman extends Person{
    private int id;
    private String area;
    private double comnissionPercentage;
    private double salary;
    private int sales;


    public Saleman(String name, String firstLastName, String secondLastName, Date birthday, String area, double comnissionPercentage, double salary) {
        super(name, firstLastName, secondLastName, birthday);
        int id = SalesmanDAO.getSalesMen().size();
        this.id = ++id;
        this.area = area;
        this.comnissionPercentage = comnissionPercentage;
        this.salary = salary;
        this.sales = 0;
    }

    /**
     * When a saleman make a sale, the info have to be updated
     * @param saleAmount
     */
    public void sale(double saleAmount){
        ++this.sales;
        this.salary += (saleAmount*(this.comnissionPercentage/100));
        SalesmanDAO.update(this);
    }

    public int getId() {
        return id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public double getComnissionPercentage() {
        return comnissionPercentage;
    }

    public void setComnissionPercentage(double comnissionPercentage) {
        this.comnissionPercentage = comnissionPercentage;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.toString() + "[" +
                "Saleman{" +
                "id=" + id +
                ", area='" + area + '\'' +
                ", comnissionPercentage=" + comnissionPercentage +
                ", salary=" + salary +
                ", sales=" + sales +
                "}]";
    }
}
